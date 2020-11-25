package it.gov.mef.webformassistenza.noipa.resourcebundle;

import com.liferay.portal.kernel.language.UTF8Control;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
// TODO: Auto-generated Javadoc

/**
 * The Class WebformassistenzaENRB.
 */
@Component(
	    property = { "language.id=en_US" }, 
	    service = ResourceBundle.class
	)
public class WebformassistenzaENRB extends ResourceBundle {

    /* (non-Javadoc)
     * @see java.util.ResourceBundle#handleGetObject(java.lang.String)
     */
    @Override
    protected Object handleGetObject(String key) {
        return _resourceBundle.getObject(key);
    }

    /* (non-Javadoc)
     * @see java.util.ResourceBundle#getKeys()
     */
    @Override
    public Enumeration<String> getKeys() {
        return _resourceBundle.getKeys();
    }
	
    /** The resource bundle. */
    private final ResourceBundle _resourceBundle = ResourceBundle.getBundle(
            "content.Language_en_US", UTF8Control.INSTANCE);	
	

}
