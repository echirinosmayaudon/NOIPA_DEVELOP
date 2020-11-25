package it.gov.mef.shared.dto.dataset;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 

// TODO: Auto-generated Javadoc
/**
 * The Class DettaglioDataSetDto.
 */
public class DettaglioDataSetDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The year. */
	private String year ;
	
	/** The month. */
	private String month ;
	
	/** The formats. */
	private List<String> formats =new ArrayList<String>();
	
	/** The path load live. */
	private String pathLoadLive ;
	
	 
  
	/**
	 * Instantiates a new dettaglio data set dto.
	 */
	public DettaglioDataSetDto() {
		 super();
	}
 
	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
 	
	 /**
	  * Gets the month.
	  *
	  * @return the month
	  */
	 public String getMonth() {
		return month;
	}
 
	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(String year) {
		this.year = year;
	}
 
	/**
	 * Sets the month.
	 *
	 * @param month the new month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

 
	/**
	 * Gets the formats.
	 *
	 * @return the formats
	 */
	public List<String> getFormats() {
		return formats;
	}
 
	/**
	 * Sets the formats.
	 *
	 * @param formats the new formats
	 */
	public void setFormats(List<String> formats) {
		this.formats = formats;
	}

	/**
	 * Gets the path load live.
	 *
	 * @return the path load live
	 */
	public String getPathLoadLive() {
		return pathLoadLive;
	}

	/**
	 * Sets the path load live.
	 *
	 * @param pathLoadLive the new path load live
	 */
	public void setPathLoadLive(String pathLoadLive) {
		this.pathLoadLive = pathLoadLive;
	}
 
}
