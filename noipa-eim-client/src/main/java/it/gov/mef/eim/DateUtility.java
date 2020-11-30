package it.gov.mef.eim;

import java.util.Calendar;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Classe di utilità per la gestione delle date.
 *
 * @author d.brandi
 */
public class DateUtility {
	
	/**
	 * Instantiates a new date utility.
	 */
	private DateUtility() {
		super();
	}
	
	/**
	 * Gets the remaining days of month.
	 *
	 * @return giorni che rimangono prima della fine del mese attuale
	 */
	public static int getRemainingDaysOfMonth() {
		Calendar c = getCurrentCalendar();
		return c.getActualMaximum(Calendar.DAY_OF_MONTH)-c.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Gets the current year.
	 *
	 * @return anno corrente
	 */
	public static int getCurrentYear() {
		Calendar c = getCurrentCalendar();
		return c.get(Calendar.YEAR);
	}
	
	/**
	 * Gets the current month.
	 *
	 * @return codice rappresentante il mese corrente
	 */
	public static int getCurrentMonth() {
		Calendar c = getCurrentCalendar();
		return c.get(Calendar.MONTH)+1;
	}
	
	/**
	 * Gets the current calendar.
	 *
	 * @return oggetto Calendar dell'istante corrente
	 */
	private static Calendar getCurrentCalendar() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c;
	}
}
