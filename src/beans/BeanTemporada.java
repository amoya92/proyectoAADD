package beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controlador.Controlador;
import modelo.Temporada;
import modelo.Usuario;

@ManagedBean(name="beanTemporada")
@SessionScoped
public class BeanTemporada {

	private String nombre;
	private String lugar;
	private int minimo;
	private List<Usuario> usuarios;
	private Map<String, Boolean> checked;

	public BeanTemporada() {
		this.usuarios = new LinkedList<Usuario>();
		this.checked = new HashMap<String, Boolean>();
	}

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

	public List<Usuario> getUsuarios() {
		return Controlador.getUnicaInstancia().listarUsuarios();
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String submit() {
		if (Controlador.getUnicaInstancia().obtenerTemporada(nombre) == null){
			FacesContext.getCurrentInstance().addMessage("nombre", new FacesMessage("Nombre ya utilizado."));
			return "faceletError";
		}
		else {
			Temporada temporada = Controlador.getUnicaInstancia().registroTemporada(nombre, lugar, minimo);
			for (Usuario usuario : usuarios) {
				if (checked.get(usuario.getUsuario()))
					Controlador.getUnicaInstancia().anadirUsuarioTemporada(nombre, usuario.getUsuario());
			}
			checked.clear();
			return "temporadaLista";
		}
	}

	public Map<String, Boolean> getChecked() {
		return checked;
	}

	public void setChecked(Map<String, Boolean> checked) {
		this.checked = checked;
	}
	
	
}
