package it.eng.esl.github.demo.jira.plugins.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;

import it.eng.esl.github.demo.jira.plugins.customfield.AutocompleteCommessaSIALPicker;
import it.eng.esl.github.demo.jira.plugins.servlet.bo.CommessaRest;

@Path("/commesse-sial-component")
@Produces({ MediaType.APPLICATION_JSON })
@AnonymousAllowed
public class CommessaSIALServlet {

	private static final Logger log = LoggerFactory.getLogger(AutocompleteCommessaSIALPicker.class);

	private final JiraAuthenticationContext authenticationContext;

	public CommessaSIALServlet(final JiraAuthenticationContext authenticationContext) {
		this.authenticationContext = authenticationContext;
	}
//imposto 12 come limite di default perchè la select-aui di JIRA non consente parametri aggiuntivi olte a q
// https://production.eng.it/upgrading_jira/rest/arv/1.0/commesse-sial-component/getCommesseSIALList?limit=12&q=$SER
	@GET
	@Path("/getCommesseSIALList")
	public Response getPriorityList(@QueryParam("q") String query) {
		// check if the user is logged
		authenticationContext.getLoggedInUser().getDirectoryUser();

		List<CommessaRest> commesse = getCommesse(query);

		return Response.ok(commesse).build();
	}

	public List<CommessaRest> getCommesse(String codice) {
		List<CommessaRest> result = new ArrayList<CommessaRest>();
		List<CommessaRest> resultFiltered = new ArrayList<CommessaRest>();
		
		String upperCodice = codice.toUpperCase(); 
		
		result.add(new CommessaRest("$S20001" + " - " + "Commessa di Transito costi ESL doo (Cdc WESLZBK0)", "$S20001", "$S20001","Commessa di Transito costi ESL doo", "WESLZBK0", null));
		result.add(new CommessaRest("$S20002" + " - " + "Attività di sviluppo 2020 per Dir Tecnica Innovazione e Ricerca (Cdc WESLZBK0)", "$S20002", "$S20002", "Attività di sviluppo 2020 per Dir Tecnica Innovazione e Ricerca", "WESLZBK0", null));
		result.add(new CommessaRest("$S20004" + " - " + "Attività di sviluppo 2020 per Internal IT Engineering (Cdc WESLZBK0)", "$S20004", "$S20004", "Attività di sviluppo 2020 per Internal IT Engineering", "WESLZBK0", null));
		result.add(new CommessaRest("$SAL015" + " - " + "SALERNO Canone Manutenzione 2020 (Cdc WECM0002)", "$SAL015", "$SAL015", "SALERNO Canone Manutenzione 2020", "WECM0002", null));
		result.add(new CommessaRest("$SAN050" + " - " + "Analisi Processi Sanitari in ambito diagnostico (Cdc WESLYCA0)", "$SAN050", "$SAN050", "Analisi Processi Sanitari in ambito diagnostico", "WESLYCA0", null));
		result.add(new CommessaRest("R249TIMO04" + " -" + "PROGETTAZIONE, REALIZZAZIONE E GESTIONE DI PARCHEGGI PUBBLICI A PAGAMENTO DEL COMUNE DI LIVORNO (Cdc RRKTD0M)", "R249TIMO04", "R249TIMO04", "PROGETTAZIONE, REALIZZAZIONE E GESTIONE DI PARCHEGGI PUBBLICI A PAGAMENTO DEL COMUNE DI LIVORNO", "RRKTD0M", null));		

		resultFiltered = result.stream().filter(commessa -> commessa.getCod().contains(upperCodice)).collect(Collectors.toList());
		
		
		return resultFiltered; 
	}


}
