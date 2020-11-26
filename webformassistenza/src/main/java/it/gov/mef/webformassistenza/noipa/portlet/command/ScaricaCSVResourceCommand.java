package it.gov.mef.webformassistenza.noipa.portlet.command;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import it.gov.mef.webformassistenza.noipa.constants.WebformassistenzaPortletKeys;

@Component(configurationPid = "it.anpal.portlet.formOnline.config.PortletFormOnlineConfig",
immediate = true,
property = {
		"javax.portlet.name="+WebformassistenzaPortletKeys.Webformassistenza,
		"javax.portlet.name=com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet",
		"javax.portlet.init-param.add-process-action-success-action=false",
        "mvc.command.name=/config/download/csv"
},
service = MVCResourceCommand.class
)
public class ScaricaCSVResourceCommand implements MVCResourceCommand{
	Log _log=LogFactoryUtil.getLog(this.getClass());
	private final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	private String intestazioneCsv="";
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {


		PortletSession session = resourceRequest.getPortletSession();
		String typeConfig=ParamUtil.get(resourceRequest, "typeConfig", "");
	
		
		//getJSONAttay
		String jsonString = getJSONStringByTypeConfig(typeConfig,session);	
		
		try(OutputStream outz = resourceResponse.getPortletOutputStream();OutputStreamWriter writer = new OutputStreamWriter(outz,"UTF-8");) {		
			
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
			
			resourceResponse.setContentType("text/csv");
			
			resourceResponse.addProperty("Content-Disposition", String.format("attachment;filename=\"%s_%s.csv\"",date.format(new Date()),"Config"));
			
			String separatore = ";";
			
			//Intestazione CSV
			byte[] tmp = (intestazioneCsv).getBytes();
			
			//Intestazione CSV array
			String[] intestazione=intestazioneCsv.split(separatore);
			
			writer.write(new String(tmp,"UTF-8"));
			writer.write("\n");
			//Scrivo il jsonarray in csv
			String s="";
			//Cicle righe
			for(int i= 0 ; i<jsonArray.length() ; i++) {
				
				//Cicla le celle
				 //Recuperando il valore corrispondente all'intestazione per ogni riga
				//Amministrazione;Tipo;Codice;Amministrato;MVP;AreaPensioni;EntiCreditori
				 for(int index=0;index<intestazione.length;index++) {
					
					 if(index==0) {
						 s +="\n"+ jsonArray.getJSONObject(i).getString(intestazione[index]);
					 }else {
						 s +=separatore+jsonArray.getJSONObject(i).getString(intestazione[index]);
					 }	
					
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
	
	/*Metodo per recuperare i json delle configurazioni dalla session
	 * 
	 */
	private String getJSONStringByTypeConfig(String typeConfig, PortletSession session) {
		String jsonString="";
		
		switch(typeConfig) {
		case "listaAmministrazioni": 
			jsonString = (String) session.getAttribute("config.session.lista.amministrazioni");
			intestazioneCsv=WebformassistenzaPortletKeys.AmministrazioniCSVheader;
			break;
		case "listaTipologie": 
			jsonString = (String) session.getAttribute("config.session.lista.tipologie");
			intestazioneCsv=WebformassistenzaPortletKeys.TipologieCSVheader;
			break;	
		}
		
		return jsonString;
	}
}
