package beans;

import java.util.Collection;
import java.util.LinkedList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import controlador.Controlador;
import modelo.Temporada;

@ManagedBean(name = "BeanListarTemporadas")
@SessionScoped
public class BeanListarTemporadas {

	private Collection<Temporada> temporadas;

	public Collection<Temporada> getTemporadas() {
		temporadas = new LinkedList<Temporada>();
		temporadas.addAll(Controlador.getUnicaInstancia().listarTemporadas());
		return temporadas;
	}

	public void setTemporadas(Collection<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public void removeTemporada(Temporada temporada) {
		// Controlador.getUnicaInstancia().eliminarTemporada(temporada.getNombre());
	}

	public String viewTemporada(Temporada temporada) {

		return "vertemporada";
	}

	public String editTemporada(Temporada temporada) {

		return "editartemporada";
	}

}
