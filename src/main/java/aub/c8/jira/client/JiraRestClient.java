package aub.c8.jira.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aub.c8.jira.dao.CreateSprintPayload;
import aub.c8.jira.dao.FetchJiraResponse;

@FeignClient(name = "jira", url = "https://hgrsolutions.atlassian.net/rest", configuration = FeignClientConfiguration.class)
public interface JiraRestClient {

	@RequestMapping(method =  RequestMethod.POST, value = "/agile/1.0/sprint")
	Object createSprint(@RequestBody CreateSprintPayload createSprintPayload);
	
	@RequestMapping(method =  RequestMethod.GET, value = "/agile/1.0/board/3/issue")
	FetchJiraResponse fetchJiraIssues();
}
