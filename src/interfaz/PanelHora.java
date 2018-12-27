package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

public class PanelHora extends JPanel implements ActionListener{

	 private Controlador ctrl;
	 
	 private JButton btn[] = new JButton[3];
	 private JComboBox combo;
	 private JTextField nomcom;
	 private JTextField idcom;
	 private JLabel lbl[] = new JLabel[11];
	 private JLabel datf[] = new JLabel[3];
	 private String hora="",nomcan="",idcan="";
	public PanelHora(Controlador ctrl)
	{
		//Borde del panel
		setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker()));
		//Color de fondo 
		setBackground(new Color(198,226,255));
		//Disposicion 
		setLayout( null );
		//Integar controlador
		this.ctrl=ctrl;
		
		//Texto Datos
		 lbl[0] = new JLabel("Hora:  ");
		 Font auxFont=lbl[0].getFont();
	     lbl[0].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));
	     lbl[0].setForeground(Color.BLUE.darker().darker().darker().darker());
	     lbl[0].setBounds(10, 10, 300, 25);
	     add(lbl[0]);
	     
		//Texto C.c
		 lbl[1] = new JLabel("Numero de documento C.c: ");
		 Font auxFont1=lbl[1].getFont();
		 lbl[1].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 12));
		 lbl[1].setForeground(Color.BLUE.darker().darker().darker());
		 lbl[1].setBounds(10, 160, 300, 15);
	     add(lbl[1]);
	     
	   //Texto Nombre
	     lbl[2] = new JLabel("Nombre: ");
		 Font auxFont2=lbl[2].getFont();
		 lbl[2].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 12));
		 lbl[2].setForeground(Color.BLUE.darker().darker().darker());
		 lbl[2].setBounds(10, 195, 300, 15);
	     add(lbl[2]);
	     
	   //Texto Apellido
	     lbl[3] = new JLabel("Apellido: ");
		 Font auxFont3=lbl[3].getFont();
		 lbl[3].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 12));
		 lbl[3].setForeground(Color.BLUE.darker().darker().darker());
		 lbl[3].setBounds(230, 160, 300, 15);
	     add(lbl[3]);
	     
	     //Texto Edad
	     lbl[4] = new JLabel("Edad: ");
		 Font auxFont4=lbl[4].getFont();
		 lbl[4].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 12));
		 lbl[4].setForeground(Color.BLUE.darker().darker().darker());
		 lbl[4].setBounds(230, 195, 300, 15);
	     add(lbl[4]);
	     
	   //LBL Respuestas
	   //Texto C.C r
	     lbl[5] = new JLabel("------");
		 Font auxFont5=lbl[5].getFont();
		 lbl[5].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 12));
		 lbl[5].setForeground(Color.BLACK);
		 lbl[5].setBounds(170, 160, 300, 15);
	     add(lbl[5]);
	     
	     //Texto Nombre r
	     lbl[6] = new JLabel("------");
		 Font auxFont6=lbl[6].getFont();
		 lbl[6].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 12));
		 lbl[6].setForeground(Color.BLACK);
		 lbl[6].setBounds(65, 195, 300, 15);
	     add(lbl[6]);
	     
	     //Texto Apellido r
	     lbl[7] = new JLabel("------");
		 Font auxFont7=lbl[7].getFont();
		 lbl[7].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 12));
		 lbl[7].setForeground(Color.BLACK);
		 lbl[7].setBounds(285, 160, 300, 15);
	     add(lbl[7]);
	     
	     //Texto C.C
	     lbl[8] = new JLabel("--");
		 Font auxFont8=lbl[8].getFont();
		 lbl[8].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 12));
		 lbl[8].setForeground(Color.BLACK);
		 lbl[8].setBounds(285, 195, 300, 15);
	     add(lbl[8]);
	     
	     //Texto hora cita
	     lbl[9] = new JLabel("Hora cita: ");
		 Font auxFont9=lbl[9].getFont();
		 lbl[9].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		 lbl[9].setForeground(Color.BLUE.darker().darker().darker());
		 lbl[9].setBounds(100, 230, 300, 15);
	     add(lbl[9]);
	     
	   //Texto hora cita rr
	     lbl[10] = new JLabel("-----");
		 Font auxFont10=lbl[10].getFont();
		 lbl[10].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		 lbl[10].setForeground(Color.BLACK);
		 lbl[10].setBounds(180, 230, 300, 15);
	     add(lbl[10]);
	     
	     //Boton Agendar
	     btn[0] = new JButton("Agendar");
	     btn[0].addActionListener(this);
		 add(btn[0]);
		 btn[0].setBounds(50, 110, 85, 30);
		//Boton Cancelar
	     btn[1] = new JButton("Cancelar");
	     btn[1].addActionListener(this);
		 add(btn[1]);
		 btn[1].setBounds(150, 110, 85, 30);
		//Boton Buscar
	     btn[2] = new JButton("Buscar");
	     btn[2].addActionListener(this);
		 add(btn[2]);
		 btn[2].setBounds(250, 110, 85, 30);
		
		
		 //Combox hora
		 combo = new JComboBox();
		 combo.setEditable(false);
		 combo.addItem("--Vacio--");
			for(int i = 8;i<19;i++)
			{
				for(int j=0;j<50;j=j+20)
				{
					if(i<10)
					{
						if(j!=0)
						{
						combo.addItem("0"+i+":"+j);
						}
						else if(j==0)
						{
							combo.addItem("0"+i+":"+j+"0");
						}
					}
					else if(i>9)
					{
						if(j!=0)
						{
						combo.addItem(i+":"+j);
						}
						else if(j==0)
						{
							combo.addItem(i+":"+j+"0");
						}
					}
					if(i==18&&j==20)
					{
						j=50;
					}
				     
				}
			}
			
			
			combo.setBounds(50, 60, 85, 30);
			add(combo);
			
			//Combox nombres
			 nomcom = new  JTextField("--Vacio--");
			 nomcom.setBounds(150, 60, 85, 30);
			 add(nomcom);
			 
			//Combox id
			 idcom = new JTextField("--Vacio--");
			 idcom.setBounds(250, 60, 85, 30);
			 add(idcom);
			 
			 datf[0]=new JLabel("Hora: ");
			 Font auxFont11=datf[0].getFont();
			 datf[0].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
			 datf[0].setForeground(Color.BLUE.darker().darker().darker());
			 datf[0].setBounds(50, 40, 300, 15);
		     add(datf[0]);
		     
		     datf[1]=new JLabel("Nombre: ");
			 Font auxFont12=datf[1].getFont();
			 datf[1].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
			 datf[1].setForeground(Color.BLUE.darker().darker().darker());
			 datf[1].setBounds(150, 40, 300, 15);
		     add(datf[1]);
		     
		     datf[2]=new JLabel("C.c: ");
			 Font auxFont13=datf[2].getFont();
			 datf[2].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
			 datf[2].setForeground(Color.BLUE.darker().darker().darker());
			 datf[2].setBounds(250, 40, 300, 15);
		     add(datf[2]);
	}
	public void actionPerformed(ActionEvent e) {
		Object btnpuch = e.getSource();
		
		if(btnpuch == btn[0])
		{
			//System.out.println("Accion");
			
			hora=(String)combo.getSelectedItem();
			
			if(hora.equals("--Vacio--"))
			{
				JOptionPane.showMessageDialog(null, "Olvido selecionar un horario","Atención", 0);
			}
			else
			{
				ctrl.setAgendar(hora);

			}
			
		}
		else if(btnpuch == btn[1])
		{
			//.out.println("Tiempo");
			String hor;
			hor="";
		
			/*JOptionPane.showMessageDialog(null, "Olvido selecionar un horario","Atención", 0);
				hor=null;*/
			
			hora=(String)combo.getSelectedItem();
			nomcan=(String)nomcom.getText();
			idcan=(String)idcom.getText();
			if(hora!="--Vacio--")
			{
				int a = Integer.parseInt(hora.substring(0, 2));
				int b = Integer.parseInt(hora.substring(3, 5)); 
				int aux = a*100+b; 
				hor=String.valueOf(aux);
			}
			
			System.out.println(hor+"  1  "+nomcan+"  2  "+idcan);
			
			if(hora.equals("--Vacio--")&&nomcan.equals("--Vacio--"))
			{
				//System.out.println("Cancelar por id");
				ctrl.setCancelar(idcan);
			}
			else if(hora.equals("--Vacio--")&&idcan.equals("--Vacio--"))
			{
				//System.out.println("Cancelar por nombre");
				ctrl.setCancelar(nomcan);
			}
			else if(nomcan.equals("--Vacio--")&&idcan.equals("--Vacio--"))
			{
				//System.out.println("Cancelar por hora");
				ctrl.setCancelar(hor);
			}
			else if((nomcan!="--Vacio--"&&idcan!="--Vacio--")||(hora!="--Vacio--"&&idcan!="--Vacio--")||(hora!="--Vacio--"&&nomcan!="--Vacio--"))
			{
				JOptionPane.showMessageDialog(null, "Solo elija un modo de cancelar","Atención", 0);
				nomcom.setText("--Vacio--");
				idcom.setText("--Vacio--");
				combo.setSelectedItem("--Vacio--");
			}
			//System.out.println(hora+" "+nomcan+" "+idcan);
		}
		else if(btnpuch == btn[2])
		{
			String hor;
			hor="";
			hora=(String)combo.getSelectedItem();
			nomcan=(String)nomcom.getText();
			idcan=(String)idcom.getText();
			if(hora!="--Vacio--")
			{
				int a = Integer.parseInt(hora.substring(0, 2));
				int b = Integer.parseInt(hora.substring(3, 5)); 
				int aux = a*100+b; 
				hor=String.valueOf(aux);
			}
			
			System.out.println(hor+"  1  "+nomcan+"  2  "+idcan);
			
			if(hora.equals("--Vacio--")&&nomcan.equals("--Vacio--"))
			{
				System.out.println("Buscar por id");
				//ctrl.setCancelar(idcan);
				ctrl.setBuscar(idcan);
			}
			else if(hora.equals("--Vacio--")&&idcan.equals("--Vacio--"))
			{
				System.out.println("Buscar por nombre");
				//ctrl.setCancelar(nomcan);
				ctrl.setBuscar(nomcan);
			}
			else if(nomcan.equals("--Vacio--")&&idcan.equals("--Vacio--"))
			{
				System.out.println("Buscar por hora");
				//ctrl.setCancelar(hor);
				ctrl.setBuscar(hor);
			}
			else if((nomcan!="--Vacio--"&&idcan!="--Vacio--")||(hora!="--Vacio--"&&idcan!="--Vacio--")||(hora!="--Vacio--"&&nomcan!="--Vacio--"))
			{
				JOptionPane.showMessageDialog(null, "Solo elija un modo de Buscar","Atención", 0);
				nomcom.setText("--Vacio--");
				idcom.setText("--Vacio--");
				combo.setSelectedItem("--Vacio--");
			}
			//ctrl.setBuscar();
			//hora=(String)combo.getSelectedItem();
			
		}
		
	}
	
	public void setEditBus(String nom,String apell,String edad,String cc,String hora)
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
		
		lbl[5].setText(cc);
		lbl[6].setText(nom);
		lbl[7].setText(apell);
		lbl[8].setText(edad);
		lbl[10].setText(horaaux);
	}
	
	
}
