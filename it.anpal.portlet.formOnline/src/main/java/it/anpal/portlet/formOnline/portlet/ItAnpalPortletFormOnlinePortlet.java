package it.anpal.portlet.formOnline.portlet;

import it.anpal.portlet.formOnline.config.PortletFormOnlineConfig;
import it.anpal.portlet.formOnline.constants.ItAnpalPortletFormOnline;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.mail.internet.InternetAddress;
import javax.net.ssl.HttpsURLConnection;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Anpal",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ItAnpalPortletFormOnline", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ItAnpalPortletFormOnline.ITANPALPORTLETFORM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ItAnpalPortletFormOnlinePortlet extends MVCPortlet {

	Log _log = LogFactoryUtil.getLog(this.getClass());

	private static final String url = "https://www.google.com/recaptcha/api/siteverify";

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		try {
			PortletFormOnlineConfig config = portletDisplay.getPortletInstanceConfiguration(PortletFormOnlineConfig.class);
			String mappa = config.mappaForm();
			_log.info(mappa);

			JSONArray listContenuti = JSONFactoryUtil.createJSONArray(mappa);
			_log.info("nel doview: " + listContenuti);
//			renderRequest.setAttribute("mappaConfig", listContenuti);
		} catch (ConfigurationException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.doView(renderRequest, renderResponse);
	}

	public void sendMail(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
			PortletFormOnlineConfig config = portletDisplay.getPortletInstanceConfiguration(PortletFormOnlineConfig.class);

			String Captcha = ParamUtil.getString(actionRequest, "Captcha");

			_log.info(Captcha);
			if (VerifyCaptcha(Captcha, config.privateKeyCaptcha())) // SE IL CAPTCHA E' VERIFICATO ALLORA SI PROVVEDE AD
																	// INVIARE LE EMAIL
			{

				String fromMail = config.email();
				String toMail = config.toEmailDefault();

				String soggetto = ParamUtil.getString(actionRequest, "ScegliTipologia");
				String Nome = ParamUtil.getString(actionRequest, "nome");
				String Cognome = ParamUtil.getString(actionRequest, "cognome");
				String CF = ParamUtil.getString(actionRequest, "CF");
				String Email = ParamUtil.getString(actionRequest, "emailAddress");
				String Telefono = ParamUtil.getString(actionRequest, "telefono");
				String Oggetto = ParamUtil.getString(actionRequest, "Oggetto");

				String Utente = ParamUtil.getString(actionRequest, "Users");
				String Categoria = ParamUtil.getString(actionRequest, "SecondCategories");
				String SubCategories = ParamUtil.getString(actionRequest, "SubCategories");

				String body = null;
				body = "<br>";
				body += "<b><u>Soggetto</u></b>" + soggetto + "<br>";
				body += "<b><u>Dati Anagrafici</u></b><br>";
				body += "<b>Nome:</b>" + Nome + "<br>";
				body += "<b>Cognome:</b>" + Cognome + "<br>";
				body += "<b>Codice Fiscale:</b>" + CF + "<br><br>";

				body += "<b><u>Contatti</u></b><br>";
				body += "<b>Email:</b>" + Email + "<br>";
				body += "<b>Cellulare:</b>" + Telefono + "<br><br>";

				body += "<b><u>Richiesta</u></b><br>";
				body += "<b>Tipo Utente:</b>" + Utente + "<br>";
				body += "<b>Oggetto:</b>" + Categoria + "<br>";
				body += "<b>SubCategoria:</b>" + SubCategories + "<br><br>";
				body += "<b><u>-------Testo della richiesta-------</u></b><br>";
				body += Oggetto + "<br><br>";

				body += "<b><hr></b>";
				body += "E-mail generata automaticamente dal sistema, non utilizzare questo indirizzo per rispondere, i messaggi pervenuti a tale indirizzo non vengono letti.";

				MailMessage Messaggio = new MailMessage();
				MailMessage UserMessage = new MailMessage();

//			file = PortalUtil.getUploadPortletRequest(request).getFiles("File");
//			fnames = PortalUtil.getUploadPortletRequest(request).getFileNames("File");

				String indexFile = ParamUtil.getString(actionRequest, "indexAllegati");

				_log.info("********** " + indexFile);
				String[] arrayIndexFile = indexFile.split(",");
//			List<String> arrayListProfessioni = new ArrayList<String>();

				String fieldname;
				String nameFile;
				File k;
				UploadPortletRequest upr = PortalUtil.getUploadPortletRequest(actionRequest);

				for (int i = 0; i < arrayIndexFile.length; i++) {
					fieldname = "Allegato" + arrayIndexFile[i];
					if (Validator.isNotNull(PortalUtil.getUploadPortletRequest(actionRequest).getFileName(fieldname))) {
						nameFile = PortalUtil.getUploadPortletRequest(actionRequest).getFileName(fieldname);
						_log.info("file " + i + " " + nameFile);
						k = FileUtil.createTempFile(upr.getFileAsStream(fieldname));
						Messaggio.addFileAttachment(k, nameFile);
						UserMessage.addFileAttachment(k, nameFile);
						k.deleteOnExit();
					}
				}

				Messaggio.setSubject(soggetto);
				Messaggio.setHTMLFormat(true);
				Messaggio.setBody(body);
				Messaggio.setFrom(new InternetAddress(fromMail));
				Messaggio.setTo(new InternetAddress(toMail));

				String Body = "<i>Gentile utente,<br>abbiamo ricevuto la tua email: ti contatteremo al piu' presto per darti supporto.<br>"
						+ "Di seguito riportiamo un promemoria dei dati che ci hai fornito (non comunicheremo ad altri i tuoi dati personali).<br>"
						+ "Cordialmente.</i><br><br>";

				Body += body;

				UserMessage.setSubject("Non rispondere - " + soggetto);
				UserMessage.setHTMLFormat(true);
				UserMessage.setBody(Body);
				UserMessage.setFrom(new InternetAddress(fromMail));
				UserMessage.setTo(new InternetAddress(Email));

				MailServiceUtil.sendEmail(Messaggio);
				MailServiceUtil.sendEmail(UserMessage);
				SessionMessages.add(actionRequest, "success");
				actionRequest.setAttribute("Succesful", true);
				_log.info("OK");
			} else {
				SessionErrors.add(actionRequest, "error");
				actionRequest.setAttribute("Succesful", false);
				_log.info("NO");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean VerifyCaptcha(String response, String privateKeyCaptcha) {
		try {
			HttpsURLConnection con = (HttpsURLConnection) new URL(url).openConnection();
			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			String postParams = "secret=" + privateKeyCaptcha + "&response=" + response;
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer Response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				Response.append(inputLine);
			}
			in.close();
			// print result
			_log.info("\n" + "Response from URL " + url + " = " + Response.toString() + "\n");
			if (Response.toString().contains("true")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			return false;
		}
	}
}
