package it.gov.mef.webformassistenza.noipa.http.util;

// TODO: Auto-generated Javadoc
/**
 * The Class FileAttachmentNoiPA.
 */
public class FileAttachmentNoiPA {
	
	/** The file name. */
	private String fileName;
	
	/** The mime type. */
	private String mimeType;
	
	/** The content. */
	private byte[] content;
	
	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public byte[] getContent() {
		return content;
	}
	
	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}
	
	/**
	 * Instantiates a new file attachment noi PA.
	 */
	public FileAttachmentNoiPA() {}
	
	/**
	 * Instantiates a new file attachment noi PA.
	 *
	 * @param fileName the file name
	 * @param mimeType the mime type
	 * @param content the content
	 */
	public FileAttachmentNoiPA(String fileName, String mimeType, byte[] content) {
		super();
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.content = content;
	}
	
	/**
	 * Gets the mime type.
	 *
	 * @return the mime type
	 */
	public String getMimeType() {
		return mimeType;
	}
	
	/**
	 * Sets the mime type.
	 *
	 * @param mimeType the new mime type
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
}
