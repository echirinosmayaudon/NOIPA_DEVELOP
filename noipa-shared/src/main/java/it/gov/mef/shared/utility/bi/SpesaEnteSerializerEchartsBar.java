package it.gov.mef.shared.utility.bi;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

import it.gov.mef.shared.dto.bi.SpesaEnteDto;
// TODO: Auto-generated Javadoc

/**
 * Classe che si occupa della serializzazione json 
 * (per la libreria echarts) dei dati spesa per un ente
 * per il grafico barchart.
 *
 * @author d.brandi
 */
public class SpesaEnteSerializerEchartsBar extends StdSerializer<SpesaEnteDto> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new spesa ente serializer echarts bar.
	 */
	public SpesaEnteSerializerEchartsBar() {
		this(null);
	}
	
	/**
	 * Instantiates a new spesa ente serializer echarts bar.
	 *
	 * @param t the t
	 */
	public SpesaEnteSerializerEchartsBar(Class<SpesaEnteDto> t) {
		super(t);
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	public void serialize(SpesaEnteDto obj, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider)
					throws IOException {
		jsonGenerator.writeString(obj.getDescr_ente());
	}
}

