package it.anpal.portlet.formOnline.config;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import it.anpal.portlet.formOnline.constants.ItAnpalPortletFormOnline;

@Component(configurationPid = "it.anpal.portlet.formOnline.config.PortletFormOnlineConfig", 
			configurationPolicy = ConfigurationPolicy.OPTIONAL, 
			immediate = true, property = "javax.portlet.name=" + ItAnpalPortletFormOnline.ITANPALPORTLETFORM,
			service = ConfigurationAction.class)
public class PortletFormOnlineActionConfig extends DefaultConfigurationAction {

	private static final Log _log = LogFactoryUtil.getLog(PortletFormOnlineActionConfig.class);

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(PortletFormOnlineConfig.class.getName(), _portletFormOnlineConfig);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		UploadPortletRequest upr = PortalUtil.getUploadPortletRequest(actionRequest);
		

		if (Validator.isNotNull(upr.getFileName("fileCSV"))) {
			File csvFile = upr.getFile("fileCSV");

			FileReader fr = new FileReader(csvFile);
			BufferedReader b = new BufferedReader(fr);
			String s;
			JSONArray jsonLista = JSONFactoryUtil.createJSONArray();
			// SALTO la prima riga che è di intestazione
			b.readLine();
			_log.info(fr.getEncoding());
			while (true) {
				s = b.readLine();
				if (s == null)
					break;
				String[] row = s.split(";");

				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("tipo", row[0]);
				json.put("utente", row[1]);
				json.put("richiesta", row[2]);
				json.put("sottorichiesta", row.length == 3 ? null : row[3]);
				jsonLista.put(json);

			}
			setPreference(actionRequest, "mappaForm", jsonLista.toJSONString());
			b.close();
		}

		String privateKeyCaptcha = ParamUtil.get(actionRequest, "privateKeyCaptcha", "");
		String dataSiteKeyCaptcha = ParamUtil.get(actionRequest, "dataSiteKeyCaptcha", "");
		String email = ParamUtil.get(actionRequest, "email", "");
		String toEmailDefault = ParamUtil.get(actionRequest, "toEmailDefault", "");
		String linkPDF = ParamUtil.get(actionRequest, "linkPDF", "");
		_log.info("privateKey: " + privateKeyCaptcha);
		_log.info("dataSiteKeyCaptcha: " + dataSiteKeyCaptcha);
		_log.info("email: " + email);
		_log.info("toEmailDefault: " + toEmailDefault);
		_log.info("linkPDF: " + linkPDF);

		if (Validator.isNotNull(privateKeyCaptcha) && Validator.isNotNull(dataSiteKeyCaptcha)
				&& Validator.isNotNull(email) && Validator.isNotNull(linkPDF)) {
			setPreference(actionRequest, "privateKeyCaptcha", privateKeyCaptcha);
			setPreference(actionRequest, "dataSiteKeyCaptcha", dataSiteKeyCaptcha);
			setPreference(actionRequest, "email", email);
			setPreference(actionRequest, "toEmailDefault", toEmailDefault);
			setPreference(actionRequest, "linkPDF", linkPDF);
		} else {
			setPreference(actionRequest, "privateKeyCaptcha", "");
			setPreference(actionRequest, "dataSiteKeyCaptcha", "");
			setPreference(actionRequest, "email", "");
			setPreference(actionRequest, "toEmailDefault", "");
			setPreference(actionRequest, "linkPDF", "");
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	private volatile PortletFormOnlineConfig _portletFormOnlineConfig;

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_portletFormOnlineConfig = ConfigurableUtil.createConfigurable(PortletFormOnlineConfig.class, properties);
	}

}
