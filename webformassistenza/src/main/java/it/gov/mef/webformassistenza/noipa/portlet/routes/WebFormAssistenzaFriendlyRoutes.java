package it.gov.mef.webformassistenza.noipa.portlet.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

import it.gov.mef.webformassistenza.noipa.constants.WebformassistenzaPortletKeys;


@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.friendly-url-routes=META-INF/routes/routes.xml",						//routes.xml
			"javax.portlet.name=" + WebformassistenzaPortletKeys.Webformassistenza
		},
		service = FriendlyURLMapper.class
	)
public class WebFormAssistenzaFriendlyRoutes extends DefaultFriendlyURLMapper{

	 @Override
	    public String getMapping() {
	        return _MAPPING;
	    }

	    private static final String _MAPPING = "noipa";
}