package it.eng.esl.github.demo.jira.plugins.servlet.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@XmlRootElement
public class CommessaRest {
	private static final ToStringStyle TO_STRING_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
	
// cod, description, cdcAppartenenza restano per questioni storiche in quanto questo progetto deriva da un progeto precedente
// label e value sono stati introdotti per utilizzare la aui-select di JIRA a front end che vuole in ingresso un JSON con i campi label e value
	
	@XmlElement
	private String label;
	
	@XmlElement
	private String value;
	
	@XmlElement
	private String cod;

	@XmlElement
	private String description;
	
	@XmlElement
	private String cdcAppart;
	
	@XmlElement
	private String cliente;
	

	@SuppressWarnings("unused")
	private CommessaRest() {
	}

	public CommessaRest(final String label, final String value, final String cod, String description, String cdcAppart, String cliente) {
		this.label = label;
		this.value=value; 
		this.cod = cod;
		this.description = description;
		this.cdcAppart = cdcAppart;
		this.cliente = cliente;
	}

	public String getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public String getCdcAppart() {
		return cdcAppart;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public String getLabel() {
		return label;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(final Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, TO_STRING_STYLE);
	}
}
