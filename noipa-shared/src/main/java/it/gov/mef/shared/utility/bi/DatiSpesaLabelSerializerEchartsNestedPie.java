package it.gov.mef.shared.utility.bi;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

import it.gov.mef.shared.dto.bi.ListSpesaEntiDto;
import it.gov.mef.shared.dto.bi.SpesaEnteDto;
// TODO: Auto-generated Javadoc

/**
 * Classe che si occupa della serializzazione json 
 * (per la libreria echarts) delle label della legenda
 * per il grafico nested pie.
 *
 * @author d.brandi
 */
public class DatiSpesaLabelSerializerEchartsNestedPie extends StdSerializer<ListSpesaEntiDto> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new dati spesa label serializer echarts nested pie.
	 */
	public DatiSpesaLabelSerializerEchartsNestedPie() {
		this(null);
	}
	
	/**
	 * Instantiates a new dati spesa label serializer echarts nested pie.
	 *
	 * @param t the t
	 */
	public DatiSpesaLabelSerializerEchartsNestedPie(Class<ListSpesaEntiDto> t) {
		super(t);
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	public void serialize(ListSpesaEntiDto obj, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider)
					throws IOException {

		jsonGenerator.writeStartArray();
		for(SpesaEnteDto ente : obj.getEnti()) {
			jsonGenerator.writeString(ente.getDescr_ente());
		}
		jsonGenerator.writeEndArray();

	}
}

