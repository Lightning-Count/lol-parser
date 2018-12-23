package match.byMatchId;

public class Participant {
	
	private Stats stats;
	private int spell1Id;
	private int participantId;
	private String highestAchievedSeasonTier;
	private int spell2Id;
	private int teamId;
	private Timeline timeline;
	private int championId;
	
	public Stats getStats() {
		return stats;
	}
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	public int getSpell1Id() {
		return spell1Id;
	}
	public void setSpell1Id(int spell1Id) {
		this.spell1Id = spell1Id;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getHighestAchievedSeasonTier() {
		return highestAchievedSeasonTier;
	}
	public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
		this.highestAchievedSeasonTier = highestAchievedSeasonTier;
	}
	public int getSpell2Id() {
		return spell2Id;
	}
	public void setSpell2Id(int spell2Id) {
		this.spell2Id = spell2Id;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public Timeline getTimeline() {
		return timeline;
	}
	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
	public int getChampionId() {
		return championId;
	}
	public void setChampionId(int championId) {
		this.championId = championId;
	}
}
