package it.gov.mef.shared.utility.bi;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

import it.gov.mef.shared.dto.bi.DettaglioImpostaEnteDto;
// TODO: Auto-generated Javadoc

/**
 * Classe che si occupa della serializzazione json 
 * (per la libreria echarts) del dettaglio delle voci di spesa
 * per il grafico barchart.
 *
 * @author d.brandi
 */
public class DettaglioImpostaSerializerEchartsLabelBarChart extends StdSerializer<DettaglioImpostaEnteDto> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new dettaglio imposta serializer echarts label bar chart.
	 */
	public DettaglioImpostaSerializerEchartsLabelBarChart() {
		this(null);
	}
	
	/**
	 * Instantiates a new dettaglio imposta serializer echarts label bar chart.
	 *
	 * @param t the t
	 */
	public DettaglioImpostaSerializerEchartsLabelBarChart(Class<DettaglioImpostaEnteDto> t) {
		super(t);
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	public void serialize(DettaglioImpostaEnteDto obj, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider)
					throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("name",UtilityLang.getDettImpostaDescForLanguage(obj.getCod_imposta()));		
		jsonGenerator.writeEndObject();
	}
}

