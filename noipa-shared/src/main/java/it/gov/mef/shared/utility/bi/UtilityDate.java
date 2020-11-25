package it.gov.mef.shared.utility.bi;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts.util.LabelValueBean;

// TODO: Auto-generated Javadoc
/**
 * Classe di utilità per la gestione delle date.
 *
 * @author d.brandi
 */
public class UtilityDate {
	
	/**
	 * Gets the desc mese.
	 *
	 * @param codMese the cod mese
	 * @param locale the locale
	 * @return descrizione del mese decodificando il codice
	 * in base al locale passato
	 */
	public static String getDescMese(String codMese, Locale locale) {
		Month month = Month.of(Integer.valueOf(codMese));
		return getDescMese(month, locale);
	}
	
	/**
	 * Gets the desc mese.
	 *
	 * @param month the month
	 * @param locale the locale
	 * @return descrizione del mese a partire dall'oggetto month
	 * ed in base al locale passati
	 */
	private static String getDescMese(Month month, Locale locale) {
		String descMese = month.getDisplayName(TextStyle.FULL,locale);
		String firstChar = descMese.substring(0,1).toUpperCase();		
		return firstChar + descMese.substring(1, descMese.length());
	}
	
	/**
	 * Gets the desc mese abbreviato.
	 *
	 * @param codMese the cod mese
	 * @param locale the locale
	 * @return descrizione abbreviata del mese decodificando il codice
	 * in base al locale passato
	 */
	public static String getDescMeseAbbreviato(String codMese, Locale locale) {
		return getDescMese(codMese, locale).substring(0,3);
	}
	
	/**
	 * Gets the lista anni.
	 *
	 * @param annoInizio the anno inizio
	 * @param ascendingOrder the ascending order
	 * @return the lista anni
	 */
	protected static List<String> getListaAnni(int annoInizio, boolean ascendingOrder) {
		int start = annoInizio;
		int end = Calendar.getInstance().get(Calendar.YEAR);
		return IntStream.range(start, end+1)
		.mapToObj(anno -> String.valueOf(anno))
		.sorted(ascendingOrder?Comparator.naturalOrder():Collections.reverseOrder())
        .collect(Collectors.toList());
	}
	/**
	 * Gets the lista anni.
	 *
	 * @param annoInizio the anno inizio
	 * @param annoInizio the anno fine
	 * @param ascendingOrder the ascending order
	 * @return the lista anni
	 */
	protected static List<String> getListaAnni(int annoInizio,int annoFine, boolean ascendingOrder) {
		int start = annoInizio;
		int end = annoFine;
		return IntStream.range(start, end+1)
		.mapToObj(anno -> String.valueOf(anno))
		.sorted(ascendingOrder?Comparator.naturalOrder():Collections.reverseOrder())
        .collect(Collectors.toList());
	}
	public static List<String> getListaAnniAscendingOrder(int annoInizio) {
		return getListaAnni(annoInizio, true);
	}
	public static List<String> getListaAnniDescendingOrder(int annoInizio) {
		return getListaAnni(annoInizio, false);
	
	}
	public static List<String> getListaAnniDescendingOrder(int annoInizio,int annoFine) {
		return getListaAnni(annoInizio,annoFine, false);
	}
	/**
	 * Gets the lista mesi.
	 *
	 * @param locale the locale
	 * @return lista di LabelValueBean contenente codice e descrizione dei mesi
	 * in base al locale passato
	 */
	public static List<LabelValueBean> getListaMesi(Locale locale) {
		List<LabelValueBean> listMesi = new ArrayList<>();
		for(Month month : EnumUtils.getEnumList(Month.class)) {
			String codMese = leftPadMese(month.getValue());
			listMesi.add(new LabelValueBean(getDescMese(month, locale),codMese));
		}		
		return listMesi;
	}
	
	/**
	 * Left pad mese.
	 *
	 * @param mese the mese
	 * @return the string
	 */
	public static String leftPadMese(int mese) {
		return StringUtils.leftPad(String.valueOf(mese),2,"0");
	}
	
	/**
	 * Checks if is valid month.
	 *
	 * @param codMese the cod mese
	 * @return true, if is valid month
	 */
	public static boolean isValidMonth(String codMese) {
		if(StringUtils.isNotBlank(codMese) && StringUtils.isNumeric(codMese)) {
			try {
				int intMese = Integer.parseInt(codMese);
				return intMese > 0 && intMese <= EnumUtils.getEnumList(Month.class).size();
			}
			catch(NumberFormatException nfe) {
				return false;
			}
		}
		return false;
	}
}
