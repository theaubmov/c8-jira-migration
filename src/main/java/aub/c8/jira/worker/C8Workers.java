package aub.c8.jira.worker;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class C8Workers {

	@JobWorker(type = "CreateSprintInJiraWorker")
	public void createSprintJiraWorker(final ActivatedJob job) {
		System.out.println("Create Sprint Jira");
	}
	
	@JobWorker(type = "FetchIssuesWorker")
	public void fetchIssuesWorker(final ActivatedJob job) {
		System.out.println("Fetch Issues Worker");
	}
	
	@JobWorker(type = "UpdateSprintInJiraWorker")
	public void updateSprintJiraWorker(final ActivatedJob job) {
		System.out.println("Update Sprint Jira Worker");
	}
	
	@JobWorker(type = "UpdateTicketInJiraWorker")
	public void updateJiraTicketWorker(final ActivatedJob job) {
		System.out.println("Update Ticket Jira Worker");
	}
	
	@JobWorker(type = "FetchTeamMemeberWorker")
	public void fetchTeamMemberWorker(final ActivatedJob job) {
		System.out.println("Fetch TeamMember Worker");
	}
	
	@JobWorker(type = "NotifyTeamMemeberWorker")
	public void notifyTeamMemeberWorker(final ActivatedJob job) {
		System.out.println("Notify TeamMember Worker");
	}
	
	@JobWorker(type = "Message_SprintCreated")
	public void sendSprintCreatedMessage(final ActivatedJob job) {
		System.out.println("Sprint Created Message");
	}
	
	@JobWorker(type = "Message_SprintStarted")
	public void sendSprintStartedMessage(final ActivatedJob job) {
		System.out.println("Sprint Started Message");
	}

}
