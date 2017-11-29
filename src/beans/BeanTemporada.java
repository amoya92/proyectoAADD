package beans;

import controlador.Controlador;

@ManagedBean(name="beanTemporada")
@SessionScoped
public class BeanTemporada {

	private String nombre;
	private String lugar;
	private int minimo;
	private Collection<Usuario> usuarios;
	
	public BeanTemporada(){
		this.usuarios = new LinkedList<Usuario>();
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
		usuarios = new LinkedList<Usuario>();
		Collection<Usuario> todosUsuarios = Controlador.getUnicaInstancia().obtenerUsuario(usuario);
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
