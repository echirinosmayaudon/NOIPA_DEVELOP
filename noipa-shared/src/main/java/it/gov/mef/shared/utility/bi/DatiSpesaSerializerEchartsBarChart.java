package it.gov.mef.shared.utility.bi;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import it.gov.mef.shared.dto.bi.DettaglioImpostaEnteDto;
import it.gov.mef.shared.dto.bi.ImpostaEnteDto;
import it.gov.mef.shared.dto.bi.ListSpesaEntiDto;
import it.gov.mef.shared.dto.bi.SpesaEnteDto;

// TODO: Auto-generated Javadoc
/**
 * Classe che si occupa della serializzazione json 
 * (per la libreria echarts) dell'oggettone ListSpesaEntiDto 
 * che contiene i dati spesa per i vari enti
 * per il grafico barchart.
 *
 * @author d.brandi
 */
public class DatiSpesaSerializerEchartsBarChart extends StdSerializer<ListSpesaEntiDto> {

	/** The Constant CIFRE_DECIMALI_PERCENTUALE. */
	private static final int CIFRE_DECIMALI_PERCENTUALE = 2;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new dati spesa serializer echarts bar chart.
	 */
	public DatiSpesaSerializerEchartsBarChart() {
		this(null);
	}
	
	/**
	 * Instantiates a new dati spesa serializer echarts bar chart.
	 *
	 * @param t the t
	 */
	public DatiSpesaSerializerEchartsBarChart(Class<ListSpesaEntiDto> t) {
		super(t);
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	public void serialize(ListSpesaEntiDto obj, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider)
					throws IOException {
		Map<String, SortedMap<SpesaEnteDto,Double>> mapImposte = new HashMap<>();
		for(SpesaEnteDto ente : obj.getEnti()) {
			for(ImpostaEnteDto imposta: ente.getImposte_ente()) {
				for(DettaglioImpostaEnteDto dettImposta : imposta.getDettaglio_imposta()) {
					if(!mapImposte.containsKey(dettImposta.getCod_imposta())) {
						mapImposte.put(dettImposta.getCod_imposta(),new TreeMap<>());
					}
					if(!mapImposte.get(dettImposta.getCod_imposta()).containsKey(ente)) {
						mapImposte.get(dettImposta.getCod_imposta()).put(ente, dettImposta.getImporto());

					}
	                else {
	                	throw new JsonParseException("errore durante il parsing dei dati: trovati più valori per lo stesso ente e per lo stesso dettaglio imposte");
	                }

				}
			}
		}
		jsonGenerator.writeStartArray();
		for(String codDettImposta: mapImposte.keySet()) {
			//TODO spostare su apposito mapper dettaglioImpostaEnte
			jsonGenerator.writeStartObject();
			//TODO spostare su apposito mapper Ente
			jsonGenerator.writeStringField("name", UtilityLang.getDettImpostaDescForLanguage(codDettImposta));

			jsonGenerator.writeStringField("type", "bar");
			jsonGenerator.writeStringField("stack", "Test");

			jsonGenerator.writeObjectFieldStart("itemStyle");
			jsonGenerator.writeObjectFieldStart("normal");
			jsonGenerator.writeStringField("color", obj.getMapDettImposteColor().get(codDettImposta));
			jsonGenerator.writeEndObject();
			jsonGenerator.writeEndObject();

			jsonGenerator.writeObjectFieldStart("label");
			jsonGenerator.writeObjectFieldStart("normal");
			jsonGenerator.writeObjectField("formatter", "{c}%");
			jsonGenerator.writeBooleanField("show", false);
			jsonGenerator.writeStringField("position", "insideRight");
			jsonGenerator.writeEndObject();
			jsonGenerator.writeEndObject();
			jsonGenerator.writeArrayFieldStart("data");

			for(SpesaEnteDto ente : mapImposte.get(codDettImposta).keySet()) {
				double importo = mapImposte.get(codDettImposta).get(ente);
				double importoPercentuale= (importo/ente.getImporto())*100;
				BigDecimal importoPercentualeBd = UtilityNumbers.formatDecimalNumber(importoPercentuale,CIFRE_DECIMALI_PERCENTUALE);

				jsonGenerator.writeStartObject();
				jsonGenerator.writeNumberField("value",importoPercentualeBd.doubleValue());
				jsonGenerator.writeEndObject();

			}
			jsonGenerator.writeEndArray();
			jsonGenerator.writeStringField("barMaxWidth","80");
			jsonGenerator.writeEndObject();

		}
		jsonGenerator.writeEndArray();


	}
}

