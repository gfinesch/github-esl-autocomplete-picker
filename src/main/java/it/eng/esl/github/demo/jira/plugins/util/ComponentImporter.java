package it.eng.esl.github.demo.jira.plugins.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atlassian.jira.bc.projectroles.ProjectRoleService;
import com.atlassian.jira.issue.customfields.converters.StringConverter;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.customfields.searchers.transformer.CustomFieldInputHelper;
import com.atlassian.jira.issue.fields.TextFieldCharacterLengthValidator;
import com.atlassian.jira.jql.operand.JqlOperandResolver;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.jira.web.FieldVisibilityManager;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

/**
 * This class exists solely to cause Spring Scanner to import the required OSGi
 * services. It should never be instantiated.
 */
@Component
public class ComponentImporter {

	@Autowired
	public ComponentImporter(@ComponentImport CustomFieldValuePersister customFieldValuePersister, @ComponentImport  StringConverter stringConverter,
			@ComponentImport GenericConfigManager genericConfigManager,
			@ComponentImport TextFieldCharacterLengthValidator textFieldCharacterLengthValidator,
			@ComponentImport JiraAuthenticationContext jiraAuthenticationContext,
			@ComponentImport ProjectRoleService projectRoleService,
			@ComponentImport  FieldVisibilityManager fieldVisibilityManager,
			@ComponentImport JqlOperandResolver jqlOperandResolver,
			@ComponentImport CustomFieldInputHelper customFieldInputHelper

			) {
		// no need to actually do anything with it...
	}

}
