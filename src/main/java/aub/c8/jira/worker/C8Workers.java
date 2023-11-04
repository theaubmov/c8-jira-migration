package aub.c8.jira.worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aub.c8.jira.client.JiraRestClient;
import aub.c8.jira.dao.CreateSprintPayload;
import aub.c8.jira.dao.CreateSprintResponse;
import aub.c8.jira.dao.EstimationField;
import aub.c8.jira.dao.FetchJiraResponse;
import aub.c8.jira.dao.MoveIssuesToSprintPayload;
import aub.c8.jira.dao.SelectInput;
import aub.c8.jira.dao.UpdateIssueEstimationPayload;
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
		CreateSprintResponse response = jiraRestClient.createSprint(payload);
		
		inputVariables.put("SprintID", response.getId());
	    
	    client.newCompleteCommand(job.getKey()).variables(inputVariables).send().join();
	}
	
	@JobWorker(type = "FetchIssuesWorker")
	public void fetchIssuesWorker(final ActivatedJob job) {
		System.out.println("Fetch Issues Worker");
		FetchJiraResponse resp = jiraRestClient.fetchJiraIssues();
		
		List<SelectInput> selects = new ArrayList<SelectInput>();
		
		for(int i = 0; i < resp.getIssues().size() ; i++) {
			SelectInput newInput = new SelectInput(resp.getIssues().get(i).getFields().getSummary(), resp.getIssues().get(i).getId());
			selects.add(newInput);
		}
		
		final Map<String, Object> inputVariables = job.getVariablesAsMap();
		inputVariables.put("issues", selects);
	    
	    client.newCompleteCommand(job.getKey()).variables(inputVariables).send().join();
	    System.out.println("Fetch Issues Worker DONE!");
	}
	
	@JobWorker(type = "UpdateSprintInJiraWorker")
	public void updateSprintJiraWorker(final ActivatedJob job) {
		System.out.println("Update Sprint Jira Worker");
		
		final Map<String, Object> inputVariables = job.getVariablesAsMap();
		final String sprintID = (String) inputVariables.get("SprintID");
		
		final String selectInput1 = (String) inputVariables.get("SelectInput_Story1");
		final Integer estimation1 = (Integer) inputVariables.get("NumberInput_Story1");
		jiraRestClient.updateIssueEstimation(selectInput1, new UpdateIssueEstimationPayload(new EstimationField(estimation1)));
		
		final String selectInput2 = (String) inputVariables.get("SelectInput_Story2");
		final Integer estimation2 = (Integer) inputVariables.get("NumberInput_Story2");
		jiraRestClient.updateIssueEstimation(selectInput2, new UpdateIssueEstimationPayload(new EstimationField(estimation2)));
		
		final String selectInput3 = (String) inputVariables.get("SelectInput_Story3");
		final Integer estimation3 = (Integer) inputVariables.get("NumberInput_Story3");
		jiraRestClient.updateIssueEstimation(selectInput3, new UpdateIssueEstimationPayload(new EstimationField(estimation3)));
		
		List<String> issueIDS = new ArrayList<String>();
		issueIDS.add(selectInput1);
		issueIDS.add(selectInput2);
		issueIDS.add(selectInput3);
		MoveIssuesToSprintPayload payload = new MoveIssuesToSprintPayload(issueIDS);
		
		jiraRestClient.moveIssuesToSprint(sprintID, payload);
		
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
		final Map<String, Object> jobVariables = job.getVariablesAsMap();
		client.newPublishMessageCommand().messageName("Message_SprintCreated").correlationKey(job.getBpmnProcessId()).variables(jobVariables).send().join();
	}
	
	@JobWorker(type = "Message_SprintStarted")
	public void sendSprintStartedMessage(final ActivatedJob job) {
		System.out.println("Sprint Started Message");
		client.newPublishMessageCommand().messageName("Message_SprintStarted").correlationKey(job.getBpmnProcessId()).send().join();
	}

}
