package it.anpal.portlet.formOnline.config;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;;

@ExtendedObjectClassDefinition(
	    scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE,
	    generateUI=false
	)
@Meta.OCD(id = "it.anpal.portlet.formOnline.config.PortletFormOnlineConfig")
public interface PortletFormOnlineConfig {
	
	@Meta.AD(required = false)
	public String mappaForm();
	
    @Meta.AD(required = false)
    public String privateKeyCaptcha();
    
    @Meta.AD(required = false)
    public String dataSiteKeyCaptcha();
    
    @Meta.AD(required = false)
    public String email();
    
    @Meta.AD(required = false)
    public String toEmailDefault();
    
    @Meta.AD(required = false)
    public String linkPDF();

}
