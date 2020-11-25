package it.gov.mef.shared.utility.bi;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

import it.gov.mef.shared.dto.bi.DettaglioImpostaEnteDto;
import it.gov.mef.shared.dto.bi.ImpostaEnteDto;
import it.gov.mef.shared.dto.bi.ListSpesaEntiDto;
import it.gov.mef.shared.dto.bi.SpesaEnteDto;

// TODO: Auto-generated Javadoc
/**
 * Classe che si occupa della serializzazione json 
 * (per la libreria echarts) del dettaglio voci di spesa 
 * per il grafico nested pie.
 *
 * @author d.brandi
 */
public class DatiSpesaDettImposteSerializerEchartsNestedPie extends StdSerializer<ListSpesaEntiDto> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new dati spesa dett imposte serializer echarts nested pie.
	 */
	public DatiSpesaDettImposteSerializerEchartsNestedPie() {
		this(null);
	}
	
	/**
	 * Instantiates a new dati spesa dett imposte serializer echarts nested pie.
	 *
	 * @param t the t
	 */
	public DatiSpesaDettImposteSerializerEchartsNestedPie(Class<ListSpesaEntiDto> t) {
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
				for(DettaglioImpostaEnteDto dettaglioImposta : imposta.getDettaglio_imposta()) {
					jsonGenerator.writeStartObject();
					jsonGenerator.writeStringField("name", UtilityLang.getDettImpostaDescForLanguage(dettaglioImposta.getCod_imposta()));
					jsonGenerator.writeNumberField("value", dettaglioImposta.getImporto());
					jsonGenerator.writeObjectFieldStart("itemStyle");
					jsonGenerator.writeStringField("color", obj.getMapDettImposteColor().get(dettaglioImposta.getCod_imposta()));
					jsonGenerator.writeEndObject();
					jsonGenerator.writeEndObject();
				}
			}
		}
		jsonGenerator.writeEndArray();

	}
}

