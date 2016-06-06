package funcionalidad;

import excepciones.ArmaNoValidaException;
import excepciones.FechaNoValidaException;
import excepciones.NombreNoValidoException;
import interfaces.Magico;
import interfaces.Vida;

/**
 * Clase tipo de personaje Brujo
 * @author Lucas M�rquez Mu�oz
 * @version 1.0
 */

public class Brujo extends Personaje implements Magico, Vida {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * La cantidad de man� del brujo
	 */
	private int mana;
	
	/**
	 * Constructor que recibe todos los par�metros
	 * @param nombre El nombre del brujo
	 * @param arma El arma del brujo
	 * @param armadura La armadura del brujo
	 * @param nacimiento El a�o de nacimiento del brujo	  
	 * @throws NombreNoValidoException Excepci�n nombre no v�lido
	 * @throws ArmaNoValidaException Excepci�n arma no v�lida
	 * @throws FechaNoValidaException Excepci�n fecha no v�lida
	 */

	public Brujo(String nombre, Arma arma, Armadura armadura, int nacimiento) throws NombreNoValidoException, ArmaNoValidaException, FechaNoValidaException {
		super(nombre, ClasesPersonaje.BRUJO, arma, armadura, nacimiento);
		setVida(calcularVida());
		setMana();
	}
	
	/**
	 * Constructor que no recibe par�metros
	 */
	public Brujo(){
		super();
	}
	
	/**
	 * Obtiene el man� que tiene el brujo
	 * @return mana El man� del brujo
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * Establece el man� que tiene el brujo en base a su edad 
	 */
	void setMana() {
		if(getEdad()<18)
			this.mana = (int)(Math.random()*(1-10)+10);
		if(getEdad()>=18 && getEdad()<30)
			this.mana = (int)(Math.random()*(10-25)+25);			
		if(getEdad()>=30 && getEdad()<50)
			this.mana = (int)(Math.random()*(50-100)+100);
		if(getEdad()>=50 && getEdad()<65)
			this.mana = (int)(Math.random()*(100-150)+150);
		else
			this.mana = (int)(Math.random()*(150-200)+200);
	}

	/**
	 * Calcula la vida del brujo en base a su edad
	 * @return La vida del brujo
	 */
	@Override
	public int calcularVida() {	
		if(getEdad()<18)
			return (int)(Math.random()*(1-10)+10);
		if(getEdad()>=18 && getEdad()<30)
			return (int)(Math.random()*(50-90)+90);
		if(getEdad()>=30 && getEdad()<50)
			return (int)(Math.random()*(30-70)+70);
		if(getEdad()>=50 && getEdad()<65)
			return (int)(Math.random()*(20-50)+50); 
		else
			return (int)(Math.random()*(1-20)+20);
	}

	/**
	 * Calcula el da�o del hechizo normal del brujo en base a su edad
	 * @return el da�o del hechizo normal del brujo
	 */
	@Override
	public int calcularHechizoNormal() {
		if(getEdad()<18)
			return (int)(Math.random()*(1-3)+3);
		if(getEdad()>=18 && getEdad()<30)
			return (int)(Math.random()*(4-6)+6);
		if(getEdad()>=30 && getEdad()<50)
			return (int)(Math.random()*(7-10)+10);
		if(getEdad()>=50 && getEdad()<65)
			return (int)(Math.random()*(8-13)+13); 
		else
			return (int)(Math.random()*(11-13)+13);	
	}

	/**
	 * Calcula el da�o del hechizo fuerte del brujo en base a su edad
	 * @return el da�o del hechizo fuerte del brujo
	 */
	@Override
	public int calcularHechizoFuerte() {
		if(getEdad()<18)
			return (int)(Math.random()*(1-3)+3)*2;
		if(getEdad()>=18 && getEdad()<30)
			return (int)(Math.random()*(4-6)+6)*2;
		if(getEdad()>=30 && getEdad()<50)
			return (int)(Math.random()*(7-10)+10)*2;
		if(getEdad()>=50 && getEdad()<65)
			return (int)(Math.random()*(8-13)+13)*2; 
		else
			return (int)(Math.random()*(11-13)+13)*2;	
	}
}