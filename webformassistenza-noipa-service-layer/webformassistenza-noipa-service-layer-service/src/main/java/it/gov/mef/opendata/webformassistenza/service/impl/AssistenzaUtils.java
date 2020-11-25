package it.gov.mef.opendata.webformassistenza.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLink;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetLinkLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import it.gov.mef.shared.dto.assistenza.Tema;


// TODO: Auto-generated Javadoc
/**
 * The Class AssistenzaUtils.
 */
public class AssistenzaUtils {
	
	
	/** The log. */
	private static Log _log = LogFactoryUtil.getLog(AssistenzaUtils.class);
	
	
	
	/**
	 * Gets the lista risposte.
	 *
	 * @param groupId the group id
	 * @param ddmStructureKeyR the ddm structure key R
	 * @param locale the locale
	 * @return the lista risposte
	 */
	private static List<Tema> getListaRisposte(long groupId,String ddmStructureKeyR,String locale){
		List<JournalArticle> lisaRisposte = JournalArticleLocalServiceUtil.getArticlesByStructureId(groupId, ddmStructureKeyR, -1, -1, null);
		List<Tema> risposte = new ArrayList<Tema>();
		for (JournalArticle journalArticle : lisaRisposte) {
			double version = journalArticle.getVersion();
			String articleId = journalArticle.getArticleId();
			Tema risposta = null;
			try {
				if(JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleId, version)) {
					risposta = convertRisposta(journalArticle, Long.parseLong(ddmStructureKeyR),groupId, getLocale(locale));
				}
			}catch (PortalException e) {
				_log.error(e);
			}
			risposte.add(risposta);
		}
		return risposte;
	}
	
	
	/**
	 * Gets the assitenza.
	 *
	 * @param groupId the group id
	 * @param locale the locale
	 * @param ddmStructureKeyT the ddm structure key T
	 * @param ddmStructureKeyR the ddm structure key R
	 * @return the assitenza
	 */
	protected static Map<Long, List<Tema>> getAssitenza(long groupId, String locale, String ddmStructureKeyT, String ddmStructureKeyR) {
		_log.info("getAssitenza - ddmStructureKeyT: "+ddmStructureKeyT+" - ddmStructureKeyR: "+ddmStructureKeyR+" - locale: "+locale);
		Map<Long, List<Tema>> assistenza = new HashMap<Long, List<Tema>>();
		Map<Long, List<Tema>> tmp = new HashMap<Long, List<Tema>>();
		for (long i = 1; i < 6; i++) {
			assistenza.put(i, new LinkedList<Tema>());
		}
		List<JournalArticle> lisaTemi = JournalArticleLocalServiceUtil.getArticlesByStructureId(groupId, ddmStructureKeyT, -1, -1, null);
		for (JournalArticle journalArticle : lisaTemi) {
			double version = journalArticle.getVersion();
			String articleId = journalArticle.getArticleId();
			Tema tema = null;
			try {
				if(JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleId, version)) {
					tema = convertTema(journalArticle, Long.parseLong(ddmStructureKeyT),groupId, getLocale(locale));
				}
			}catch (PortalException e) {
				_log.error(e);
			}
			long livello =  tema.getLivello();
			List<Tema> listLivello = assistenza.remove(livello);
			listLivello.add(tema);
			assistenza.put(livello, listLivello);
		}
		List<Tema> risposte = getListaRisposte(groupId, ddmStructureKeyR, locale);
		Set<Long> keys = assistenza.keySet();
		for (Long key : keys) {
			List<Tema> listLivello = assistenza.get(key);
			List<Tema> nListLivello = new LinkedList<Tema>();
			for (Tema tema : listLivello) {
				long resourcePrimKey = tema.getResourcePrimKey();
				long id = Long.parseLong(tema.getId());
				AssetEntry assetEntry = null;
				try {
					assetEntry = AssetEntryLocalServiceUtil.getEntry("com.liferay.journal.model.JournalArticle", resourcePrimKey);
				} catch (PortalException e) {
					_log.warn("recupero da ID");
					try {
						assetEntry = AssetEntryLocalServiceUtil.getEntry("com.liferay.journal.model.JournalArticle", id);
					} catch (PortalException e1) {
						_log.warn("no assetentry!");
					}
				}
				try {
				if(assetEntry != null) {
					long entryId = assetEntry.getEntryId();
					List<AssetLink> assetLinks = AssetLinkLocalServiceUtil.getDirectLinks(entryId, true);
					List<Tema> listArgomenti = new ArrayList<Tema>();
					long relatedAssetEntryPrimKey = -1;
					for (AssetLink assetLink : assetLinks) {
						long relatedAssetEntryId  = assetLink.getEntryId2();
						AssetEntry relatedAssetEntry = AssetEntryLocalServiceUtil.getEntry(relatedAssetEntryId);
						relatedAssetEntryPrimKey = relatedAssetEntry.getClassPK();
						JournalArticle relatedArticle = JournalArticleLocalServiceUtil.getLatestArticle(relatedAssetEntryPrimKey);
						Tema temaR = null; 
						if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyT)) {
							temaR = convertTema(relatedArticle, Long.parseLong(ddmStructureKeyR),groupId, getLocale(locale));
						} else if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyR)) {
							temaR = convertRisposta(relatedArticle, Long.parseLong(ddmStructureKeyR),groupId, getLocale(locale));
						}
						if(!temaR.getId().equalsIgnoreCase(tema.getId()) && temaR.getLivello() > tema.getLivello()) {
							Tema temaCR = getList(temaR, getLocale(locale), groupId, ddmStructureKeyT, ddmStructureKeyR);
							listArgomenti.add(temaCR);
						}
					}
					tema.setListArgomento(listArgomenti);
					nListLivello.add(tema);
				}
				}catch (PortalException e) {
					_log.error(e);
				} }
			tmp.put(key, nListLivello);
		}
		return tmp;
	}
	
	
	
