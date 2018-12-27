package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelDatos extends JPanel implements ActionListener{

	private Controlador ctrl;
	private JLabel dat[] = new JLabel[9];
	private JButton btngenerar;
	
	public PanelDatos(Controlador ctrl)
	{
		//Pintar border en el Panel
		setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker()));
		//Color de fondo de panel
		setBackground(new Color(198,226,255));
		//Diposición
		setLayout( null );
		//Integar controlador
		this.ctrl=ctrl;
		//Texto Datos
		 dat[0] = new JLabel("Datos ");
		 Font auxFont=dat[0].getFont();
	     dat[0].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));
	     dat[0].setForeground(Color.BLUE.darker().darker().darker().darker());
	     dat[0].setBounds(10, 10, 300, 25);
	     add(dat[0]);
	     
		//Texto C.c
		 dat[1] = new JLabel("Numero de documento C.c: ");
		 Font auxFont1=dat[1].getFont();
	     dat[1].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
	     dat[1].setForeground(Color.BLUE.darker().darker().darker());
	     dat[1].setBounds(10, 70, 300, 15);
	     add(dat[1]);
	     
	   //Texto Nombre
		 dat[2] = new JLabel("Nombre: ");
		 Font auxFont2=dat[2].getFont();
	     dat[2].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
	     dat[2].setForeground(Color.BLUE.darker().darker().darker());
	     dat[2].setBounds(10, 105, 300, 15);
	     add(dat[2]);
	     
	   //Texto Apellido
		 dat[3] = new JLabel("Apellido: ");
		 Font auxFont3=dat[3].getFont();
	     dat[3].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
	     dat[3].setForeground(Color.BLUE.darker().darker().darker());
	     dat[3].setBounds(10, 140, 300, 15);
	     add(dat[3]);
	     
	     //Texto Edad
		 dat[4] = new JLabel("Edad: ");
		 Font auxFont4=dat[4].getFont();
	     dat[4].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
	     dat[4].setForeground(Color.BLUE.darker().darker().darker());
	     dat[4].setBounds(10, 175, 300, 15);
	     add(dat[4]);
	     
	   //LBL Respuestas
	   //Texto C.C r
		 dat[5] = new JLabel("------");
		 Font auxFont5=dat[5].getFont();
	     dat[5].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
	     dat[5].setForeground(Color.BLACK);
	     dat[5].setBounds(250, 70, 300, 15);
	     add(dat[5]);
	     
	     //Texto Nombre r
		 dat[6] = new JLabel("---------");
		 Font auxFont6=dat[6].getFont();
	     dat[6].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
	     dat[6].setForeground(Color.BLACK);
	     dat[6].setBounds(250, 105, 300, 15);
	     add(dat[6]);
	     
	     //Texto Apellido r
		 dat[7] = new JLabel("--------");
		 Font auxFont7=dat[7].getFont();
	     dat[7].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
	     dat[7].setForeground(Color.BLACK);
	     dat[7].setBounds(250, 140, 300, 15);
	     add(dat[7]);
	     
	     //Texto edad r
		 dat[8] = new JLabel("--");
		 Font auxFont8=dat[8].getFont();
	     dat[8].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
	     dat[8].setForeground(Color.BLACK);
	     dat[8].setBounds(250, 175, 300, 15);
	     add(dat[8]);
	     
	     //Boton Generar
	     btngenerar = new JButton("Generar");
	     btngenerar.addActionListener(this);
		 add(btngenerar);
		 btngenerar.setBounds(150, 210, 80, 30);
	}
	public void actionPerformed(ActionEvent e) {ctrl.setGenerarDatos();}
	public void setGenerarDatos(String nom,String apell,String edad,String cc)
	{dat[5].setText(cc);dat[6].setText(nom);dat[7].setText(apell);dat[8].setText(edad);}
}
