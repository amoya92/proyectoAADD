package modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Alineacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;
	
	private int tanteo;
	
	@Enumerated(EnumType.STRING)
	private Color color;
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTanteo() {
		return tanteo;
	}

	public void setTanteo(int tanteo) {
		this.tanteo = tanteo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
