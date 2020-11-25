package it.gov.mef.shared.utility.bi;

// TODO: Auto-generated Javadoc
/**
 * enum dei tipi di dashboard con i relativi nomi richiesti come 
 * parametro dal servizio esterno per i dati.
 *
 * @author d.brandi
 */
public enum DashboardType {
	
	/** The analisi attuale. */
	ANALISI_ATTUALE("dati-spesa"),
	
	/** The attivazioni cessazioni. */
	ATTIVAZIONI_CESSAZIONI("attivazioni-cessazioni"),
	
	/** The counter. */
	COUNTER("");
	

	/** The key eim. */
	private String keyEim;

	/**
	 * Instantiates a new dashboard type.
	 *
	 * @param keyEim the key eim
	 */
	DashboardType(String keyEim) {
        this.keyEim = keyEim;
    }

    /**
     * Key eim.
     *
     * @return the string
     */
    public String keyEim() {
        return keyEim;
    }
}