package it.gov.mef.webformassistenza.noipa.portlet.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import it.gov.mef.webformassistenza.noipa.constants.WebformassistenzaPortletKeys;

@Component(
immediate = true,
property = {
		"javax.portlet.name="+WebformassistenzaPortletKeys.Webformassistenza,
		"javax.portlet.init-param.add-process-action-success-action=false",
        "mvc.command.name=/webform/mvp"
},
service = MVCActionCommand.class
)
public class TestFriendlyUrl implements MVCActionCommand {
	Log _log=LogFactoryUtil.getLog(this.getClass());
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_log.info("Dentro del metodo action test");
		return false;
	}

}
