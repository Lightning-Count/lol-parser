package match.byMatchId;

import java.util.List;

public class MatchInfo
{
	private int seasonId;
	private int queueId;
	private long gameId;
	private List<ParticipantIdentity> participantIdentities;
	private String gameVersion;
	private String platformId;
	private String gameMode;
	private int mapId;
	private String gameType;
	private List<Team> teams;
	private List<Participant> participants;
	private int gameDuration;
	private long gameCreation;
	public int getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}
	public int getQueueId() {
		return queueId;
	}
	public void setQueueId(int queueId) {
		this.queueId = queueId;
	}
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public List<ParticipantIdentity> getParticipantIdentities() {
		return participantIdentities;
	}
	public void setParticipantIdentities(List<ParticipantIdentity> participantIdentities) {
		this.participantIdentities = participantIdentities;
	}
	public String getGameVersion() {
		return gameVersion;
	}
	public void setGameVersion(String gameVersion) {
		this.gameVersion = gameVersion;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public List<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	public int getGameDuration() {
		return gameDuration;
	}
	public void setGameDuration(int gameDuration) {
		this.gameDuration = gameDuration;
	}
	public long getGameCreation() {
		return gameCreation;
	}
	public void setGameCreation(long gameCreation) {
		this.gameCreation = gameCreation;
	}

	
}
