package it.gov.mef.webformassistenza.noipa.configuration;


import aQute.bnd.annotation.metatype.Meta;

// TODO: Auto-generated Javadoc
/**
 * The Interface WebFormAssistenzaConfiguration.
 */
@Meta.OCD(id = "it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaConfiguration")
public interface WebFormAssistenzaConfiguration {

	
	
    /**
     * Link amministrazione.
     *
     * @return the string
     */
    @Meta.AD(required = false)
    public String linkAmministrazione();
    
    /**
     * Element categoriautenti num.
     *
     * @return the string
     */
    @Meta.AD(required = false)
    public String elementCategoriautentiNum();
    
    /**
     * Lista categoria utenti.
     *
     * @return the string
     */
    @Meta.AD(required = false)
    public String listaCategoriaUtenti();
    
    /**
     * Lista area.
     *
     * @return the string
     */
    @Meta.AD(required = false)
    public String listaArea();
    
    /**
     * Lista tematica.
     *
     * @return the string
     */
    @Meta.AD(required = false)
    public String listaTematica();
    
    /**
     * Lista tipologia.
     *
     * @return the string
     */
    @Meta.AD(required = false)
    public String listaTipologia();
    
    /**
     * Mailconfig mail.
     *
     * @return the string
     */
    @Meta.AD(required = false,deflt="testnoipa31@gmail.com")
    public String mailconfigMail();
    
    /**
     * Mailconfig nominativo.
     *
     * @return the string
     */
    @Meta.AD(required = false,deflt="NoiPa HelpDesk")
    public String mailconfigNominativo();
    
    
    /**
     * Mailconfig nominativo.
     *
     * @return the string
     */
    @Meta.AD(required = false,deflt="NoiPa HelpDesk")
    public String mailconfigNominativoBE();
    
    
    
    /**
     * Mailconfig mail hp.
     *
     * @return the string
     */
    @Meta.AD(required = false)
    public String mailconfigMailHp();
    
    /**
     * Id web content tema.
     *
     * @return the string
     */
    @Meta.AD(required = false)
    public String idWebContentTema();
    
    /**
     * Id web content risposta.
     *
     * @return the string
     */
    @Meta.AD(required = false)
    public String idWebContentRisposta();    
    
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