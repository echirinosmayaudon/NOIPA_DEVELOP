package it.gov.mef.shared.dto.bi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.Serializable;
import java.util.Map;
import java.util.SortedSet;

import it.gov.mef.shared.utility.bi.DatiSpesaDettImposteSerializerEchartsNestedPie;
import it.gov.mef.shared.utility.bi.DatiSpesaEntiSerializerEchartsNestedPie;
import it.gov.mef.shared.utility.bi.DatiSpesaImposteSerializerEchartsNestedPie;
import it.gov.mef.shared.utility.bi.DatiSpesaLabelSerializerEchartsNestedPie;
import it.gov.mef.shared.utility.bi.DatiSpesaSerializerEchartsBarChart;
import it.gov.mef.shared.utility.bi.DatiSpesaSerializerEchartsSunburst;
import it.gov.mef.shared.utility.bi.DettaglioImpostaSerializerEchartsLabelBarChart;
import it.gov.mef.shared.utility.bi.ImpostaSerializerEchartsLabelBarChart;
import it.gov.mef.shared.utility.bi.SpesaEnteSerializerEchartsBar;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new list spesa enti dto.
 */
@Data
/**
 * Dto per la ricezione dei dati della spesa
 * contiene i dati della spesa per l'anno di interesse e 
 * l'importo totale di tutti gli enti
 * presenti nell'attributo enti
 * @author d.brandi
 *
 */
