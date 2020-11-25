
package it.gov.mef.shared.utility.bi;

import java.math.BigDecimal;
import java.math.RoundingMode;

// TODO: Auto-generated Javadoc
/**
 * Classe di utilità per la gestione dei dati in formato numerico.
 *
 * @author d.brandi
 */
public class UtilityNumbers {

	/** The Constant CIFRE_DECIMALI_DEFAULT. */
	private static final int CIFRE_DECIMALI_DEFAULT = 2;
	
	/**
	 * Format decimal number.
	 *
	 * @param importo the importo
	 * @param cifreDecimali the cifre decimali
	 * @return importo formattato usando il numero di cifre decimali
	 * passate come input
	 */
	public static BigDecimal formatDecimalNumber(double importo,int cifreDecimali) {
		BigDecimal importoPercentualeBd = new BigDecimal(Double.toString(importo));
		importoPercentualeBd = importoPercentualeBd.setScale(cifreDecimali, RoundingMode.HALF_UP);
		return importoPercentualeBd;
	}
	
	/**
	 * Format decimal number.
	 *
	 * @param importo the importo
	 * @return importo formattato usando il numero di cifre di default
	 */
	public static BigDecimal formatDecimalNumber(double importo) {
		return formatDecimalNumber(importo,CIFRE_DECIMALI_DEFAULT);
	}
}
