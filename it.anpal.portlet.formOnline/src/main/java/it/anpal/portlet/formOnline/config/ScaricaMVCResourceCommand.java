package it.anpal.portlet.formOnline.config;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.OutputStreamWriter;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.anpal.portlet.formOnline.constants.ItAnpalPortletFormOnline;


@Component(configurationPid = "it.anpal.portlet.formOnline.config.PortletFormOnlineConfig",
	    immediate = true,
	    property = {
	    		
	    		"javax.portlet.name="+ItAnpalPortletFormOnline.ITANPALPORTLETFORM,
	    		"javax.portlet.name=com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet",
	    		"javax.portlet.init-param.add-process-action-success-action=false",
		        "mvc.command.name=/config/download/csv"
	    },
	    service = MVCResourceCommand.class
	)
public class ScaricaMVCResourceCommand implements MVCResourceCommand{
	
	private Log _log = LogFactoryUtil.getLog(ScaricaMVCResourceCommand.class.getName());
	private final SimpleDateFormat inDate = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response){
		
		PortletSession session = request.getPortletSession();

		try(OutputStream outz = response.getPortletOutputStream();OutputStreamWriter writer = new OutputStreamWriter(outz,"UTF-8");) {
						
			String jsonString = (String) session.getAttribute("it.form.config.session.mappa");
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
			_log.info(jsonArray);
			response.setContentType("text/csv");
			response.addProperty("Content-Disposition", String.format("attachment;filename=\"%s_%s.csv\"",inDate.format(new Date()),"Config"));
			String separatore = ";";
			//Intestazione CSV
			byte[] tmp = ("Tipo;Utente;Richiesta;SottoRichiesta").getBytes(); 	
			writer.write(new String(tmp,"UTF-8"));
			writer.write("\n");
			//Scrivo il jsonarray in csv
			String s;
			for(int i= 0 ; i<jsonArray.length() ; i++) {
				s = jsonArray.getJSONObject(i).getString("tipo") + separatore
						+jsonArray.getJSONObject(i).getString("utente") + separatore 
						+jsonArray.getJSONObject(i).getString("richiesta");
				
				if(!jsonArray.getJSONObject(i).getString("sottorichiesta").equals("")) {
					s = s + separatore + jsonArray.getJSONObject(i).getString("sottorichiesta");
				}	
				tmp = s.getBytes("UTF-8");
				writer.write(new String(tmp,"UTF-8"));
				writer.write("\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			_log.error("Download CVS configurazione fallito", e);
			return true;
		} catch (JSONException e) {
			_log.error("JSON ERROR " + e.getMessage() );
		}
		return false;
	}

}
