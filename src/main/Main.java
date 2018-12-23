package main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import match.byMatchId.*;
import match.matchList.*;
import summoner.*;

public class Main {
	
	//Remember to update API key every 24 hours
	
	public static ExcelWriter excelWriter = new ExcelWriter();
	public static final String API = "?api_key=";
	
	public static void main(String[] args) throws Exception
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input account name:");
		String account = keyboard.nextLine();
		keyboard.close();
		findAccountId(account);
	}
	
	public static void findAccountId(String name) throws Exception
	{
		Gson gson = new Gson();
		Summoner summoner = null;
		
		name.replaceAll(" ", "%20");
		URL apiAccess = new URL("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name + API);
		BufferedReader in = new BufferedReader(new InputStreamReader(apiAccess.openStream()));
		
		String input;
		while((input = in.readLine()) != null)
		{
			summoner = gson.fromJson(input, Summoner.class);		
		}
		System.out.println(summoner.getAccountId());
		System.out.println(summoner.getPuuid());
		getMatches(summoner.getAccountId(), name);
		}
	
	public static void getMatches(String accountId, String summonerName) throws Exception
	{
		Gson gson = new Gson();
		MatchesList matchesList = null;
		Type matchListType = new TypeToken<MatchesList>(){}.getType();
		URL apiAccess = new URL("https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId + API);
		BufferedReader in = new BufferedReader(new InputStreamReader(apiAccess.openStream()));
		
		String input;
		while((input = in.readLine()) != null)
		{
			matchesList = gson.fromJson(input, matchListType);
		}
		
		List<MatchInfo> matchData = new ArrayList<>();
		for(int i = 0; i < 20; i++)
		{
			matchData.add(getMatchInfo(matchesList.getMatches().get(i).getGameId()));
		}
		excelWriter.recordMatchListInfo(matchesList);
		int rowNum = 2;
		for(MatchInfo matchInfo : matchData)
		{
			if(matchData.get(0) == matchInfo)
			{
				excelWriter.recordMatchInfoBySummoner(matchInfo, summonerName);
			}
			else
			{
				excelWriter.continueRecordMatchBySummoner(matchInfo, summonerName, rowNum);
				rowNum++;
			}
		}
	}
	
	public static MatchInfo getMatchInfo(long gameId) throws Exception
	{
		Gson gson = new Gson();
		MatchInfo matchInfo = null;
		Type matchInfoType = new TypeToken<MatchInfo>(){}.getType();
		URL apiAccess = new URL("https://na1.api.riotgames.com/lol/match/v4/matches/" + gameId + API);
		BufferedReader in = new BufferedReader(new InputStreamReader(apiAccess.openStream()));
		
		String input;
		while((input = in.readLine()) != null)
		{
			matchInfo = gson.fromJson(input, matchInfoType);
		}		
		
		return matchInfo;
	}
}