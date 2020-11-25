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
 * (per la libreria echarts) dei dati spesa di un ente
 * per il grafico nested pie.
 *
 * @author d.brandi
 */
public class DatiSpesaEntiSerializerEchartsNestedPie extends StdSerializer<ListSpesaEntiDto> {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new dati spesa enti serializer echarts nested pie.
	 */
	public DatiSpesaEntiSerializerEchartsNestedPie() {
		this(null);
	}
	
	/**
	 * Instantiates a new dati spesa enti serializer echarts nested pie.
	 *
	 * @param t the t
	 */
	public DatiSpesaEntiSerializerEchartsNestedPie(Class<ListSpesaEntiDto> t) {
		super(t);
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	public void serialize(ListSpesaEntiDto obj, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider)
					throws IOException {


		jsonGenerator.writeStartArray();
		int i=0;
		for(SpesaEnteDto ente : obj.getEnti()) {
			if(i < UtilityColori.DEFAULT_ENTI_BASE_COLOR.size()+1) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeStringField("name",  ente.getDescr_ente());
				jsonGenerator.writeNumberField("value", ente.getImporto());
				jsonGenerator.writeObjectFieldStart("itemStyle");
				jsonGenerator.writeStringField("color", obj.getMapEntiColor().get(ente.getDescr_ente()));
				jsonGenerator.writeEndObject();
				jsonGenerator.writeEndObject();
				i++;
			}
		}
		jsonGenerator.writeEndArray();

	}
}