/**
 * Gets the assitenza remota.
 *
 * @param groupId the group id
 * @param locale the locale
 * @param ddmStructureKeyT the ddm structure key T
 * @param ddmStructureKeyR the ddm structure key R
 * @return the assitenza remota
 */
protected static Map<Long, List<Tema>> getAssitenzaRemota(long groupId, String locale, String ddmStructureKeyT, String ddmStructureKeyR) {
		Map<Long, List<Tema>> assistenza = new HashMap<Long, List<Tema>>();
		Map<Long, List<Tema>> tmp = new HashMap<Long, List<Tema>>();
		for (long i = 1; i < 6; i++) {
			assistenza.put(i, new LinkedList<Tema>());
		}
		List<JournalArticle> lisaTemi = JournalArticleLocalServiceUtil.getArticlesByStructureId(groupId, ddmStructureKeyT, -1, -1, null);
		for (JournalArticle journalArticle : lisaTemi) {
			double version = journalArticle.getVersion();
			String articleId = journalArticle.getArticleId();
			Tema tema = null;
			try {
				if(JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleId, version)) {
					tema = convertTema(journalArticle, Long.parseLong(ddmStructureKeyR),groupId, getLocale(locale));
					long livello = tema!=null ? tema.getLivello() : -1 ;
					List<Tema> listLivello = assistenza.remove(livello);
					listLivello.add(tema);
					assistenza.put(livello, listLivello);
				}
			}catch (PortalException e) {
				_log.error(e);
			}
		}
		List<Tema> risposte = getListaRisposte(groupId, ddmStructureKeyR, locale);new ArrayList<Tema>();
		Set<Long> keys = assistenza.keySet();
		for (Long key : keys) {
			List<Tema> listLivello = assistenza.get(key);
			List<Tema> nListLivello = getNLivello(groupId, locale, ddmStructureKeyT, ddmStructureKeyR, listLivello);
			tmp.put(key, nListLivello);
		}
		return assistenza;
	}

		/**
		 * Gets the n livello.
		 *
		 * @param groupId the group id
		 * @param locale the locale
		 * @param ddmStructureKeyT the ddm structure key T
		 * @param ddmStructureKeyR the ddm structure key R
		 * @param listLivello the list livello
		 * @return the n livello
		 */
		private static List<Tema> getNLivello(long groupId, String locale, String ddmStructureKeyT, String ddmStructureKeyR,List<Tema> listLivello){
			List<Tema> nListLivello = new LinkedList<Tema>();
			for (Tema tema : listLivello) {
				long resourcePrimKey = tema.getResourcePrimKey();
				long id = Long.parseLong(tema.getId());
				AssetEntry assetEntry = null;
				try {
					assetEntry = AssetEntryLocalServiceUtil.getEntry("com.liferay.journal.model.JournalArticle", resourcePrimKey);
				} catch (PortalException e) {
					try {
						assetEntry = AssetEntryLocalServiceUtil.getEntry("com.liferay.journal.model.JournalArticle", id);
					} catch (PortalException e1) {
						_log.warn("no assetentry!");
					} }
				try {
				if(assetEntry != null) {
					long entryId = assetEntry.getEntryId();
					
					List<AssetLink> assetLinks = AssetLinkLocalServiceUtil.getDirectLinks(entryId, true);
					List<Tema> listArgomenti = new ArrayList<Tema>();
					long relatedAssetEntryPrimKey = -1;
					for (AssetLink assetLink : assetLinks) {
						long relatedAssetEntryId  = assetLink.getEntryId2();
						AssetEntry relatedAssetEntry = AssetEntryLocalServiceUtil.getEntry(relatedAssetEntryId);
						relatedAssetEntryPrimKey = relatedAssetEntry.getClassPK();
						JournalArticle relatedArticle = JournalArticleLocalServiceUtil.getLatestArticle(relatedAssetEntryPrimKey);
						Tema temaR = null; 
						if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyT)) {
							temaR = convertTema(relatedArticle, Long.parseLong(ddmStructureKeyR),groupId, getLocale(locale));
						} else if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyR)) {
							temaR = convertRisposta(relatedArticle, Long.parseLong(ddmStructureKeyR),groupId, getLocale(locale));
						}
						if(!temaR.getId().equalsIgnoreCase(tema.getId()) && temaR.getLivello() > tema.getLivello()) {
							Tema temaCR = getList(temaR, getLocale(locale), groupId, ddmStructureKeyT, ddmStructureKeyR);
							listArgomenti.add(temaCR);
						}
					}
					tema.setListArgomento(listArgomenti);
					nListLivello.add(tema);
				}
				}catch (PortalException e) {
					_log.error(e);
				}
			}
			return nListLivello;
		}
	
	
