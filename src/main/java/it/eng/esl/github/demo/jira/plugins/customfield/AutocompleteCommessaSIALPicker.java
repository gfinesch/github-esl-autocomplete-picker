package it.eng.esl.github.demo.jira.plugins.customfield;

import com.atlassian.jira.issue.customfields.converters.StringConverter;
import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import com.atlassian.jira.issue.customfields.impl.GenericTextCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.customfields.persistence.PersistenceFieldType;
import com.atlassian.jira.issue.fields.TextFieldCharacterLengthValidator;
import com.atlassian.jira.security.JiraAuthenticationContext;

public class AutocompleteCommessaSIALPicker extends GenericTextCFType {

	public AutocompleteCommessaSIALPicker(CustomFieldValuePersister customFieldValuePersister,
			StringConverter stringConverter, GenericConfigManager genericConfigManager,
			TextFieldCharacterLengthValidator textFieldCharacterLengthValidator,
			JiraAuthenticationContext jiraAuthenticationContext) {

		super(customFieldValuePersister, genericConfigManager, textFieldCharacterLengthValidator,
				jiraAuthenticationContext);
	}

	@Override
	public String getStringFromSingularObject(String singularObject) {
		return (String) singularObject;
	}

	@Override
	public String getSingularObjectFromString(String string) throws FieldValidationException {
		return string;
	}

	@Override
	protected PersistenceFieldType getDatabaseType() {
		return PersistenceFieldType.TYPE_LIMITED_TEXT;
	}
}
