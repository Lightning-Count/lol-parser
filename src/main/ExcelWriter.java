package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import match.byMatchId.*;
import match.matchList.*;

public class ExcelWriter{
	
	private HSSFWorkbook workbook;
	
	public ExcelWriter()
	{
		workbook = new HSSFWorkbook();
	}
	
	public void recordMatchListInfo(MatchesList matchesList) throws Exception
	{
		String[] columns = {"Match ID", "Timestamp", "Champion", "Role", 
			"Lane", "Platform ID", "Queue", "Season"};
		
		Sheet sheet = workbook.createSheet("Matches");
		
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);
        
        for(int i = 0; i < columns.length; i++)
        {
        	Cell cell = headerRow.createCell(i);
        	cell.setCellValue(columns[i]);
        	cell.setCellStyle(headerCellStyle);
        }
        
        int rowNum = 1;
        
        for(MatchHeader matchHeader: matchesList.getMatches())
        {
            Row row = sheet.createRow(rowNum++);
            
            row.createCell(0).setCellValue(matchHeader.getGameId());
            row.createCell(1).setCellValue(matchHeader.getTimestamp());
            row.createCell(2).setCellValue(matchHeader.getChampion());
            row.createCell(3).setCellValue(matchHeader.getRole());
            row.createCell(4).setCellValue(matchHeader.getLane());
            row.createCell(5).setCellValue(matchHeader.getPlatformId());
            row.createCell(6).setCellValue(matchHeader.getQueue());
            row.createCell(7).setCellValue(matchHeader.getSeason());
        }
        
        for(int i = 0; i < columns.length; i++)
        {
        	sheet.autoSizeColumn(i);
        }
        
