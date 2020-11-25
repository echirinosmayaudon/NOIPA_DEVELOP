package it.gov.mef.shared.dto.bi;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import it.gov.mef.shared.utility.bi.DashboardType;
import lombok.Data;

// TODO: Auto-generated Javadoc
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data
/**
 * Dto per il passaggio dei filtri verso l'eim client 
 * ed in seguito messi sulla url e inviati verso il servizio esterno
 * @author d.brandi
 *
 */
public class FilterDto  {
	
	/** The dashboard type. */
	private DashboardType dashboardType;
	
	/** The anno. */
	private Integer anno;
	
	/** The mese. */
	private String mese;
	
	/** The lista enti selected. */
	private List<String> listaEntiSelected;
	
	/** The tipo imposta. */
	private Long tipoImposta;
	
	/** The cod regione. */
	private String codRegione;
	
	/** The cod provincia. */
	private String codProvincia;
	
	/** The lista enti excluded. */
	private List<String> listaEntiExcluded;
	
	/** The includi voce altro. */
	private boolean includiVoceAltro = false;
	
	
	/**
	 * Restituisce una mappa (ordinata per creare url uguali a fronte dello stesso insieme di parametri) 
	 * di filtri che ha come chiave il nome del parametro e come valore il valore del filtro
	 * per l'interrogazione dei dati delle dashboard.
	 *
	 * @return the parameter map
	 */
	public SortedMap<String,String> getParameterMap() {
		SortedMap<String, String> parameter = new TreeMap<>();
		if(getAnno()!=null && getAnno()!=0) {
			parameter.put("anno", getAnno().toString());
			if(StringUtils.isNotBlank(getMese())) {
				parameter.put("mese", getMese());
			}
		}
		if(!CollectionUtils.isEmpty(getListaEntiSelected())) {
			String listEnti = preparelistToParameterString(getListaEntiSelected());
			parameter.put(getParameterNameEntiSelected(),listEnti);
		}
		else { // considero gli enti esclusi solo se non ho selezionato nessun ente (quindi andrei su tutti gli enti)
			if(!CollectionUtils.isEmpty(getListaEntiExcluded())) {
				String listEnti = preparelistToParameterString(getListaEntiExcluded());
				parameter.put("exclude",listEnti);
			}
		}
		if(getTipoImposta()!=null && getTipoImposta()>=0) {
			parameter.put("tipo-imposta", getTipoImposta().toString());
		}
		if(StringUtils.isNotBlank(getCodRegione())) {
			parameter.put("regione", getCodRegione());
			if(StringUtils.isNotBlank(getCodProvincia())) {
				parameter.put("provincia", getCodProvincia());
			}
		}
		parameter.put("altro", Boolean.toString(isIncludiVoceAltro()));
		return parameter;
	}


	/**
	 * Preparelist to parameter string.
	 *
	 * @param lista the lista
	 * @return the string
	 */
	private String preparelistToParameterString(List<? extends Object> lista) {
		return lista.toString().replace("[", "").replace("]", "").replaceAll("\\s","");
	}

	/**
	 * metodo che serve per modificare il nome del parametro degli enti da includere
	 * in base al dashboard analisi attuale/assunzioni cessazioni.
	 *
	 * @return the parameter name enti selected
	 */
	private String getParameterNameEntiSelected() {
		switch (dashboardType) {
		case ANALISI_ATTUALE:
			return "ente";
		case ATTIVAZIONI_CESSAZIONI:
			return "include";
		default:
			return null;
		}
	}
	
	/**
	 * metodo che restituisce una mappa (ordinata per creare url uguali a fronte dello stesso insieme di parametri) 
	 *  di filtri che ha come chiave il nome del parametro e come valore il valore del filtro per l'interrogazione 
	 *  della lista degli enti.
	 *
	 * @return the parameter enti filter
	 */
	public SortedMap<String,String> getParameterEntiFilter() {
		SortedMap<String, String> parameterMap = new TreeMap<>();
		if(dashboardType!=null && StringUtils.isNotBlank(dashboardType.keyEim())) {
			parameterMap.put("dashboard",String.valueOf(dashboardType.keyEim()));
			if(getAnno()!=null && getAnno() > 0) {
				parameterMap.put("anno",String.valueOf(getAnno()));
				if(DashboardType.ANALISI_ATTUALE.equals(getDashboardType())
					&& StringUtils.isNotBlank(getMese())) {
					parameterMap.put("mese",getMese());
				}
			}
			if(DashboardType.ATTIVAZIONI_CESSAZIONI.equals(getDashboardType())) {
				parameterMap.put("regione",getCodRegione());
				parameterMap.put("provincia",getCodProvincia());
			}
		}
		return parameterMap;
	}

	/**
	 * Instantiates a new filter dto.
	 *
	 * @param dashboardType the dashboard type
	 */
	public FilterDto(DashboardType dashboardType) {
		super();
		this.dashboardType = dashboardType;
	}
}
