package aub.c8.jira.dao;

import java.util.List;

public class MoveIssuesToSprintPayload {

	private List<String> issues;

	public MoveIssuesToSprintPayload() {
		super();
	}
	
	public MoveIssuesToSprintPayload(List<String> issues) {
		super();
		this.issues = issues;
	}

	public List<String> getIssues() {
		return issues;
	}

	public void setIssues(List<String> issues) {
		this.issues = issues;
	}
	
}
