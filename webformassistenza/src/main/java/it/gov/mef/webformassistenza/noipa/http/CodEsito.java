package it.gov.mef.webformassistenza.noipa.http;

// TODO: Auto-generated Javadoc
/**
 * The Enum CodEsito.
 */
public enum CodEsito {
	
	/** The insert 200. */
	INSERT_200("Domanda inserita",200),
	
	/** The insert 201. */
	INSERT_201("Domanda inserita",201),
	
	/** The insert 400. */
	INSERT_400("Errore di validazione (campi obbligatori non presenti)",400),
	
	/** The insert 403. */
	INSERT_403("Errore di autenticazione",403),
	
	/** The insert 413. */
	INSERT_413("Dimensione allegato eccessiva (limite 1Mb)",413),
	
	/** The insert 500. */
	INSERT_500("Errore server",500);

	
	
	
	
	/** The descrizione. */
	private String descrizione;
	
	/** The codice. */
	private int codice;
	
	/**
	 * Gets the descrizione.
	 *
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Gets the codice.
	 *
	 * @return the codice
	 */
	public int getCodice() {
		return codice;
	}
	
	/**
	 * Instantiates a new cod esito.
	 *
	 * @param descrizione the descrizione
	 * @param codice the codice
	 */
	private CodEsito (String descrizione, int codice) {
		this.descrizione = descrizione;
		this.codice = codice;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.codice+" - "+this.descrizione;
	}
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println(CodEsito.valueOf("INSERT_201"));
	}
	
	
	
}
