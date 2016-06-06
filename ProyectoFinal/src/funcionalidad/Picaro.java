package funcionalidad;

import excepciones.ArmaNoValidaException;
import excepciones.FechaNoValidaException;
import excepciones.NombreNoValidoException;
import interfaces.Fisico;
import interfaces.Vida;

/**
 * Clase tipo de personaje P�caro
 * @author Lucas M�rquez Mu�oz
 * @version 1.0
 */
public class Picaro extends Personaje implements Fisico, Vida {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Energ�a del p�caro
	 */
	private int energia;
	
	/**
	 * Constructor que recibe todos los par�metros
	 * @param nombre El nombre del p�caro
	 * @param arma El arma del p�caro
	 * @param armadura La armadura del p�caro
	 * @param nacimiento El a�o de nacimiento del p�caro
	 * @throws NombreNoValidoException Excepci�n nombre no v�lido
	 * @throws ArmaNoValidaException Excepci�n arma no v�lida
	 * @throws FechaNoValidaException Excepci�n fecha no v�lida
	 */
	public Picaro(String nombre, Arma arma, Armadura armadura, int nacimiento) throws NombreNoValidoException, ArmaNoValidaException, FechaNoValidaException {
		super(nombre, ClasesPersonaje.PICARO, arma, armadura, nacimiento);
		setVida(calcularVida());
		setEnergia();
	}
	
	/**
	 * Cosntructor que no recibe par�metros
	 */
	public Picaro(){
		super();
	}
	
	/**
	 * Obtiene la energ�a que tiene el p�caro
	 * @return energ�a La energ�a del p�caro
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Establece la energ�a que tiene el p�caro en base a su edad	 
	 */
	void setEnergia() {
		if(getEdad()<18)
			this.energia = (int)(Math.random()*(1-10)+10);
		if(getEdad()>=18 && getEdad()<30)
			this.energia = (int)(Math.random()*(150-200)+200);
		if(getEdad()>=30 && getEdad()<50)
			this.energia = (int)(Math.random()*(100-150)+150);
		if(getEdad()>=50 && getEdad()<65)
			this.energia = (int)(Math.random()*(50-100)+100); 
		else
			this.energia = (int)(Math.random()*(10-25)+25);		
	}

	/**
	 * Calcula la vida del p�caro en base a su edad
	 * @return La vida del p�caro
	 */
	@Override
	public int calcularVida() {	
		if(getEdad()<18)
			return (int)(Math.random()*(1-10)+10);
		if(getEdad()>=18 && getEdad()<30)
			return (int)(Math.random()*(50-95)+95);
		if(getEdad()>=30 && getEdad()<50)
			return (int)(Math.random()*(30-75)+75);
		if(getEdad()>=50 && getEdad()<65)
			return (int)(Math.random()*(20-65)+65); 
		else
			return (int)(Math.random()*(1-15)+15);
	}

	/**
	 * Calcula el da�o del ataque normal del p�caro en base a su edad
	 * @return el da�o del ataque normal del p�caro
	 */
	@Override
	public int calcularAtaqueNormal() {		
		if(getEdad()<18)
			return (int)(Math.random()*(1-3)+3);
		if(getEdad()>=18 && getEdad()<30)
			return (int)(Math.random()*(5-8)+8);
		if(getEdad()>=30 && getEdad()<50)
			return (int)(Math.random()*(7-12)+12);
		if(getEdad()>=50 && getEdad()<65)
			return (int)(Math.random()*(6-11)+11); 
		else
			return (int)(Math.random()*(1-15)+15);		
	}

	/**
	 * Calcula el da�o del ataque fuerte del p�caro en base a su edad
	 * @return el da�o del ataque fuerte del p�caro
	 */
	@Override
	public int calcularAtaqueFuerte() {	
		if(getEdad()<18)
			return (int)(Math.random()*(1-3)+3)*2;
		if(getEdad()>=18 && getEdad()<30)
			return (int)(Math.random()*(5-8)+8)*2;
		if(getEdad()>=30 && getEdad()<50)
			return (int)(Math.random()*(7-12)+12)*2;
		if(getEdad()>=50 && getEdad()<65)
			return (int)(Math.random()*(6-11)+11)*2; 
		else
			return (int)(Math.random()*(1-15)+15)*2;	
	}
}