        FileOutputStream fileOut = new FileOutputStream("new-spreadsheet.xls");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
	}
	
	public void recordMatchInfoBySummoner(MatchInfo matchInfo, String summonerName) throws Exception
	{
		String[] columns = {"Game ID", "Platform",
				"Game Mode", "Game Type", "Vision Score", "Wards Placed", "Magic Damage Dealt to Champions",
				"Physical Damage Dealt to Champions", "True Damage Dealt to Champions",
				"Total Damage Dealt to Objectives", "Total Physical Damage Dealt",  "Total Damage Dealt to Champions", 
				"Total Magic Damage Dealt", "Total True Damage Dealt", "Total Damage Dealt", "Total Time CC'd",
				"Total Time CC'ing Others", "Turrets Destroyed", "Gold Earned", "Gold Spent", "Longest Time Lived", "Total Damage Taken", 
				"Damage Self Mitigated", "Total Magic Damage Taken", "Total Physical Damage Taken", 
				"Total True Damage Taken", "Total Damage Healed", "Item 0", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", 
				"Champion Level", "Total Minions Killed", "Kills", "Deaths", "Assists",  "First Blood Assist", "Won?"};
	
		Sheet sheet = workbook.createSheet("Match Data");
		
	    Font headerFont = workbook.createFont();
	    headerFont.setBold(true);
	    headerFont.setFontHeightInPoints((short) 14);
	    headerFont.setColor(IndexedColors.RED.getIndex());
	    
	    CellStyle headerCellStyle = workbook.createCellStyle();
	    headerCellStyle.setFont(headerFont);
	
	    Row headerRow = sheet.createRow(0);
	    
	    for(int i = 0; i < columns.length; i++)
	    {
	    	Cell cell = headerRow.createCell(i);
	    	cell.setCellValue(columns[i]);
	    	cell.setCellStyle(headerCellStyle);
	    }
	    
	    Row row = sheet.createRow(1);
	            
        List<ParticipantIdentity> participantIdentities = matchInfo.getParticipantIdentities();
        int participantId = 0;
        for(int i = 0; i < participantIdentities.size(); i++)
        {
        	if((participantIdentities.get(i).getPlayer().getSummonerName().toLowerCase()).equals(summonerName.toLowerCase()))
        	{
        		participantId = participantIdentities.get(i).getParticipantId();
        		break;
        	}
        }
        
        List<Participant> participants = matchInfo.getParticipants();
        Participant participant = null;
        
        for(int i = 0; i< participants.size(); i++)
        {
        	if(participants.get(i).getParticipantId() == participantId)
        	{
        		participant = participants.get(i);
        		break;
        	}
        }
        
        row.createCell(0).setCellValue(matchInfo.getGameId());
        row.createCell(1).setCellValue(matchInfo.getPlatformId());
        row.createCell(2).setCellValue(matchInfo.getGameMode());
        row.createCell(3).setCellValue(matchInfo.getGameType());
        row.createCell(4).setCellValue(participant.getStats().getVisionScore());
        row.createCell(5).setCellValue(participant.getStats().getWardsPlaced());
        row.createCell(6).setCellValue(participant.getStats().getMagicDamageDealtToChampions());
        row.createCell(7).setCellValue(participant.getStats().getPhysicalDamageDealtToChampions());
        row.createCell(8).setCellValue(participant.getStats().getTrueDamageDealtToChampions());
        row.createCell(9).setCellValue(participant.getStats().getDamageDealtToObjectives());
        row.createCell(10).setCellValue(participant.getStats().getPhysicalDamageDealt());
        row.createCell(11).setCellValue(participant.getStats().getTotalDamageDealtToChampions());
        row.createCell(12).setCellValue(participant.getStats().getMagicDamageDealt());
        row.createCell(13).setCellValue(participant.getStats().getTrueDamageDealt());
        row.createCell(14).setCellValue(participant.getStats().getTotalDamageDealt());
        row.createCell(15).setCellValue(participant.getStats().getTotalTimeCrowdControlDealt());
        row.createCell(16).setCellValue(participant.getStats().getTimeCCingOthers());
        row.createCell(17).setCellValue(participant.getStats().getTurretKills());
        row.createCell(18).setCellValue(participant.getStats().getGoldEarned());
        row.createCell(19).setCellValue(participant.getStats().getGoldSpent());
        row.createCell(20).setCellValue(participant.getStats().getLongestTimeSpentLiving());
        row.createCell(21).setCellValue(participant.getStats().getTotalDamageTaken());
        row.createCell(22).setCellValue(participant.getStats().getDamageSelfMitigated());
        row.createCell(23).setCellValue(participant.getStats().getMagicalDamageTaken());
        row.createCell(24).setCellValue(participant.getStats().getPhysicalDamageTaken());
        row.createCell(25).setCellValue(participant.getStats().getTrueDamageTaken());
        row.createCell(26).setCellValue(participant.getStats().getTotalHeal());
        row.createCell(27).setCellValue(participant.getStats().getItem0());
        row.createCell(28).setCellValue(participant.getStats().getItem1());
        row.createCell(29).setCellValue(participant.getStats().getItem2());
        row.createCell(30).setCellValue(participant.getStats().getItem3());
        row.createCell(31).setCellValue(participant.getStats().getItem4());
        row.createCell(32).setCellValue(participant.getStats().getItem5());
        row.createCell(33).setCellValue(participant.getStats().getItem6());
        row.createCell(34).setCellValue(participant.getStats().getChampLevel());
        row.createCell(35).setCellValue(participant.getStats().getTotalMinionsKilled());
        row.createCell(36).setCellValue(participant.getStats().getKills());
        row.createCell(37).setCellValue(participant.getStats().getDeaths());
        row.createCell(38).setCellValue(participant.getStats().getAssists());
        row.createCell(39).setCellValue(participant.getStats().getFirstBloodAssist());
        row.createCell(40).setCellValue(participant.getStats().isWin());
        
        for(int i = 0; i < columns.length; i++)
        {
        	sheet.autoSizeColumn(i);
        }


        FileOutputStream fileOut = new FileOutputStream("new-spreadsheet.xls");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();	   
	}
	
	public void continueRecordMatchBySummoner(MatchInfo matchInfo, String summonerName, int rowNum) throws Exception
	{
		FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\alexi\\Documents\\Brian100T\\LolParser\\new-spreadsheet.xls"));
		Workbook workbook = WorkbookFactory.create(inputStream);		
		Sheet sheet = workbook.getSheetAt(1);
		
        List<ParticipantIdentity> participantIdentities = matchInfo.getParticipantIdentities();
        int participantId = 0;
        for(int i = 0; i < participantIdentities.size(); i++)
        {
        	if((participantIdentities.get(i).getPlayer().getSummonerName().toLowerCase()).equals(summonerName.toLowerCase()))
        	{
        		participantId = participantIdentities.get(i).getParticipantId();
        		break;
        	}
        }
        
        List<Participant> participants = matchInfo.getParticipants();
        Participant participant = null;
        
        for(int i = 0; i< participants.size(); i++)
        {
        	if(participants.get(i).getParticipantId() == participantId)
        	{
        		participant = participants.get(i);
        		break;
        	}
        }
        
        Row row = sheet.createRow(rowNum);
        
        row.createCell(0).setCellValue(matchInfo.getGameId());
        row.createCell(1).setCellValue(matchInfo.getPlatformId());
        row.createCell(2).setCellValue(matchInfo.getGameMode());
        row.createCell(3).setCellValue(matchInfo.getGameType());
        row.createCell(4).setCellValue(participant.getStats().getVisionScore());
        row.createCell(5).setCellValue(participant.getStats().getWardsPlaced());
        row.createCell(6).setCellValue(participant.getStats().getMagicDamageDealtToChampions());
        row.createCell(7).setCellValue(participant.getStats().getPhysicalDamageDealtToChampions());
        row.createCell(8).setCellValue(participant.getStats().getTrueDamageDealtToChampions());
        row.createCell(9).setCellValue(participant.getStats().getDamageDealtToObjectives());
        row.createCell(10).setCellValue(participant.getStats().getPhysicalDamageDealt());
        row.createCell(11).setCellValue(participant.getStats().getTotalDamageDealtToChampions());
        row.createCell(12).setCellValue(participant.getStats().getMagicDamageDealt());
        row.createCell(13).setCellValue(participant.getStats().getTrueDamageDealt());
        row.createCell(14).setCellValue(participant.getStats().getTotalDamageDealt());
        row.createCell(15).setCellValue(participant.getStats().getTotalTimeCrowdControlDealt());
        row.createCell(16).setCellValue(participant.getStats().getTimeCCingOthers());
        row.createCell(17).setCellValue(participant.getStats().getTurretKills());
        row.createCell(18).setCellValue(participant.getStats().getGoldEarned());
        row.createCell(19).setCellValue(participant.getStats().getGoldSpent());
        row.createCell(20).setCellValue(participant.getStats().getLongestTimeSpentLiving());
        row.createCell(21).setCellValue(participant.getStats().getTotalDamageTaken());
        row.createCell(22).setCellValue(participant.getStats().getDamageSelfMitigated());
        row.createCell(23).setCellValue(participant.getStats().getMagicalDamageTaken());
        row.createCell(24).setCellValue(participant.getStats().getPhysicalDamageTaken());
        row.createCell(25).setCellValue(participant.getStats().getTrueDamageTaken());
        row.createCell(26).setCellValue(participant.getStats().getTotalHeal());
        row.createCell(27).setCellValue(participant.getStats().getItem0());
        row.createCell(28).setCellValue(participant.getStats().getItem1());
        row.createCell(29).setCellValue(participant.getStats().getItem2());
        row.createCell(30).setCellValue(participant.getStats().getItem3());
        row.createCell(31).setCellValue(participant.getStats().getItem4());
        row.createCell(32).setCellValue(participant.getStats().getItem5());
        row.createCell(33).setCellValue(participant.getStats().getItem6());
        row.createCell(34).setCellValue(participant.getStats().getChampLevel());
        row.createCell(35).setCellValue(participant.getStats().getTotalMinionsKilled());
        row.createCell(36).setCellValue(participant.getStats().getKills());
        row.createCell(37).setCellValue(participant.getStats().getDeaths());
        row.createCell(38).setCellValue(participant.getStats().getAssists());
        row.createCell(39).setCellValue(participant.getStats().getFirstBloodAssist());
        row.createCell(40).setCellValue(participant.getStats().isWin());

        for(int i = 0; i < 41; i++)
        {
        	sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream("new-spreadsheet.xls");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
	}
}


