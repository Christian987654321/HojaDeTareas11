package clases;

import java.time.LocalDate;

public class Cliente implements Comparable<Cliente> {
	
	private String dni;
	private String nombre;
	private int edad;
	private LocalDate fechaInicio;
	private double saldo;
	
	
	public Cliente(String dni, String nombre, int edad, LocalDate fechaInicio, double saldo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaInicio = fechaInicio;
		this.saldo = saldo;
	}

	
	@Override
	public String toString() {
		return "Cliente DNI: " + dni + ", nombre: " + nombre + ", edad: " + edad + ", fechaInicio: " + fechaInicio + ", saldo: " + saldo;
	}


	@Override
	public int compareTo(Cliente o) {
		int valor=this.fechaInicio.compareTo(o.getFechaInicio());
		return valor;
	}



	public final String getNombre() {
		return nombre;
	}



	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public final int getEdad() {
		return edad;
	}



	public final void setEdad(int edad) {
		this.edad = edad;
	}



	public final LocalDate getFechaInicio() {
		return fechaInicio;
	}



	public final void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public final double getSaldo() {
		return saldo;
	}



	public final void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public final String getDni() {
		return dni;
	}
	
}