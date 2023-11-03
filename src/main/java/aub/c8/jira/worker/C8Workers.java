package aub.c8.jira.worker;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aub.c8.jira.client.JiraRestClient;
import aub.c8.jira.dao.CreateSprintPayload;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.lifecycle.ZeebeClientLifecycle;

@Component
public class C8Workers {
	
	@Autowired
	private ZeebeClientLifecycle client;
	
	@Autowired
	private JiraRestClient jiraRestClient;

	@JobWorker(type = "CreateSprintInJiraWorker")
	public void createSprintJiraWorker(final ActivatedJob job) {
		System.out.println("Create Sprint Jira");
		
		final Map<String, Object> inputVariables = job.getVariablesAsMap();
		final String sprintEndDate = (String) inputVariables.get("newsprint_enddate");
		final String sprintGoal = (String) inputVariables.get("newsprint_goal");
		final String sprintName = (String) inputVariables.get("newsprint_name");
		final String sprintStartDate = (String) inputVariables.get("newsprint_startdate");
		
		CreateSprintPayload payload = new CreateSprintPayload(sprintName, sprintGoal, sprintStartDate, sprintEndDate);
		Object resp = jiraRestClient.createSprint(payload);
		System.out.println("DONE!!");
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
		client.newPublishMessageCommand().messageName("Message_SprintCreated").correlationKey(job.getBpmnProcessId()).send().join();
	}
	
	@JobWorker(type = "Message_SprintStarted")
	public void sendSprintStartedMessage(final ActivatedJob job) {
		System.out.println("Sprint Started Message");
		client.newPublishMessageCommand().messageName("Message_SprintStarted").correlationKey(job.getBpmnProcessId()).send().join();
	}

}
