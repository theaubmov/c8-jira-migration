package aub.c8.jira.dao;

public class CreateSprintPayload {

	private String name;
	private String goal;
	private String endDate;
	private String startDate;
	private int originBoardId = 3;
	
	public CreateSprintPayload() {
		super();
	}

	public CreateSprintPayload(String name, String goal, String startDate, String endDate) {
		super();
		this.name = name;
		this.goal = goal;
		this.endDate = endDate;
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getOriginBoardId() {
		return originBoardId;
	}

	public void setOriginBoardId(int originBoardId) {
		this.originBoardId = originBoardId;
	}
	
}
