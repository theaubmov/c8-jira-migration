package aub.c8.jira.dao;


public class IssueField {
	
	private String summary;
	
	
	public IssueField() {
		super();
	}
	
	public IssueField(String summary) {
		super();
		this.summary = summary;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