/**
 * Convert tema.
 *
 * @param journalArticle the journal article
 * @param idStruttura the id struttura
 * @param groupId the group id
 * @param locale the locale
 * @return the tema
 */
private static Tema convertTema(JournalArticle journalArticle, long idStruttura, long groupId, Locale locale) {
		Tema tema = null;
		String titolo = "";
		String descrizione = "";
		String areaPortale = "";
		String id = journalArticle.getArticleId();
		XPath xPathSelectorTitolo = SAXReaderUtil.createXPath("dynamic-element[@name='titolo']");
		XPath xPathSelectorDescrizione = SAXReaderUtil.createXPath("dynamic-element[@name='descrizione']");
		XPath xPathSelectorLivello = SAXReaderUtil.createXPath("dynamic-element[@name='livello']");
		XPath xPathSelectorAreaPortale = SAXReaderUtil.createXPath("dynamic-element[@name='areaPortale']");
		long livello = 0;
		String articleId = journalArticle.getArticleId();
		double version = journalArticle.getVersion();
		try {
			if(JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleId, version)) {
				String content = journalArticle.getContentByLocale(locale.toString());
				Document document = SAXReaderUtil.read(content);
				Element root = document.getRootElement();
				titolo = xPathSelectorTitolo.selectSingleNode(root).getStringValue();
				descrizione = xPathSelectorDescrizione.selectSingleNode(root).getStringValue();
				String liv = xPathSelectorLivello.selectSingleNode(root).getStringValue();
				areaPortale = xPathSelectorAreaPortale.selectSingleNode(root) == null ? "ET" : xPathSelectorAreaPortale.selectSingleNode(root).getStringValue();
				livello = Long.parseLong(clearValue(liv));
				//30743
					long resourcePrimKey = journalArticle.getResourcePrimKey();
					tema = new Tema(titolo, descrizione, areaPortale, id, null, resourcePrimKey,livello);
					tema.setRispsota(false);
			}
		} catch (PortalException | DocumentException e) {
			_log.error(e);
		}
		return tema;
	}
	

