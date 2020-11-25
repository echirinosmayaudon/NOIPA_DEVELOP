package it.gov.mef.shared.utility.bi;

// TODO: Auto-generated Javadoc
/**
 * The Enum Lingua.
 */
public enum Lingua {
	
	/** The it. */
	it(0),
	
	/** The en. */
	en(1),
	
	/** The de. */
	de(2);
	
	/** The cod. */
	private int cod;
	
	/**
	 * Instantiates a new lingua.
	 *
	 * @param cod the cod
	 */
	Lingua(int cod) {
        this.cod = cod;
    }

    /**
     * Cod.
     *
     * @return the int
     */
    public int cod() {
        return cod;
    }
}
