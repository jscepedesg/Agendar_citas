package mundo;

import java.util.Iterator;

import javax.swing.JOptionPane;

import controlador.Controlador;
import estructuras.Queue;
import estructuras.StackLis;
import interfaz.PanelAgenda;

public class Mundo {

	private String nom[] = new String[15];
	private String ape[] = new String[15];
	private String nombre,apellido,edad,cc;
	private String datos[][],cabecera[];
	private int contador,hora;
	private String auxCc,auxNom,auxApell,auxEdad,auxHora,hora1;
	private static Queue<Paciente> cola = new Queue<Paciente>();
	private static StackLis<Paciente> pila1 = new StackLis<Paciente>();
	private static StackLis<Paciente> pilaaux = new StackLis<Paciente>();
	private static StackLis<Paciente> pilaaux2 = new StackLis<Paciente>();
	private static StackLis<Paciente> pilaaux3 = new StackLis<Paciente>();
	private static StackLis<Paciente> pilaaux4 = new StackLis<Paciente>();
	private Paciente a,aux,b,c,d,e;
	private boolean very;
	private int vec[] = new int[32],con,cupos;
	private String nomaux,apellaux,edadaux,idaux,horaaux;
	

	public Mundo()
	{
		//Nombres
		nom[0]="Sebastian";nom[1]="Carlos";nom[2]="Santiago";
		nom[3]="Jairo";nom[4]="Carolina";nom[5]="Catalina";
		nom[6]="Laura";nom[7]="Tatiana";nom[8]="Pedro";
		nom[9]="Cristian";nom[10]="Maria";nom[11]="Juan";
		nom[12]="Andrea";nom[13]="Angie";nom[14]="Jose";
		
		//Apellidos
		ape[0]="Cespedes";ape[1]="Rodríguez";ape[2]="Caicedo";
		ape[3]="Sanchez";ape[4]="Lopez";ape[5]="Gómez";
		ape[6]="Martínez";ape[7]="Perez";ape[8]="Garcia";
		ape[9]="Moreno";ape[10]="Rojas";ape[11]="Torres";
		ape[12]="Ramirez";ape[13]="Jiménez";ape[14]="Díaz";
		contador=0;
		very =true;
		con=0;
		
		
		
	}
	
