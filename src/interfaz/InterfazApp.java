package interfaz;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controlador.Controlador;
import util.Util;

public class InterfazApp extends JFrame{

	 //Atributos
	private PanelHora pnlhora;
	private PanelAgenda pnlagenda;
	private PanelDatos pnldatos;
	
	// Atributo controlador
	Controlador ctrl;
	
	public InterfazApp(Controlador ctrl)
	{
		setTitle("Agenda");
		getContentPane( ).setLayout( null );
		
		//Icono JFrame
		Toolkit mipantalla=  Toolkit.getDefaultToolkit();
		Image MiIcono=mipantalla.getImage("imagenes/IconAge.png");//Icono
		setIconImage(MiIcono);
		
		
		// Integra el Controlador. 
	   	  this.ctrl=ctrl;
	   	  
	   // Instancia los paneles 
	   	pnlhora = new PanelHora(ctrl);
	   	pnlhora.setBounds(400, 300, 385, 260);
	   	pnlagenda = new PanelAgenda();
	   	pnlagenda.setBounds(10, 10, 775, 280);
	   	pnldatos = new PanelDatos(ctrl);
	   	pnldatos.setBounds(10, 300, 385, 260);
	   	
	   	
	 // Organizar el panel principal. 
	      getContentPane( ).add( pnlhora);
	      getContentPane( ).add( pnlagenda);
	      getContentPane( ).add( pnldatos);
	      
	   // Conecta objetos al controlador.
	      ctrl.conectar(pnlhora, pnlagenda, pnldatos);
	   // Propiedades de la interfaz.
	      
	      setSize(800,600);
	      setResizable(false);
	      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      
	  //  Centrar ventana.
	      	
	      Util.centrarVentana(this);
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterfazApp ventana = new InterfazApp(new Controlador());
		ventana.setVisible(true);
	}

}
