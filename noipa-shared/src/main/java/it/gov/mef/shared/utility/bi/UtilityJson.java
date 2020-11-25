package it.gov.mef.shared.utility.bi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.text.StringEscapeUtils;

import it.gov.mef.shared.dto.bi.DettaglioImpostaEnteDto;
import it.gov.mef.shared.dto.bi.ImpostaEnteDto;
import it.gov.mef.shared.dto.bi.ListSpesaEntiDto;
import it.gov.mef.shared.dto.bi.SpesaEnteDto;
// TODO: Auto-generated Javadoc

/**
 * Classe di utilità per la gestione dei json.
 *
 * @author d.brandi
 */
public class UtilityJson {
	
	/**
	 * Escape string.
	 *
	 * @param stringToEscape the string to escape
	 * @return the string
	 */
	public static String escapeString(String stringToEscape) {
		return StringEscapeUtils.escapeEcmaScript(stringToEscape);
	}
	
	/**
	 * Gets the map imposte.
	 *
	 * @param result the result
	 * @return estrazione della mappa che ha compe chiave l'imposta e come valore l'insieme di dettagli imposte a partire dall'output del servizio esterno
	 * che restituisce i dati della spesa
	 */
	public static Map<ImpostaEnteDto, Set<DettaglioImpostaEnteDto>> getMapImposte(ListSpesaEntiDto result) {
		HashMap<ImpostaEnteDto,Set<DettaglioImpostaEnteDto>> mapImposteDettImposte = new HashMap<>();
		Set<DettaglioImpostaEnteDto> listaDettImposte;
		for(SpesaEnteDto ente : result.getEnti()) {
			for(ImpostaEnteDto imposta : ente.getImposte_ente()) {
				listaDettImposte = mapImposteDettImposte.get(imposta)!=null?mapImposteDettImposte.get(imposta) : new HashSet();
				for(DettaglioImpostaEnteDto dettImposta : imposta.getDettaglio_imposta()) {
					listaDettImposte.add(new DettaglioImpostaEnteDto(dettImposta.getCod_imposta()));
				}
				mapImposteDettImposte.put(new ImpostaEnteDto(imposta.getCod_tipo_imposta()),listaDettImposte);
			}
		}
		return mapImposteDettImposte;
	}
}