	public void setGenerarDatos()
	{
		int nomb = (int) (Math.random() * 14) + 0;
		nombre=nom[nomb];
		int apell = (int) (Math.random() * 14) + 0;
		apellido=ape[apell];
		edad= String.valueOf((int) (Math.random() * 58) + 18);
		cc=String.valueOf((int) (Math.random() * 900000) + 100000);
		this.hora=hora;
	}
	public void  setAgendar(String cc,String nom,String apell,String edad,int hora)
	{	
		boolean verifi=true;
		very=true;
		
		Iterator pila6 = pila1.iterator();
		while(pila6.hasNext())
		{
			d=(Paciente) pila6.next();
			if(d.getMin()==hora)
			{
				very=false;
				JOptionPane.showMessageDialog(null, "La hora no esta disponible","Atención", 0);
				break;
			}
		}

		
		if(very)
		{
			if(pila1.size()==0)
			{
				pila1.push(new Paciente(nom,apell,Integer.parseInt(edad),Integer.parseInt(cc),hora));
			}
			else if(pila1.size()>0)
			{
				Iterator pila = pila1.iterator();
				while(pila.hasNext())
				{
					a=(Paciente) pila.next();
					System.out.println(hora+"asd");
					if(hora<a.getMin())
					{
						pilaaux.push(pila1.pop());
						verifi=false;
					}
					else if(hora>a.getMin())
					{
						pila1.push(new Paciente(nom,apell,Integer.parseInt(edad),Integer.parseInt(cc),hora));
						System.out.println(pila1.size());
						break;
						
					}
					 if(pila1.size()==0)
					{
						pila1.push(new Paciente(nom,apell,Integer.parseInt(edad),Integer.parseInt(cc),hora));
						
					}
				}
				
				if(verifi==false)
				{
					while(pilaaux.iterator().hasNext())
					{
						pila1.push(pilaaux.pop());
					}
				}
				
			}
			//vec[con]=hora;
			con++;
			//Imprimir en tabla
			Iterator pila2 = pila1.iterator();
			while(pila2.hasNext())
			{	b=(Paciente) pila2.next();
				//Por verificar
				pilaaux3.push(pila1.pop());
			}
			int i=0;
			Iterator pila3 = pilaaux3.iterator();
			while(pila3.hasNext())
			{	b=(Paciente) pila3.next();
				Controlador.setImprimir(b.getNombre(), b.getApellido(), String.valueOf(b.getEdad()), String.valueOf(b.getId()), String.valueOf(b.getMin()),i);
				i++;
			}
			Iterator pila8 = pilaaux3.iterator();
			while(pila8.hasNext())
			{	b=(Paciente) pila8.next();
				//Por verificar
				pila1.push(pilaaux3.pop());
			}

			
			System.out.println(pila1.size() + " aqui");
			
		}
		cupos=pila1.size();
	}
	public void setCancelar(String canc)
	{
		boolean nose =true;
		if(pila1.size()==0)
		{
			JOptionPane.showMessageDialog(null, "No hay citas a cancelar","Atención", 0);
		}
		else
		{
			very=true;
			int con=1,conaux=0;
			Iterator pila4 = pila1.iterator();
			while(pila4.hasNext())
			{
				c=(Paciente) pila4.next();
				String id2=String.valueOf(c.getId());
				String hor=String.valueOf(c.getMin());
				if(id2.equals(canc)||c.getNombre().equalsIgnoreCase(canc)||hor.equals(canc))
				{
					conaux=con;
					for(int i=0;i<(conaux-1);i++)
					{
						pilaaux2.push(pila1.pop());
					}
					pila1.pop();
					for(int i=0;i<(conaux-1);i++)
					{
						pila1.push(pilaaux2.pop());
					}
					nose=false;//
				}
				con++;
				//Imprimir en tabla
					Iterator pila2 = pila1.iterator();
					while(pila2.hasNext())
					{	b=(Paciente) pila2.next();
						//Por verificar
						pilaaux4.push(pila1.pop());
					}
					int i=0;
					Iterator pila3 = pilaaux4.iterator();
					while(pila3.hasNext())
					{	b=(Paciente) pila3.next();
						Controlador.setImprimir(b.getNombre(), b.getApellido(), String.valueOf(b.getEdad()), String.valueOf(b.getId()), String.valueOf(b.getMin()),i);
						i++;
					}
					Iterator pila8 = pilaaux4.iterator();
					while(pila8.hasNext())
					{	b=(Paciente) pila8.next();
						//Por verificar
						pila1.push(pilaaux4.pop());
					}
				
				
				Controlador.setImprimir(null, null, null, null, "",i);
			}
			
			System.out.print(pila1.size()+"Elimino");
			
		}
		cupos=pila1.size();
		if(nose==true)
		{
			JOptionPane.showMessageDialog(null, "No se encontro el dato a eliminar","Atención", 0);
		}
	}
	
	public void setBuscar(String bus)
	{
		boolean nose =true;
		if(pila1.size()==0)
		{
			JOptionPane.showMessageDialog(null, "No hay citas a buscar","Atención", 0);
		}
		else
		{
			Iterator pila9 = pila1.iterator();
			while(pila9.hasNext())
			{
				e=(Paciente) pila9.next();
				String id2=String.valueOf(e.getId());
				String hor=String.valueOf(e.getMin());
				if(id2.equals(bus)||e.getNombre().equalsIgnoreCase(bus)||hor.equals(bus))
				{
					nomaux=e.getNombre();
					apellaux=e.getApellido();
					edadaux=String.valueOf(e.getEdad());
					idaux=String.valueOf(e.getId());
					horaaux=String.valueOf(e.getMin());
					nose=false;//
				}
				
			}
			
		}
		cupos=pila1.size();
		if(nose==true)
		{
			JOptionPane.showMessageDialog(null, "No se encontro el dato a buscar","Atención", 0);
		}
	}
	public String getGeneraNombre()
	{
		return nombre;
	}
	public String getGenerarApellido()
	{
		return apellido;
	}
	public String getGenerarEdad()
	{
		return edad;
	}
	public String getGenerarCc()
	{
		return cc;
	}
	public String[][] getDatos()
	{
		return datos;
	}
	public String[] getCabecera()
	{
		return cabecera;
	}
	
	public boolean getVary()
	{
		return very;
	}
	
	public String getHora()
	{
		return hora1;
	}
	public int getCupos() {
		return cupos;
	}
	public String getNomaux() {
		return nomaux;
	}


	public String getApellaux() {
		return apellaux;
	}


	public String getEdadaux() {
		return edadaux;
	}


	public String getIdaux() {
		return idaux;
	}


	public String getHoraaux() {
		return horaaux;
	}
}
