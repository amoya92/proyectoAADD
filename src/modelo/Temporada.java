package modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Temporada implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;
	
	private String lugar;
	
	private int minimo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
