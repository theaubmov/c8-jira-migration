package aub.c8.jira.dao;

import java.util.List;

public class FetchJiraResponse {
	
	private String expand;
	private List<Issue> issues;
	
	
	public FetchJiraResponse() {
		super();
	}
	public FetchJiraResponse(String expand, List<Issue> issues) {
		super();
		this.expand = expand;
		this.issues = issues;
	}
	public String getExpand() {
		return expand;
	}
	public void setExpand(String expand) {
		this.expand = expand;
	}
	public List<Issue> getIssues() {
		return issues;
	}
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
	
	
	
}