/**
 * Convert contenuto.
 *
 * @param journalArticle the journal article
 * @param idStruttura the id struttura
 * @param groupId the group id
 * @param locale the locale
 * @return the JSON object
 */
public static JSONObject convertContenuto(JournalArticle journalArticle, String idStruttura, long groupId, Locale locale) {
	JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
	
	String areaId = "";
	String contenutoId = "";
	String lingua = "";
	String htmlTesto = "";
	
	
	String id = journalArticle.getArticleId();
	XPath xPathSelectorAreaID = SAXReaderUtil.createXPath("dynamic-element[@name='areaId']");
	XPath xPathSelectorContenutoID = SAXReaderUtil.createXPath("dynamic-element[@name='contenutoId']");
	XPath xPathSelectorHtmlTesto = SAXReaderUtil.createXPath("dynamic-element[@name='htmlTesto']");
	String articleId = journalArticle.getArticleId();
	double version = journalArticle.getVersion();
	try {
		if(JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleId, version)) {
			String content = journalArticle.getContentByLocale(locale.toString());
			Document document = SAXReaderUtil.read(content);
			Element root = document.getRootElement();
			areaId = xPathSelectorAreaID.selectSingleNode(root).getStringValue();
			contenutoId = xPathSelectorContenutoID.selectSingleNode(root).getStringValue();
			htmlTesto = xPathSelectorHtmlTesto.selectSingleNode(root).getStringValue();
			lingua = locale.toString();
			jsonObj.put("areaId", areaId.trim());
			jsonObj.put("contenutoId", contenutoId.trim());
			jsonObj.put("htmlTesto", htmlTesto.trim());
			jsonObj.put("lingua", lingua.trim().trim());
			
		}
	} catch (PortalException | DocumentException e) {
		_log.error(e);
	}
	return jsonObj;
}
	
	/**
	 * Convert risposta.
	 *
	 * @param journalArticle the journal article
	 * @param idStruttura the id struttura
	 * @param groupId the group id
	 * @param locale the locale
	 * @return the tema
	 */
	private static Tema convertRisposta(JournalArticle journalArticle, long idStruttura, long groupId, Locale locale) {
		Tema tema = null;
		String titolo = "";
		String descrizione = "";
		String areaPortale = "";
		long livello = 0;
		List<String> labelLinks = new LinkedList<String>();
		List<String> links = new LinkedList<String>();
		
		
		String id = journalArticle.getArticleId();
		XPath xPathSelectorTitolo = SAXReaderUtil.createXPath("dynamic-element[@name='titolo']");
		XPath xPathSelectorDescrizione = SAXReaderUtil.createXPath("dynamic-element[@name='descrizione']");
		XPath xPathSelectorLivello = SAXReaderUtil.createXPath("dynamic-element[@name='livello']");
		XPath xPathSelectorAreaPortale = SAXReaderUtil.createXPath("dynamic-element[@name='areaPortale']");
		String articleId = journalArticle.getArticleId();
		double version = journalArticle.getVersion();
		try {
			if(JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleId, version)) {
				String content = journalArticle.getContentByLocale(locale.toString());
				Document document = SAXReaderUtil.read(content);
				Element root = document.getRootElement();
				titolo = xPathSelectorTitolo.selectSingleNode(root).getStringValue();
				descrizione = xPathSelectorDescrizione.selectSingleNode(root).getStringValue();
				areaPortale = xPathSelectorAreaPortale.selectSingleNode(root) == null ? "ET" : xPathSelectorAreaPortale.selectSingleNode(root).getStringValue();
				String liv = xPathSelectorLivello.selectSingleNode(root).getStringValue();
				livello = Long.parseLong(clearValue(liv));
				//30743
				String key = "dynamic-element[@name='link"; 
				String keyL = "dynamic-element[@name='labelLink"; 
				for (int i = 1; i < 6; i++) {
					String keyLink = key+i+"']";
					String keyLabel = keyL+i+"']";
					XPath xLink = SAXReaderUtil.createXPath(keyLink);
					XPath xLabelLink = SAXReaderUtil.createXPath(keyLabel);
					Node nodeLink = xLink.selectSingleNode(root);
					
					if(nodeLink!=null) {
						String link = clearValue(nodeLink.getStringValue());
						if(Validator.isNotNull(link))
							links.add(link);
					
					Node nodeLabel = xLabelLink.selectSingleNode(root);
					if(nodeLabel!=null) {
						String label = clearValue(nodeLabel.getStringValue());
						if(Validator.isNotNull(label))
							labelLinks.add(label);
						else 
							labelLinks.add(link);
					}
					}


				}
					if(journalArticle!=null) {
						long idDDM = Long.parseLong(journalArticle.getDDMStructureKey());
						long resourcePrimKey = journalArticle.getResourcePrimKey();
						boolean isRisposta = (idDDM - idStruttura) == 0;
						tema = new Tema(titolo, descrizione, areaPortale, id, null, resourcePrimKey,livello,links,labelLinks);
						tema.setRispsota(isRisposta);
					}
				
					

			}
		} catch (PortalException | DocumentException e) {
			_log.error(e);
		}
		return tema;
	}
	
	
	/**
	 * Gets the list.
	 *
	 * @param tema the tema
	 * @param locale the locale
	 * @param groupId the group id
	 * @param ddmStructureKeyT the ddm structure key T
	 * @param ddmStructureKeyR the ddm structure key R
	 * @return the list
	 */
	private static Tema getList(Tema tema, Locale locale, long groupId, String ddmStructureKeyT, String ddmStructureKeyR) {

		long resourcePrimKey = tema.getResourcePrimKey();
		long id = Long.parseLong(tema.getId());
		AssetEntry assetEntry = null;
		try {
			assetEntry = AssetEntryLocalServiceUtil.getEntry("com.liferay.journal.model.JournalArticle", resourcePrimKey);
		} catch (PortalException e) {
			_log.warn("recupero da ID");
			try {
				assetEntry = AssetEntryLocalServiceUtil.getEntry("com.liferay.journal.model.JournalArticle", id);
			} catch (PortalException e1) {
				_log.warn("no assetentry!");
			}
		}
		try {
		if(assetEntry != null) {
			long entryId = assetEntry.getEntryId();
			List<AssetLink> assetLinks = AssetLinkLocalServiceUtil.getDirectLinks(entryId, true);
			List<Tema> listArgomenti = new ArrayList<Tema>();

			long relatedAssetEntryPrimKey = -1;
			for (AssetLink assetLink : assetLinks) {
				long relatedAssetEntryId  = assetLink.getEntryId2();
				AssetEntry relatedAssetEntry = AssetEntryLocalServiceUtil.getEntry(relatedAssetEntryId);
				relatedAssetEntryPrimKey = relatedAssetEntry.getClassPK();
				JournalArticle relatedArticle = JournalArticleLocalServiceUtil.getLatestArticle(relatedAssetEntryPrimKey);
				Tema temaR = null; 
				if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyT)) {
					temaR = convertTema(relatedArticle, Long.parseLong(ddmStructureKeyR),groupId, locale);
				} else if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyR)) {
					temaR = convertRisposta(relatedArticle, Long.parseLong(ddmStructureKeyR), groupId, locale);
				}
				if(temaR!=null && !temaR.getId().equalsIgnoreCase(tema.getId()) && temaR.getLivello() > tema.getLivello()) {
					Tema temaCR = getList(temaR, locale, groupId, ddmStructureKeyT, ddmStructureKeyR);
					listArgomenti.add(temaCR);
				}
			}
			tema.setListArgomento(listArgomenti);
		}
		}catch (PortalException e) {
			_log.error(e);
		}
		return tema;
	}
	
	
	/**
	 * Gets the locale.
	 *
	 * @param loc the loc
	 * @return the locale
	 */
	public static Locale getLocale(String loc) {
		Locale locale = null;
		
		if(loc.equalsIgnoreCase("en_US")) {
			locale = Locale.US;
		} else if(loc.equalsIgnoreCase("de_DE")) {
			locale = Locale.GERMANY;
		} else if(loc.equalsIgnoreCase("it_IT")) {
			locale = Locale.ITALY;
		}
		return locale;
	}
	
	
	/**
	 * Clear value.
	 *
	 * @param value the value
	 * @return the string
	 */
	public static String clearValue(String value) {
		String val = "";
		if(Validator.isNotNull(value) ) {
			if(value.startsWith("_") )
				val = value.substring(1).trim();
			else
				val = value.trim();
		}
		return val;
	}
	

}
