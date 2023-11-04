package aub.c8.jira.dao;

public class Issue {

	private String id;
	private String expand;
	private String key;
	private IssueField fields;
	
	
	
	public Issue() {
		super();
	}
	public Issue(String id, String expand, String key, IssueField fields) {
		super();
		this.id = id;
		this.expand = expand;
		this.key = key;
		this.fields = fields;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExpand() {
		return expand;
	}
	public void setExpand(String expand) {
		this.expand = expand;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public IssueField getFields() {
		return fields;
	}
	public void setFields(IssueField fields) {
		this.fields = fields;
	}
	
	
	
}
