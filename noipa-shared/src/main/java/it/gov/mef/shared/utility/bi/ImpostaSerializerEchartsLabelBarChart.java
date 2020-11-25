package it.gov.mef.shared.utility.bi;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

import it.gov.mef.shared.dto.bi.DettaglioImpostaEnteDto;
import it.gov.mef.shared.dto.bi.ImpostaEnteDto;
// TODO: Auto-generated Javadoc

/**
 * Classe che si occupa della serializzazione json 
 * (per la libreria echarts) delle label della legenda
 * per il grafico barchart.
 *
 * @author d.brandi
 */
public class ImpostaSerializerEchartsLabelBarChart extends StdSerializer<ImpostaEnteDto> {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new imposta serializer echarts label bar chart.
	 */
	public ImpostaSerializerEchartsLabelBarChart() {
		this(null);
	}
	
	/**
	 * Instantiates a new imposta serializer echarts label bar chart.
	 *
	 * @param t the t
	 */
	public ImpostaSerializerEchartsLabelBarChart(Class<ImpostaEnteDto> t) {
		super(t);
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	public void serialize(ImpostaEnteDto obj, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider)
					throws IOException {
		for(DettaglioImpostaEnteDto dettaglioImposta : obj.getDettaglio_imposta()) {
			jsonGenerator.writeObject(dettaglioImposta);
		}
	}
}

