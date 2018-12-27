package controlador;

import javax.swing.JOptionPane;

import interfaz.PanelAgenda;
import interfaz.PanelDatos;
import interfaz.PanelHora;
import mundo.Mundo;

public class Controlador {

	 // Atributos
		private static Mundo mundo;
		private static PanelHora pnlhora;
		private static PanelAgenda pnlagenda;
		private PanelDatos pnldatos;
		private String dat[] = new String[4],datos[][],cabeceradat[];
		private int a,contador,hor,cupos;
	public Controlador()
	{
		mundo = new Mundo();
		contador=0;
		a=2;
	}
	
	public void conectar(PanelHora pnlhora,PanelAgenda pnlagenda,PanelDatos pnldatos)
	{
		this.pnlagenda=pnlagenda;
		this.pnldatos=pnldatos;
		this.pnlhora=pnlhora;
	}
	public void setGenerarDatos()
	{
		mundo.setGenerarDatos();
		dat[0]=mundo.getGeneraNombre();
		dat[1]=mundo.getGenerarApellido();
		dat[2]=mundo.getGenerarEdad();
		dat[3]=mundo.getGenerarCc();
		pnldatos.setGenerarDatos(dat[0], dat[1], dat[2], dat[3]);
	}
	public void setAgendar(String hora)
	{
		try
		{
			String horaaux =hora;
			int a = Integer.parseInt(hora.substring(0, 2));
			int b = Integer.parseInt(hora.substring(3, 5)); 
			int aux = a*100+b; 
			hor=aux;
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Olvido selecionar un horario","Atención", 0);
		}
		
		try
		{
			mundo.setAgendar(dat[3],dat[0],dat[1],dat[2],hor);
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "No ha generado datos","Atención", 0);
		}
		
		cupos=mundo.getCupos();
		pnlagenda.setCupos(cupos);
	}
	
	public static void  setImprimir(String nombre,String apellido,String edad, String id,String hora,int i)
	{
		if(mundo.getVary())
		{
			pnlagenda.setllenartabla(nombre,apellido,edad,id,hora,i);
		}
	}
	public void setCancelar(String canc)
	{
		mundo.setCancelar(canc);
		cupos=mundo.getCupos();
		pnlagenda.setCupos(cupos);
	}
	public void setBuscar(String bus)
	{
		mundo.setBuscar(bus);
		pnlhora.setEditBus(mundo.getNomaux(), mundo.getApellaux(), mundo.getEdadaux(), mundo.getIdaux(), mundo.getHoraaux());
		cupos=mundo.getCupos();
		pnlagenda.setCupos(cupos);
	}
}