public class ListSpesaEntiDto implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The log. */
	private static Log _log = LogFactoryUtil.getLog(ListSpesaEntiDto.class);
	
	/** The anno. */
	private int anno;
	
	/** The enti. */
	private SortedSet<SpesaEnteDto> enti;
	//private Set<SpesaEnteDto> enti;
	
	/** The importo tot. */
	private double importo_tot;
	
	/** The map enti color. */
	private Map<String,String> mapEntiColor;
	
	/** The map imposte color. */
	private Map<String,Map<String,String>> mapImposteColor;
	
	/** The map dett imposte color. */
	private Map<String,String> mapDettImposteColor;

	/**
	 * Gets the sunburst json.
	 *
	 * metodo per la creazione del json da dare in pasto a echarts per la creazione dei grafico sunburst
	 * (il grafico è stato sostituito dal nested pie)
	 * @return the sunburst json
	 */
	@Deprecated
	public String getSunburstJson() {
		ObjectMapper mapper = new ObjectMapper();

		SimpleModule datiSpesaModule = 
				new SimpleModule("DatiSpesaSerializerEchartsSunburst", new Version(1, 0, 0, null, null, null));
		datiSpesaModule.addSerializer(ListSpesaEntiDto.class, new DatiSpesaSerializerEchartsSunburst());
		mapper.registerModule(datiSpesaModule);
		try {
			return mapper.writeValueAsString(this);
		}
		catch(JsonProcessingException jpe) {
			_log.error(jpe);
			return "";
		}
	}
	
	/**
	 * metodo per la creazione del json degli enti da dare in pasto a echarts per la creazione dei grafico nested pie.
	 *
	 * @return the json enti nested pie
	 */
	public String getJsonEntiNestedPie() {
		ObjectMapper mapper = new ObjectMapper();

		SimpleModule datiSpesaModule = 
				new SimpleModule("DatiSpesaEntiSerializerEchartsNestedPie", new Version(1, 0, 0, null, null, null));
		datiSpesaModule.addSerializer(ListSpesaEntiDto.class, new DatiSpesaEntiSerializerEchartsNestedPie());
		mapper.registerModule(datiSpesaModule);
		try {
			return mapper.writeValueAsString(this);
		}
		catch(JsonProcessingException jpe) {
			_log.error(jpe);
			return "";
		}
	}
	
	/**
	 * metodo per la creazione del json delle voci di spesa da dare in pasto a echarts per la creazione dei grafico nested pie.
	 *
	 * @return the json imposte nested pie
	 */
	public String getJsonImposteNestedPie() {
		ObjectMapper mapper = new ObjectMapper();

		SimpleModule datiSpesaModule = 
				new SimpleModule("DatiSpesaImposteSerializerEchartsNestedPie", new Version(1, 0, 0, null, null, null));
		datiSpesaModule.addSerializer(ListSpesaEntiDto.class, new DatiSpesaImposteSerializerEchartsNestedPie());
		mapper.registerModule(datiSpesaModule);
		try {
			return mapper.writeValueAsString(this);
		}
		catch(JsonProcessingException jpe) {
			_log.error(jpe);
			return "";
		}
	}
	
	/**
	 * metodo per la creazione del json del dettaglio delle voci di spesa da dare in pasto a echarts per la creazione dei grafico nested pie.
	 *
	 * @return the json dettagli imposte nested pie
	 */
	public String getJsonDettagliImposteNestedPie() {
		ObjectMapper mapper = new ObjectMapper();

		SimpleModule datiSpesaModule = 
				new SimpleModule("DatiSpesaDettImposteSerializerEchartsNestedPie", new Version(1, 0, 0, null, null, null));
		datiSpesaModule.addSerializer(ListSpesaEntiDto.class, new DatiSpesaDettImposteSerializerEchartsNestedPie());
		mapper.registerModule(datiSpesaModule);
		try {
			return mapper.writeValueAsString(this);
		}
		catch(JsonProcessingException jpe) {
			_log.error(jpe);
			return "";
		}
	}
	
	/**
	 * metodo per la creazione del json della label degli enti da dare in pasto a echarts per la creazione dei grafico nested pie.
	 *
	 * @return the json label nested pie
	 */
	public String getJsonLabelNestedPie() {
		ObjectMapper mapper = new ObjectMapper();

		SimpleModule datiSpesaModule = 
				new SimpleModule("DatiSpesaLabelSerializerEchartsNestedPie", new Version(1, 0, 0, null, null, null));
		datiSpesaModule.addSerializer(ListSpesaEntiDto.class, new DatiSpesaLabelSerializerEchartsNestedPie());
		mapper.registerModule(datiSpesaModule);
		try {
			return mapper.writeValueAsString(this);
		}
		catch(JsonProcessingException jpe) {
			_log.error(jpe);
			return "";
		}
	}
	
	/**
	 * metodo per la creazione del json della label degli enti da dare in pasto a echarts per la creazione dei grafico barchart.
	 *
	 * @return the json enti echart bar
	 */
	public String getJsonEntiEchartBar() {
		ObjectMapper mapper = new ObjectMapper();

		SimpleModule spesaEnteSerializerEchartsLegendDataModule = 
				new SimpleModule("SpesaEnteSerializerEchartsBar", new Version(1, 0, 0, null, null, null));
		spesaEnteSerializerEchartsLegendDataModule.addSerializer(SpesaEnteDto.class, new SpesaEnteSerializerEchartsBar());
		mapper.registerModule(spesaEnteSerializerEchartsLegendDataModule);

		try {
			return mapper.writeValueAsString(this.getEnti());
		}
		catch(JsonProcessingException jpe) {
			_log.error(jpe);
			return "";
		}
	}
	
	/**
	 * metodo per la creazione del json della label delle voci di spesa da dare in pasto a echarts per la creazione dei grafico barchart.
	 *
	 * @return the json label echart bar
	 */
	public String getJsonLabelEchartBar() {
		if(getEnti() !=null && getEnti().size()>0) {
			ObjectMapper mapper = new ObjectMapper();
	
			SimpleModule dettaglioImpostaSerializerEchartsLabelBarChart = 
					new SimpleModule("DettaglioImpostaSerializerEchartsLabelBarChart", new Version(1, 0, 0, null, null, null));
			dettaglioImpostaSerializerEchartsLabelBarChart.addSerializer(DettaglioImpostaEnteDto.class, new DettaglioImpostaSerializerEchartsLabelBarChart());
			mapper.registerModule(dettaglioImpostaSerializerEchartsLabelBarChart);
			SimpleModule impostaSerializerEchartsLabelBarChart = 
					new SimpleModule("ImpostaSerializerEchartsLabelBarChart", new Version(1, 0, 0, null, null, null));
			impostaSerializerEchartsLabelBarChart.addSerializer(ImpostaEnteDto.class, new ImpostaSerializerEchartsLabelBarChart());
			mapper.registerModule(impostaSerializerEchartsLabelBarChart);
	
			try {
				return mapper.writeValueAsString(this.getEnti().first().getImposte_ente());
			}
			catch(JsonProcessingException jpe) {
				_log.error(jpe);
				return "";
			}
		}
		return null;
	}
/**
 * metodo per la creazione del json contenente i dati da dare in pasto a echarts per la creazione dei grafico barchart.
 *
 * @return the json series echart bar
 */
	public String getJsonSeriesEchartBar() {		
		ObjectMapper mapper = new ObjectMapper();

		SimpleModule datiSpesaSerializerEchartsBarChartModule = 
				new SimpleModule("DatiSpesaSerializerEchartsBarChart", new Version(1, 0, 0, null, null, null));
		datiSpesaSerializerEchartsBarChartModule.addSerializer(ListSpesaEntiDto.class, new DatiSpesaSerializerEchartsBarChart());
		mapper.registerModule(datiSpesaSerializerEchartsBarChartModule);

		try {
			return mapper.writeValueAsString(this);
		}
		catch(JsonProcessingException jpe) {
			_log.error(jpe);
			return "''";
		}
	}

}
