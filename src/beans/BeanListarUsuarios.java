package beans;

import controlador.Controlador;

@ManagedBean(name = "beanListarUsuarios")
@SessionScoped
public class BeanListarUsuarios {
	private Collection<Usuario> usuarios;

	public Collection<Usuario> getUsuarios() {
		usuarios = new LinkedList<Usuario>();
		List<Usuario> todosUsuarios = Controlador.getUnicaInstancia().listarUsuarios();
		for (Usuario usuario : todosUsuarios) {
			usuarios.add(usuario);
		}
		return usuarios;
	}

	public BeanListarUsuarios() {
		usuarios = new LinkedList<Usuario>();
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
