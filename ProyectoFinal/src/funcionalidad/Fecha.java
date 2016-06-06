package funcionalidad;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import excepciones.FechaNoValidaException;

/**
 * Clase Fecha utilizada para el c�lculo de edades de los personajes
 * @author Lucas M�rquez Mu�oz
 * @version 1.0
 */
public class Fecha {
	private GregorianCalendar calendar;
	
	/**
	 * Constructor por defecto
	 */
	public Fecha(){
		calendar=new GregorianCalendar();
	}
	
	/**
	 * Constructor que recibe como par�metros el dia, el mes y el a�o
	 * @param dia El d�a de la fecha
	 * @param mes El mes de la fecha
	 * @param anno El a�o de la fecha
	 * @throws FechaNoValidaException Excepci�n fecha no v�lida
	 */
	public Fecha(int dia, int mes, int anno) throws FechaNoValidaException{
		if(!esValida(dia, mes, anno))
			throw new FechaNoValidaException("Fecha no v�lida.");
		setGregorianCalendar(dia, mes, anno);
	}		
	
	/**
	 * Comprueba si la fecha dada a trav�s de enteros (d�a, mes y a�o) es v�lida
	 * @param dia El d�a de la fecha
	 * @param mes El mes de la fecha
	 * @param anno El a�o de la fecha
	 * @return true si es v�lida y false si no lo es
	 */
	private boolean esValida(int dia,int mes,int anno){
		try {
			setGregorianCalendar(dia, mes, anno);
			if(esFuturo())
				return false;
			return true;
		} catch (FechaNoValidaException e) {
			return false;
		}
	}	
	
	/**
	 * Comprueba si una fecha es posterior a la actual
	 * @return true en caso de que sea posterior, false en caso contrario
	 */
	public boolean esFuturo(){
		return calendar.after(GregorianCalendar.getInstance());
	}	
	
	/**
	 * Devuelve la edad en a�os seg�n la fecha de nacimiento recibida
	 * @return La edad en a�os
	 */
	public int obtenerEdad(){
		LocalDate fecha=LocalDate.of(calendar.get(GregorianCalendar.YEAR), 
				calendar.get(GregorianCalendar.MONTH)+1,
				calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		LocalDate fecha2 = LocalDate.now();
		
		return (int)ChronoUnit.YEARS.between(fecha, fecha2);
	}
	
	/**
	 * Crea una nueva fecha siempre que �sta sea v�lida
	 * @param dia El d�a del mes de la fecha a crear
	 * @param mes El mes de la fecha a crear
	 * @param anno El a�o de la fecha a crear
	 * @throws FechaNoValidaException Excepci�n fecha no v�lida
	 */
	void setGregorianCalendar(int dia, int mes, int anno) throws FechaNoValidaException{
		try {
			calendar= new GregorianCalendar(anno, mes, dia);
			calendar.setLenient(false);
			calendar.getTime();
		} catch (Exception e) {
			throw new FechaNoValidaException("Fecha no v�lida.");
		}
	}
	
	public GregorianCalendar getFecha() {
		return calendar;
	}

	@Override
	public String toString() {
		return "Fecha: " + calendar.get(GregorianCalendar.DAY_OF_MONTH) + 
				"/" + 
				(calendar.get(GregorianCalendar.MONTH)+1) + 
				"/" +
				calendar.get(GregorianCalendar.YEAR);
	}
}