package it.gov.mef.webformassistenza.noipa.configuration;


import aQute.bnd.annotation.metatype.Meta;

// TODO: Auto-generated Javadoc
/**
 * The Interface WebFormAssistenzaCheckConfiguration.
 */
@Meta.OCD(id = "it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaCheckConfiguration")
public interface WebFormAssistenzaCheckConfiguration {

	
	
    /**
     * Service url.
     *
     * @return the string
     */
    @Meta.AD(required = false)
	public String serviceUrl();
    
    /**
     * Send method.
     *
     * @return the string
     */
    @Meta.AD(required = false)
	public String sendMethod();
    
    /**
     * Chech method.
     *
     * @return the string
     */
    @Meta.AD(required = false)
	public String chechMethod();
    
    /**
     * User id.
     *
     * @return the string
     */
    @Meta.AD(required = false)
	public String userId();
    
    /**
     * Password.
     *
     * @return the string
     */
    @Meta.AD(required = false)
	public String password();
    
    /**
     * Token.
     *
     * @return the string
     */
    @Meta.AD(required = false)
	public String token();
    
    

}