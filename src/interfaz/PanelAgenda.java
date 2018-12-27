package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import controlador.Controlador;

public class PanelAgenda extends JPanel {

	//private String cabeceradat[],datos[][];
	private JTable tabla;
	private JLabel dat[]= new JLabel[6];
	private DefaultTableModel dtm;
	private int con,orga1_0,orga2_0,orga1_1,orga2_1,aux;
	private String orga1,orga2,vecaux[]=new String[5];
	private String cabecera[]=new String[32];
	private String datos[][] = new String[5][32];
	private int auxcon;
	private JLabel citasd[] = new JLabel[2];
	public PanelAgenda()
	{
		con=0;
		aux=0;
		auxcon=0;
		
		setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker()));
		setBackground(new Color(198,226,255));
		setLayout( null );
		
		// create a line border with the specified color and width
		 Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		//Texto Datos
		 dat[0] = new JLabel("Datos");
		 Font auxFont=dat[0].getFont();
	     dat[0].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));
	     dat[0].setForeground(Color.GREEN.darker().darker().darker().darker());
	     dat[0].setBounds(10, 10, 105, 45);
	     dat[0].setBorder(border);
	     add(dat[0]);
	     
	   //Texto C.c
		 dat[1] = new JLabel("C.c");
		 Font auxFont1=dat[1].getFont();
	     dat[1].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));
	     dat[1].setForeground(Color.GREEN.darker().darker().darker().darker());
	     dat[1].setBounds(10, 53, 105, 45);
	     dat[1].setBorder(border);
	     add(dat[1]);
	     
	   //Texto Nombre
		 dat[2] = new JLabel("Nombre");
		 Font auxFont2=dat[2].getFont();
	     dat[2].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));
	     dat[2].setForeground(Color.GREEN.darker().darker().darker().darker());
	     dat[2].setBounds(10, 94, 105, 45);
	     dat[2].setBorder(border);
	     add(dat[2]);
	     
	   //Texto Apellido
		 dat[3] = new JLabel("Apellido");
		 Font auxFont3=dat[3].getFont();
	     dat[3].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));
	     dat[3].setForeground(Color.GREEN.darker().darker().darker().darker());
	     dat[3].setBounds(10, 135, 105, 45);
	     dat[3].setBorder(border);
	     add(dat[3]);
	     
	   //Texto Edad
		 dat[4] = new JLabel("Edad");
		 Font auxFont4=dat[4].getFont();
	     dat[4].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));
	     dat[4].setForeground(Color.GREEN.darker().darker().darker().darker());
	     dat[4].setBounds(10, 176, 105, 45);
	     dat[4].setBorder(border);
	     add(dat[4]);
	     
	   //Texto Hora
		 dat[5] = new JLabel("Hora");
		 Font auxFont5=dat[5].getFont();
	     dat[5].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));
	     dat[5].setForeground(Color.GREEN.darker().darker().darker().darker());
	     dat[5].setBounds(10, 217, 105, 45);
	     dat[5].setBorder(border);
	     add(dat[5]);
	     
	     citasd[0] = new JLabel("Citas disponibles: ");
		 Font auxFont6=citasd[0].getFont();
		 citasd[0].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		 citasd[0].setForeground(Color.GREEN.darker().darker().darker().darker());
		 citasd[0].setBounds(300, 10, 250, 25);
	     add(citasd[0]);
	     
	     citasd[1] = new JLabel("32 ");
		 Font auxFont7=citasd[1].getFont();
		 citasd[1].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		 citasd[1].setForeground(Color.GREEN.darker().darker());
		 citasd[1].setBounds(430, 10, 250, 25);
	     add(citasd[1]);
	     
	     
	      
	     for(int i=0;i<cabecera.length;i++)
	     {
	    	 cabecera[i]=String.valueOf(i+1);
	     }
	     
	       dtm= new DefaultTableModel(datos,cabecera);
		   tabla = new JTable(dtm);
		   Font auxFont90=tabla.getFont();
		   tabla.setFont(new Font(auxFont90.getFontName(), auxFont90.getStyle(), 20));
		   tabla.setPreferredScrollableViewportSize(new Dimension(450, 100));
		   tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  
		   TableColumnModel columnModel = tabla.getColumnModel();
		   for (int i = 0; i < columnModel.getColumnCount(); i++)
		   {
		    columnModel.getColumn(i).setPreferredWidth(200);
		   }
		   tabla.setRowHeight(41);
		   JScrollPane scrollPane = new JScrollPane(tabla);
		   scrollPane.setBounds(115, 35, 650, 243);
		   add(scrollPane);
		   
	     	
	}
	
	public void setllenartabla(String nom,String apell,String edad,String id,String hora,int i)
	{
		String horaaux="",hor1="",hor2="";
		
		if(hora.length()==3)
		{
			hor1=hora.substring(0,1);
			hor2=hora.substring(1, 3);
			horaaux="0"+hor1+":"+hor2;
			System.out.println("Es de 8 a 9");
		}
		else if(hora.length()==4)
		{
			hor1=hora.substring(0,2);
			hor2=hora.substring(2, 4);
			horaaux=hor1+":"+hor2;
			System.out.println("Es de 10 a 18");

		}
			dtm.setValueAt(id,0,i);
			dtm.setValueAt(nom,1,i);
			dtm.setValueAt(apell,2,i);
			dtm.setValueAt(edad,3,i);
			dtm.setValueAt(horaaux,4,i);
			auxcon++;
		
	}
	public void setCupos(int cupos)
	{
		int a=32;
		a=a-cupos;
		
		if(a>16)
		{
			citasd[1].setText(String.valueOf(a));
		}
		else if(a<=16&&a>0)
		{
			citasd[1].setText(String.valueOf(a));
			citasd[1].setForeground(new Color(255,127,0));
		}
		else if(a==0)
		{
			citasd[1].setText(String.valueOf(a));
			citasd[1].setForeground(Color.RED);
		}
		
		
	}
}
