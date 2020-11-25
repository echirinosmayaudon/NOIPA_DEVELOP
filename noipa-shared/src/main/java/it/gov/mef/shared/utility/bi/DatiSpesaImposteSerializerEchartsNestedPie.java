package it.gov.mef.shared.utility.bi;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

import it.gov.mef.shared.dto.bi.ImpostaEnteDto;
import it.gov.mef.shared.dto.bi.ListSpesaEntiDto;
import it.gov.mef.shared.dto.bi.SpesaEnteDto;

// TODO: Auto-generated Javadoc
/**
 * Classe che si occupa della serializzazione json 
 * (per la libreria echarts) delle voci di spesa
 * per il grafico nested pie.
 *
 * @author d.brandi
 */
public class DatiSpesaImposteSerializerEchartsNestedPie extends StdSerializer<ListSpesaEntiDto> {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new dati spesa imposte serializer echarts nested pie.
	 */
	public DatiSpesaImposteSerializerEchartsNestedPie() {
		this(null);
	}
	
	/**
	 * Instantiates a new dati spesa imposte serializer echarts nested pie.
	 *
	 * @param t the t
	 */
	public DatiSpesaImposteSerializerEchartsNestedPie(Class<ListSpesaEntiDto> t) {
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
			for(ImpostaEnteDto imposta : ente.getImposte_ente()) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeStringField("name", UtilityLang.getImpostaDescForLanguage(imposta.getCod_tipo_imposta()));
				jsonGenerator.writeNumberField("value", imposta.getImporto());
				jsonGenerator.writeObjectFieldStart("itemStyle");
				jsonGenerator.writeStringField("color", obj.getMapImposteColor().get(ente.getCod_ente()).get(imposta.getCod_tipo_imposta()));
				jsonGenerator.writeEndObject();
				jsonGenerator.writeEndObject();
			}
		}
		jsonGenerator.writeEndArray();

	}
}

