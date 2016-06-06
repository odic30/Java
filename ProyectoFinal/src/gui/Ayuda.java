package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Muestra el enunciado del ejercicio en un di�logo no modal
 * @author Lucas M�rquez Mu�oz
 * @version 1.0
 */
public class Ayuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static Ayuda INSTANCE = null;	

	/**
	 * Create the dialog.
	 */
	private Ayuda() {		
		
		setTitle("Ver ayuda");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);		
		
		JTextArea txtrAyuda = new JTextArea();
		txtrAyuda.setEditable(false);		
		txtrAyuda.setText("Queremos crear un juego de peleas entre diferentes tipos de personajes que estar�n"
				+ "almacenados en listas de personajes.\r\n"
				+ "Las opciones posibles con los personajes son las siguientes:\r\n\r\n"
				+ "1. Crear personajes nuevos (Se pedir� el nombre, que tendr� que cumplir un patr�n,"
				+ "el tipo de personaje (brujo, guerrero, mago o p�caro), el a�o de nacimiento del personaje"
				+ "(para calcular su edad y, con esta, poder calcular: la cantidad de vida que tiene," 
				+ "su estad�stica secundaria y el da�o de sus ataques) y el arma que tendr�."
				
				+ "\r\n2. Eliminar personajes (buscados por nombre)."
				+ "\r\n3. Mostrar personajes (buscados por nombre)."
				+ "\r\n4. Mostrar la lista entera de personajes."
				
				+ "\r\n\r\nNo podr�n a�adirse personajes inv�lidos ni ya contenidos en lista (no pueden existir"
				+ "dos personajes con el mismo nombre). Por cada personaje que se cree se conocen todas"
				+ "sus caracter�sticas, no teniendo caracter�sticas por defecto."
				
				+ "\r\n\r\nAdem�s podremos crear, guardar y cargar tantas listas de personajes como queramos."
				
				+ "\r\n\r\nUna vez cargada una lista de personajes se podr� crear una partida nueva, que previamente"
				+ "nos pedir� que elijamos dos personajes para el combate."
				
				+ "\r\n\r\nYa en la ventana de combate, cada tipo de personaje tiene dos tipos de ataques: Uno normal"
				+ "menos poderoso y uno fuerte que es m�s poderoso pero consume parte de la estad�stica secundaria"
				+ "del personaje. ");
		txtrAyuda.setBounds(0, 0, 382, 153);
		
		JScrollPane scrollPane = new JScrollPane(txtrAyuda);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 382, 142);		
		getContentPane().add(scrollPane);		
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}			
		}		
	}
	
	/**
	 * Crea una instancia de esta clase en caso de que no exista
	 */
	private synchronized static void createInstance(){
		if(INSTANCE == null){
			INSTANCE = new Ayuda();
		}
	}
	
	/**
	 * Devuelve la instancia de esta clase. En caso de no existir, crea una
	 * @return INSTANCE La instancia de esta clase
	 */
	public static Ayuda getInstance(){
		if (INSTANCE == null) createInstance();
		return INSTANCE;
	}
}