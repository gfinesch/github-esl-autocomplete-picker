package it.eng.esl.github.demo.jira.plugins.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.jira.bc.issue.search.SearchService;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.search.SearchException;
import com.atlassian.jira.issue.search.SearchResults;
import com.atlassian.jira.web.bean.PagerFilter;
import com.atlassian.jira.workflow.WorkflowException;
import com.atlassian.jira.user.ApplicationUser;

public class SearchUtil {

	private static final Logger log = LoggerFactory.getLogger(SearchUtil.class);

	public static List<Issue> runJqlQuery(String jql, ApplicationUser user) {
		if (log.isDebugEnabled())
			log.debug("Searching JQL: '"+jql+"' ["+user.getName()+"]");

		//SearchService.ParseResult parseResult = ComponentManager.getInstance().getSearchService().parseQuery(user, jql);
		SearchService.ParseResult parseResult =  ComponentAccessor.getComponentOfType(SearchService.class).parseQuery(user, jql);

		if (parseResult.isValid()) {

			try {
				//SearchResults results = ComponentManager.getInstance().getSearchProvider()
				//		.search(parseResult.getQuery(), user, PagerFilter.getUnlimitedFilter());
				SearchResults<Issue> results = ComponentAccessor.getComponentOfType(SearchService.class).search(user, parseResult.getQuery(), PagerFilter.getUnlimitedFilter());

				if (results != null && results.getResults() != null) {
					return results.getResults();
					
				} else {
					return new ArrayList<Issue>();
				}

			} catch (SearchException e) {
				log.error("SearchException for JQL: '"+jql+"'", e);
				return null;
			}

		} else {
			log.error("JQL '"+jql+"' query error: " + parseResult.getErrors().getErrorMessages().toString());
			throw new WorkflowException("Cannot run query: " + parseResult.getErrors().getErrorMessages());
		}
	}

}
