package match.byMatchId;

import match.byMatchId.deltas.*;

public class Timeline {
	
	private String lane;
	private int participantId;
	private CsDiffPerMinDelta csDiffPerMinDeltas;
	private XpDiffPerMinDelta xpDiffPerMinDeltas;
	private CreepsPerMinDelta creepsPerMinDeltas;
	private XpPerMinDelta xpPerMinDeltas;
	private String role;
	private DamageTakenDiffPerMinDelta damageTakenDiffPerMinDeltas;
	private DamageTakenPerMinDelta damageTakenPerMinDeltas;
	
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public CsDiffPerMinDelta getCsDiffPerMinDeltas() {
		return csDiffPerMinDeltas;
	}
	public void setCsDiffPerMinDeltas(CsDiffPerMinDelta csDiffPerMinDelta) {
		this.csDiffPerMinDeltas = csDiffPerMinDelta;
	}
	public XpDiffPerMinDelta getXpDiffPerMinDeltas() {
		return xpDiffPerMinDeltas;
	}
	public void setXpDiffPerMinDeltas(XpDiffPerMinDelta xpDiffPerMinDeltas) {
		this.xpDiffPerMinDeltas = xpDiffPerMinDeltas;
	}
	public CreepsPerMinDelta getCreepsPerMinDeltas() {
		return creepsPerMinDeltas;
	}
	public void setCreepsPerMinDeltas(CreepsPerMinDelta creepsPerMinDeltas) {
		this.creepsPerMinDeltas = creepsPerMinDeltas;
	}
	public XpPerMinDelta getXpPerMinDeltas() {
		return xpPerMinDeltas;
	}
	public void setXpPerMinDeltas(XpPerMinDelta xpPerMinDeltas) {
		this.xpPerMinDeltas = xpPerMinDeltas;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public DamageTakenDiffPerMinDelta getDamageTakenDiffPerMinDeltas() {
		return damageTakenDiffPerMinDeltas;
	}
	public void setDamageTakenDiffPerMinDeltas(DamageTakenDiffPerMinDelta damageTakenDiffPerMinDeltas) {
		this.damageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
	}
	public DamageTakenPerMinDelta getDamageTakenPerMinDeltas() {
		return damageTakenPerMinDeltas;
	}
	public void setDamageTakenPerMinDeltas(DamageTakenPerMinDelta damageTakenPerMinDeltas) {
		this.damageTakenPerMinDeltas = damageTakenPerMinDeltas;
	}
	
}
