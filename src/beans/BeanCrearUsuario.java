package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controlador.Controlador;

@ManagedBean(name = "beanCrearUsuario")
@SessionScoped
public class BeanCrearUsuario {

	private String usuario;
	private String clave1;
	private String clave2;
	private String mail;
	private String movil;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave1() {
		return clave1;
	}

	public void setClave1(String clave1) {
		this.clave1 = clave1;
	}

	public String getClave2() {
		return clave2;
	}

	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String submit() {
		if (clave1.equals(clave2)) {
			if (Controlador.getUnicaInstancia().obtenerUsuario(usuario) != null) {
				return "usuarioerror";
			} else {
				Controlador.getUnicaInstancia().registrarUsuario(usuario,
						clave1, mail, movil);
				return "index";
			}
		} else {
			return "usuarioerror";
		}
	}
}
