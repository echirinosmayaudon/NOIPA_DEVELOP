/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.gov.mef.opendata.webformassistenza.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLink;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetLinkLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
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
import java.util.Map;
import java.util.Set;

import it.gov.mef.opendata.webformassistenza.service.base.AssitenzaNoipaServiceBaseImpl;
import it.gov.mef.shared.dto.assistenza.Tema;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the AssitenzaNoipa remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipaServiceBaseImpl
 * @see it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaServiceUtil
 */
public class AssitenzaNoipaServiceImpl extends AssitenzaNoipaServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaServiceUtil} to access the AssitenzaNoipa remote service.
	 */
	
	
	/** The log. */
	private static Log _log = LogFactoryUtil.getLog(AssitenzaNoipaServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaService#getAssitenzaOld(long, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Object getAssitenzaOld(long groupId, String locale, String ddmStructureKeyT, String ddmStructureKeyR) {
		_log.info("Recupero wizard....");
		Map<Long, List<Tema>> assistenza = AssistenzaUtils.getAssitenzaRemota(groupId, locale, ddmStructureKeyT, ddmStructureKeyR);
		JSONArray response = JSONFactoryUtil.createJSONArray();
		//StringBuffer sb = new StringBuffer();
		Set<Long> keys = assistenza.keySet();
		for (Long key : keys) {
				List<Tema> temi = assistenza.get(key);
				for (Tema tema : temi) {
					response.put(tema.convertToJson());
				}
		}
			
		String jsonResp = response.toJSONString();
		_log.info(jsonResp);
		
		return response;
	}
	
	
	
	/* (non-Javadoc)
	 * @see it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaService#getContenutoPrivato(long, java.lang.String, java.lang.String, java.lang.String)
	 */
	//
	public JSONArray getContenutoPrivato(long groupId, String structureId, String locale, String areaId) {
		JSONArray response = JSONFactoryUtil.createJSONArray();
		
		List<JournalArticle> listaContenuti = JournalArticleLocalServiceUtil.getArticlesByStructureId(groupId, structureId, -1, -1, null);
		for (JournalArticle journalArticle : listaContenuti) {
			JSONObject jsonObject = AssistenzaUtils.convertContenuto(journalArticle, structureId, groupId, AssistenzaUtils.getLocale(locale));
			String aID = (String) jsonObject.get("areaId");
			if(areaId!=null && !areaId.equalsIgnoreCase("")) {
				if(aID.contains(areaId))
				response.put(jsonObject);
			} else {
				response.put(jsonObject);
			}
		}
		
		
		return response;
	}
	
	
	/* (non-Javadoc)
	 * @see it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaService#getAssitenzaRemota(long, java.lang.String, java.lang.String, java.lang.String)
	 */
	public JSONArray getAssitenzaRemota(long groupId, String locale, String ddmStructureKeyT, String ddmStructureKeyR) {
		_log.info("Recupero getAssitenzaRemota....");
		Map<Long, List<Tema>> assistenza = getStruttura(groupId, locale, ddmStructureKeyT, ddmStructureKeyR);
		_log.info(assistenza);
		JSONArray response = JSONFactoryUtil.createJSONArray();
		//StringBuffer sb = new StringBuffer();
		Set<Long> keys = assistenza.keySet();
		for (Long key : keys) {
				List<Tema> temi = assistenza.get(key);
				for (Tema tema : temi) {
					if(tema.getLivello() == 1) {
						response.put(tema.convertToJson());
					}
				}
		}
			
		String jsonResp = response.toJSONString();
		_log.info(jsonResp);
		
		return response;
	}
	
	
	
/**
 * Gets the struttura.
 *
 * @param groupId the group id
 * @param locale the locale
 * @param ddmStructureKeyT the ddm structure key T
 * @param ddmStructureKeyR the ddm structure key R
 * @return the struttura
 */
