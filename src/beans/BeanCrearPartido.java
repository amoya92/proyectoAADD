package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.Date;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import modelo.Temporada;
import controlador.Controlador;

@ManagedBean(name = "beanCrearPartido")
@SessionScoped
public class BeanCrearPartido {

	private String temporadaId;

	private Date fecha;

	private Collection<Temporada> temporadas;

	

	public String getTemporadaId() {
		return temporadaId;
	}

	public void setTemporadaId(String temporadaId) {
		this.temporadaId = temporadaId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setTemporadas(Collection<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public Collection<Temporada> getTemporadas() {
		this.temporadas = new LinkedList<Temporada>();
		this.temporadas.addAll(Controlador.getUnicaInstancia()
				.listarTemporadas());
		return this.temporadas;
	}

	public String submit() {
		Controlador.getUnicaInstancia().registrarPartido(fecha, temporadaId);
		return "partidolista";
	}

}
