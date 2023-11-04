package aub.c8.jira.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aub.c8.jira.dao.CreateSprintPayload;
import aub.c8.jira.dao.CreateSprintResponse;
import aub.c8.jira.dao.FetchJiraResponse;
import aub.c8.jira.dao.MoveIssuesToSprintPayload;
import aub.c8.jira.dao.UpdateIssueEstimationPayload;

@FeignClient(name = "jira", url = "https://hgrsolutions.atlassian.net/rest", configuration = FeignClientConfiguration.class)
public interface JiraRestClient {
	

	@RequestMapping(method =  RequestMethod.POST, value = "/agile/1.0/sprint")
	CreateSprintResponse createSprint(@RequestBody CreateSprintPayload createSprintPayload);
	
	@RequestMapping(method =  RequestMethod.GET, value = "/agile/1.0/board/3/issue")
	FetchJiraResponse fetchJiraIssues();
	
	@RequestMapping(method =  RequestMethod.PUT, value = "/api/3/issue/{issueID}")
	void updateIssueEstimation(@PathVariable("issueID") String issueID, @RequestBody UpdateIssueEstimationPayload updateIssueEstimationPayload);
	
	@RequestMapping(method =  RequestMethod.POST, value = "/agile/1.0/sprint/{sprintID}/issue")
	void moveIssuesToSprint(@PathVariable("sprintID") String sprintID, @RequestBody MoveIssuesToSprintPayload moveIssuesToSprintPayload);
	
}
