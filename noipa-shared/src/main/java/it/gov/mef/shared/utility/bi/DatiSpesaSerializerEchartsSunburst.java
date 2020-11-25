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
 * (per la libreria echarts) dell'oggettone ListSpesaEntiDto 
 * che contiene i dati spesa per i vari enti
 * per il grafico sunburst (sostituito da nested pie).
 *
 * @author d.brandi
 */
public class DatiSpesaSerializerEchartsSunburst extends StdSerializer<ListSpesaEntiDto> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new dati spesa serializer echarts sunburst.
	 */
	public DatiSpesaSerializerEchartsSunburst() {
		this(null);
	}
	
	/**
	 * Instantiates a new dati spesa serializer echarts sunburst.
	 *
	 * @param t the t
	 */
	public DatiSpesaSerializerEchartsSunburst(Class<ListSpesaEntiDto> t) {
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
			jsonGenerator.writeStartObject();
			jsonGenerator.writeStringField("name",  ente.getDescr_ente());
			jsonGenerator.writeNumberField("value", ente.getImporto());
			jsonGenerator.writeObjectFieldStart("itemStyle");
			jsonGenerator.writeStringField("color", obj.getMapEntiColor().get(ente.getDescr_ente()));
			jsonGenerator.writeEndObject();
			jsonGenerator.writeFieldName("children");
			jsonGenerator.writeStartArray();
						
		
			for(ImpostaEnteDto imposta : ente.getImposte_ente()) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeStringField("name", UtilityLang.getImpostaDescForLanguage(imposta.getCod_tipo_imposta()));
				jsonGenerator.writeNumberField("value", imposta.getImporto());
				jsonGenerator.writeObjectFieldStart("itemStyle");
				jsonGenerator.writeStringField("color", obj.getMapImposteColor().get(ente.getCod_ente()).get(imposta.getCod_tipo_imposta()));
				jsonGenerator.writeEndObject();
				//jsonGenerator.writeFieldName("children");
//				jsonGenerator.writeStartArray();
//				for(DettaglioImpostaEnteDto dettaglioImposta : imposta.getDettaglio_imposta()) {
//
//					jsonGenerator.writeStartObject();
//					jsonGenerator.writeStringField("name", UtilityLang.getImpostaDescForLanguage(dettaglioImposta.getCod_imposta()));
//					jsonGenerator.writeNumberField("value", dettaglioImposta.getImporto());
//					jsonGenerator.writeObjectFieldStart("itemStyle");
//					jsonGenerator.writeStringField("color", obj.getMapDettImposteColor().get(dettaglioImposta.getCod_imposta()));
//					jsonGenerator.writeEndObject();
//					jsonGenerator.writeEndObject();
//				}
				//jsonGenerator.writeEndArray();
				jsonGenerator.writeEndObject();
			}
			jsonGenerator.writeEndArray();
			jsonGenerator.writeEndObject();
		}
		jsonGenerator.writeEndArray();

	}
}

