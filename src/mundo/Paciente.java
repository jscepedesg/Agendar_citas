package mundo;

public class Paciente {

	private String nombre;
	private String apellido;
	private int edad;
	private int id;
	private int hora;
	
	public Paciente(String nombre,String apellido,int edad,int id,int hora)
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.id=id;
		this.hora=hora;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public int getId() {
		return id;
	}

	public int getMin() {
		return hora;
	}

}
