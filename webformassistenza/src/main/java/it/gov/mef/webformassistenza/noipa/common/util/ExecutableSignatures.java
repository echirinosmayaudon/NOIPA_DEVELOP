package it.gov.mef.webformassistenza.noipa.common.util;

// TODO: Auto-generated Javadoc
/**
 * The Enum ExecutableSignatures.
 */
public enum ExecutableSignatures {
	
	/** The windows exe. */
	WINDOWS_EXE("Windows|DOS executable file", (byte) 0x00, (byte) 0x02,
			new byte[] { (byte) 0x4d, (byte) 0x5a }),
	
	/** The java bytecode. */
	JAVA_BYTECODE("Java Bytecode", (byte) 0x00, (byte) 0x04,
					new byte[] { (byte) 0xca, (byte) 0xfe, (byte) 0xba, (byte) 0xbe });

	/** The description. */
	/* Here more enumeration */
	private String description;
	
	/** The offset. */
	private byte offset;
	
	/** The size. */
	private byte size;
	
	/** The magic number. */
	private byte[] magicNumber;

	/**
	 * Instantiates a new executable signatures.
	 *
	 * @param description the description
	 * @param offset the offset
	 * @param size the size
	 * @param magicNumber the magic number
	 */
	private ExecutableSignatures(String description, byte offset, byte size, byte[] magicNumber) {

		this.description = description;
		this.offset = offset;
		this.size = size;
		this.magicNumber = magicNumber;

	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the offset.
	 *
	 * @return the offset
	 */
	public byte getOffset() {
		return offset;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public byte getSize() {
		return size;
	}

	/**
	 * Gets the magic number.
	 *
	 * @return the magic number
	 */
	public byte[] getMagicNumber() {
		return magicNumber;
	}
	
	
}