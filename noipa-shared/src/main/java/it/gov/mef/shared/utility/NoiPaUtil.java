package it.gov.mef.shared.utility;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletRequest;

import org.springframework.web.client.RestClientException;

// TODO: Auto-generated Javadoc
/**
 * The Class NoiPaUtil.
 */
public class NoiPaUtil {
	
	/**
	 * nasconde i messaggi di default della portlet.
	 *
	 * @param portletRequest the portlet request
	 */
	public static void hiddenDefaultMessage(PortletRequest portletRequest) {
		SessionMessages.add(portletRequest,PortalUtil.getPortletId(portletRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		SessionMessages.add(portletRequest,PortalUtil.getPortletId(portletRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	/**
	 * gestisce eventuali eccezioni che possono essere:
	 * -eccezioni dell'eim client
	 * -eccezioni generiche.
	 *
	 * @param request the request
	 * @param _log the log
	 * @param e the e
	 */
	public static void gestisciEccezione(PortletRequest request,Log _log,Exception e) {
		if(e instanceof RestClientException) {
			gestisciEccezioneEimClient(request, _log, (RestClientException)e);
		}
		else {
			gestisciEccezioneGenerica(request, _log, e);
		}
	}
	
	/**
	 * gestisce eccezioni derivanti da chiamate all'eim client
	 * impostando una chiave apposita "restServiceError" 
	 * che verra gestita poi lato jsp.
	 *
	 * @param request the request
	 * @param _log the log
	 * @param rce the rce
	 */
	public static void gestisciEccezioneEimClient(PortletRequest request,Log _log,RestClientException rce) {
		_log.error(rce);
		SessionErrors.add(request, "restServiceError");
	}
	
	/**
	 * gestisce eccezioni generiche 
	 * impostando una chiave apposita "genericPortletError"
	 * che verra gestita poi lato jsp.
	 *
	 * @param request the request
	 * @param _log the log
	 * @param e the e
	 */
	protected static void gestisciEccezioneGenerica(PortletRequest request,Log _log,Exception e) {
		_log.error(e);
		SessionErrors.add(request, "genericPortletError");
	}
}
