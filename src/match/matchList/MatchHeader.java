package match.matchList;

public class MatchHeader {

private String lane;
private Long gameId;
private Long champion;
private String platformId;
private String timestamp;
private Long queue;
private String role;
private Long season;

public String getLane() {
return lane;
}

public void setLane(String lane) {
this.lane = lane;
}

public Long getGameId() {
return gameId;
}

public void setGameId(Long gameId) {
this.gameId = gameId;
}

public Long getChampion() {
return champion;
}

public void setChampion(Long champion) {
this.champion = champion;
}

public String getPlatformId() {
return platformId;
}

public void setPlatformId(String platformId) {
this.platformId = platformId;
}

public String getTimestamp() {
return timestamp;
}

public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

public Long getQueue() {
return queue;
}

public void setQueue(Long queue) {
this.queue = queue;
}

public String getRole() {
return role;
}

public void setRole(String role) {
this.role = role;
}

public Long getSeason() {
return season;
}

public void setSeason(Long season) {
this.season = season;
}

}
