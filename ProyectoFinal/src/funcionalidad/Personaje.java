package funcionalidad;

import java.io.Serializable;
import java.util.regex.Pattern;
import excepciones.ArmaNoValidaException;
import excepciones.FechaNoValidaException;
import excepciones.NombreNoValidoException;
import interfaces.Vida;

/**
 * Clase padre con los atributos y comportamientos gen�ricos
 * de todas las clases posibles de personaje
 * @author Lucas M�rquez Mu�oz
 * @version 1.0
 */
public class Personaje implements Serializable, Vida{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre del personaje
	 */
	private String nombre;
	
	/**
	 * Patr�n para comprobar el nombre del personaje
	 * El nombre tiene que empezar por un caracter alfab�tico, en may�scula o no,
	 * seguido de entre 1 y 12 caracteres alfab�ticos.
	 */
	static final private Pattern patternNombre = Pattern
			.compile("^[A-Za-z]\\w{1,12}$");
	
	/**
	 * Vida del personaje
	 */
	private int vida;
	
	/**
	 * Arma del personaje
	 */
	private Arma arma;
	
	/**
	 * Armadura del personaje
	 */
	private Armadura armadura;
	
	/**
	 * Edad del personaje
	 */
	private int edad;
	
	/**
	 * Constructor que recibe todos los par�metros del personaje
	 * @param nombre El nombre del personaje
	 * @param clase La clase del personaje
	 * @param arma El arma del personaje
	 * @param armadura La armadura del personaje
	 * @param nacimiento El a�o de nacimiento del personaje
	 * @throws NombreNoValidoException Excepci�n nombre no v�lido
	 * @throws ArmaNoValidaException Excepci�n arma no v�lida
	 * @throws FechaNoValidaException excepci�n fecha no v�lida
	 */
	public Personaje(String nombre, ClasesPersonaje clase, Arma arma, Armadura armadura, int nacimiento) throws NombreNoValidoException, ArmaNoValidaException, FechaNoValidaException{
		setNombre(nombre);	
		setArma(arma);
		setArmadura(armadura);		
		setEdad(nacimiento);
		setVida(calcularVida());
	}	
	
	/**
	 * Constructor que no recibe par�metros
	 */
	public Personaje(){
		
	}	

	/**
	 * Constructor que recibe el nombre del personaje
	 * @param nombre El nombre del persoanje
	 * @throws NombreNoValidoException Excepci�n nombre no v�lido
	 */
	public Personaje(String nombre) throws NombreNoValidoException{
		setNombre(nombre);
	}
	
	/**
	 * Establece la edad del personaje en funci�n del a�o de nacimiento
	 * @param nacimiento El a�o de nacimiento
	 * @throws FechaNoValidaException Excepci�n fecha no v�lida
	 */
	private void setEdad(int nacimiento) throws FechaNoValidaException {		
		Fecha fecha = new Fecha(1, 1, nacimiento);
		this.edad = fecha.obtenerEdad(); 		
	}
	
	/**
	 * Obtiene la edad del personaje
	 * @return edad La edad del personaje
	 */
	public int getEdad(){
		return edad;
	}
	
	/**
	 * Obtiene el nombre del personaje
	 * @return nombre El nombre del personaje
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Establece el nombre del personaje en caso de ser v�lido
	 * @param nombre El nombre del personaje
	 * @throws NombreNoValidoException Excepci�n nombre no v�lido
	 */
	void setNombre(String nombre) throws NombreNoValidoException{
		if(!esValido(nombre))
			throw new NombreNoValidoException("Error. Nombre no v�lido.");
		this.nombre = nombre;
	}
	
	/**
	 * Comprueba si el nombre recibido es v�lido o no
	 * @param nombre El nombre a comprobar
	 * @return true si es v�lido. False en caso opuesto
	 */
	private boolean esValido(String nombre){
		return patternNombre.matcher(nombre).matches(); 
	}	

	/**
	 * Obtiene el arma del personaje
	 * @return arma El arma del personaje
	 */
	public Arma getArma(){
		return arma;
	}
	
	/**
	 * Establece el arma del personaje 
	 * @param arma El arma del personaje
	 * @throws ArmaNoValidaException Excepci�n arma no v�lida
	 */
	public void setArma(Arma arma) throws ArmaNoValidaException{
		if(arma==null)
			throw new ArmaNoValidaException("Error. Arma no v�lida.");
		this.arma = arma;
	}

	/**
	 * Obtiene la armadura del personaje
	 * @return armadura La armadura del personaje
	 */
	public Armadura getArmadura(){
		return armadura;
	}
	
	/**
	 * Establece la armadura del personaje 
	 * @param armadura La armadura del personaje
	 */
	void setArmadura(Armadura armadura){
		this.armadura = armadura;
	}
	
	/**
	 * Obtiene la vida del personaje
	 * @return vida La vida del personaje
	 */
	public int getVida(){
		return vida;
	}
	
	/**
	 * Establece la vida del personaje 
	 * @param vida La vida del personaje
	 */
	void setVida(int vida){
		this.vida = vida;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;		
		Personaje other = (Personaje) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int calcularVida() {		
		return 0;
	}	
}