package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Partido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
