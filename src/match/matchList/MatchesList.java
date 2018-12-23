package match.matchList;

import java.util.List;

public class MatchesList {
	
	private List<MatchHeader> matches = null;
	private Long endIndex;
	private Long startIndex;
	private Long totalGames;

	public List<MatchHeader> getMatches() {
	return matches;
	}

	public void setMatches(List<MatchHeader> matches) {
	this.matches = matches;
	}

	public Long getEndIndex() {
	return endIndex;
	}

	public void setEndIndex(Long endIndex) {
	this.endIndex = endIndex;
	}

	public Long getStartIndex() {
	return startIndex;
	}

	public void setStartIndex(Long startIndex) {
	this.startIndex = startIndex;
	}

	public Long getTotalGames() {
	return totalGames;
	}

	public void setTotalGames(Long totalGames) {
	this.totalGames = totalGames;
	}

	}
