package aub.c8.jira.dao;

public class UpdateIssueEstimationPayload {
	
	private EstimationField fields;
	
	public UpdateIssueEstimationPayload() {
		super();
	}

	public UpdateIssueEstimationPayload(EstimationField fields) {
		super();
		this.fields = fields;
	}

	public EstimationField getFields() {
		return fields;
	}

	public void setFields(EstimationField fields) {
		this.fields = fields;
	}

}
