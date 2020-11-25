package it.gov.mef.shared.utility.bi;

import com.liferay.portal.kernel.util.StringPool;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.util.CollectionUtils;

import it.gov.mef.shared.dto.bi.DescrInternaz;
import it.gov.mef.shared.dto.bi.ImpostaDto;
import it.gov.mef.shared.dto.bi.ListImposteDto;

// TODO: Auto-generated Javadoc
/**
 * Classe di utilità per la gestione dell'internazionalizzazione.
 *
 * @author d.brandi
 */
public class UtilityLang {
	
	/**
	 * Instantiates a new utility lang.
	 */
	public UtilityLang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/** The locale. */
	private static Locale locale;
	
	/** The lista imposte. */
	private static ListImposteDto listaImposte;
	
	/**
	 * Gets the lista imposte.
	 *
	 * @return the lista imposte
	 */
	public static ListImposteDto getListaImposte() {
		return listaImposte;
	}

	/**
	 * Sets the lista imposte.
	 *
	 * @param listaImposte the new lista imposte
	 */
	public static void setListaImposte(ListImposteDto listaImposte) {
		UtilityLang.listaImposte = listaImposte;
	}

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	public static Locale getLocale() {
		return locale;
	}

	/**
	 * Sets the locale.
	 *
	 * @param locale the new locale
	 */
	public static void setLocale(Locale locale) {
		UtilityLang.locale = locale;
	}
	
	/**
	 * Gets the desc for language.
	 *
	 * @param listDescrInternaz the list descr internaz
	 * @return la descrizione in base al locale settato
	 * come variabile d'istanza
	 */
	public static String getDescForLanguage(List<DescrInternaz> listDescrInternaz) {
		String result = null;
		if(!CollectionUtils.isEmpty(listDescrInternaz) && getLocale()!=null) {
			for(DescrInternaz descrInternaz : listDescrInternaz) {
				if(getLocale().getLanguage().equals(descrInternaz.getLang())) {
					return descrInternaz.getDesc();
				}
			}
		}
		return result;
 	}
	public static String getDescLanguageForLocale() {
		return (locale!=null && StringUtils.isNotBlank(locale.getLanguage()))?locale.getLanguage():"it";
	}
	/**
	 * Gets the imposta desc for language.
	 *
	 * @param codImposta the cod imposta
	 * @return descrizione della voce di spesa in base al locale settato
	 * come variabile d'istanza
	 */
	public static String getImpostaDescForLanguage(String codImposta) {
		String result = null;
		if(StringUtils.isNotBlank(codImposta) && getListaImposte()!=null
				&& getListaImposte().getTipo_imposte()!=null && getListaImposte().getTipo_imposte().size()>0 && getLocale()!=null) {
			List<ImpostaDto> listaTipoImposte = getListaImposte().getTipo_imposte();
			result = getDescForLanguage(listaTipoImposte.get(listaTipoImposte.indexOf(new ImpostaDto(codImposta))).getDescr_imposta());
		}
		return result;
 	}
	
	/**
	 * Gets the dett imposta desc for language.
	 *
	 * @param codDettImposta the cod dett imposta
	 * @return descrizione del dettaglio della voce di spesa
	 * in base al locale settato come variabile d'istanza
	 */
	public static String getDettImpostaDescForLanguage(String codDettImposta) {
		String result = null;
		if(StringUtils.isNotBlank(codDettImposta)) {
			if(getListaImposte()!=null
					&& getListaImposte().getTipo_imposte()!=null && getListaImposte().getTipo_imposte().size()>0 && getLocale()!=null) {
				List<ImpostaDto> listaTipoImposte = getListaImposte().getDettaglio_imposte();
				result = getDescForLanguage(listaTipoImposte.get(listaTipoImposte.indexOf(new ImpostaDto(codDettImposta))).getDescr_imposta());
			}
		}
		return result;
 	}
	
	/**
	 * Gets the label configurazione tradotta.
	 *
	 * @param listTraduzioniLabel the list traduzioni label
	 * @param labelDefault the label default
	 * @param locale the locale
	 * @return the label configurazione tradotta
	 */
	public static String getLabelConfigurazioneTradotta(String[] listTraduzioniLabel,String labelDefault, Locale locale) {
		String labelTradotta = StringPool.BLANK;
		int indexLingua = EnumUtils.getEnum(Lingua.class, locale.getLanguage()).cod();
		labelTradotta = (!ArrayUtils.isEmpty(listTraduzioniLabel) && listTraduzioniLabel.length-1 >= indexLingua)?listTraduzioniLabel[indexLingua]:null;
		return StringUtils.isNotBlank(labelTradotta)?labelTradotta:labelDefault;
	}
}