private  Map<Long, List<Tema>> getStruttura(long groupId,  String locale, String ddmStructureKeyT, String ddmStructureKeyR){
	_log.info("Recupero getStruttura....");
		Map<Long, List<Tema>> tmp = new HashMap<Long, List<Tema>>();
		Map<Long, List<Tema>> assistenza  =  null;
		try {
			assistenza  = AssistenzaUtils.getAssitenza(groupId, locale, ddmStructureKeyT, ddmStructureKeyR);
		} catch (Exception e) {
			_log.error(e);
		}	
		_log.info("Recupero assistenza....");
		Set<Long> keys = assistenza.keySet();
		for (Long key : keys) {
			List<Tema> listLivello = assistenza.get(key);
			List<Tema> nListLivello = new LinkedList<Tema>();
			for (Tema tema : listLivello) {
				if(tema!=null && !tema.getAreaPortale().equalsIgnoreCase("PB")) {
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
							temaR = convertTema(relatedArticle, groupId, Long.parseLong(ddmStructureKeyR), locale);
						} else if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyR)) {
							temaR = convertRisposta(relatedArticle, groupId, Long.parseLong(ddmStructureKeyR),  locale);
						}
						if(!temaR.getId().equalsIgnoreCase(tema.getId()) && temaR.getLivello() > tema.getLivello() && !tema.getAreaPortale().equalsIgnoreCase("PB")) {
							Tema temaCR = getList(temaR, locale, groupId, ddmStructureKeyT, ddmStructureKeyR);
							listArgomenti.add(temaCR);
						}
					}
					tema.setListArgomento(listArgomenti);
					nListLivello.add(tema);
				}
				}catch (Exception e) {
					_log.error(e);
				}
			}
			}
			tmp.put(key, nListLivello);
		}
		
		
		
		return tmp;	
	}
	

    
	
	
	
	
	/**
	 * Convert tema.
	 *
	 * @param journalArticle the journal article
	 * @param groupId the group id
	 * @param idStruttura the id struttura
	 * @param locale the locale
	 * @return the tema
	 */
	private Tema convertTema(JournalArticle journalArticle, long groupId,  long idStruttura, String locale) {
		
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
				String content = journalArticle.getContentByLocale(locale);
				Document document = SAXReaderUtil.read(content);
				Element root = document.getRootElement();
				titolo = xPathSelectorTitolo.selectSingleNode(root).getStringValue();
				descrizione = xPathSelectorDescrizione.selectSingleNode(root).getStringValue();
				areaPortale = xPathSelectorAreaPortale.selectSingleNode(root) == null ? "ET" : xPathSelectorAreaPortale.selectSingleNode(root).getStringValue();
				String liv = xPathSelectorLivello.selectSingleNode(root).getStringValue();
				livello = Long.parseLong(AssistenzaUtils.clearValue(liv));
				//30743
				long idDDM = Long.parseLong(journalArticle.getDDMStructureKey());
					long resourcePrimKey = journalArticle.getResourcePrimKey();
					boolean isRisposta = (idDDM -idStruttura) == 0;
					_log.info("idDDM: "+idDDM+" - idStruttura: "+idStruttura+" - resourcePrimKey:"+resourcePrimKey+" ["+isRisposta+"]");
					tema = new Tema(titolo, descrizione, areaPortale, id, null, resourcePrimKey,livello);
					tema.setRispsota(false);
			}
		} catch (PortalException | DocumentException e) {
			_log.error(e);
		}
		return tema;
	}
	
	
	/**
	 * Convert risposta.
	 *
	 * @param journalArticle the journal article
	 * @param groupId the group id
	 * @param idStruttura the id struttura
	 * @param locale the locale
	 * @return the tema
	 */
	private Tema convertRisposta(JournalArticle journalArticle, long groupId,  long idStruttura, String locale) {
		
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
				String liv = xPathSelectorLivello.selectSingleNode(root).getStringValue();
				areaPortale = xPathSelectorAreaPortale.selectSingleNode(root) == null ? "ET" : xPathSelectorAreaPortale.selectSingleNode(root).getStringValue();
				livello = Long.parseLong(AssistenzaUtils.clearValue(liv));
				//30743
				String key = "dynamic-element[@name='link"; 
				String keyL = "dynamic-element[@name='labelLink"; 
				for (int i = 1; i < 6; i++) {
					String keyLink = key+i+"']";
					String keyLabel = keyL+i+"']";
					XPath xLink = SAXReaderUtil.createXPath(keyLink);
					XPath xLabelLink = SAXReaderUtil.createXPath(keyLabel);
					Node nodeLink = xLink.selectSingleNode(root);
					
					if(nodeLink != null) {
						String link = AssistenzaUtils.clearValue(xLink.selectSingleNode(root).getStringValue());
						if(Validator.isNotNull(link))
							links.add(link);
					
					Node nodeLabel = xLink.selectSingleNode(root);
					if(nodeLabel!=null) {
						String label = AssistenzaUtils.clearValue(xLabelLink.selectSingleNode(root).getStringValue());
						if(Validator.isNotNull(label))
							labelLinks.add(label);
					} else {
						labelLinks.add(link);
					}
					}
				}
				long idDDM = Long.parseLong(journalArticle.getDDMStructureKey());
					long resourcePrimKey = journalArticle.getResourcePrimKey();
					boolean isRisposta = (idDDM -idStruttura) == 0;
					_log.info("idDDM: "+idDDM+" - idStruttura: "+idStruttura+" - resourcePrimKey:"+resourcePrimKey+" ["+isRisposta+"]");
					tema = new Tema(titolo, descrizione, areaPortale, id, null, resourcePrimKey,livello,links,labelLinks);
					tema.setRispsota(isRisposta);
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
	private Tema getList(Tema tema, String locale, long groupId, String ddmStructureKeyT, String ddmStructureKeyR) {

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
					temaR = convertTema(relatedArticle, groupId, Long.parseLong(ddmStructureKeyT), locale);
				} else if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyR)) {
					temaR = convertRisposta(relatedArticle, groupId, Long.parseLong(ddmStructureKeyR), locale);
				}
				if(temaR != null && !temaR.getId().equalsIgnoreCase(tema.getId()) && temaR.getLivello() > tema.getLivello()) {
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
	
}