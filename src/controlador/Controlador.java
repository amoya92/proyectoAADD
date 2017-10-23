package controlador;

import java.util.Date;
import java.util.List;

import dao.AlineacionDAO;
import dao.DAOException;
import dao.DAOFactoria;
import dao.PartidoDAO;
import dao.TemporadaDAO;
import dao.UsuarioDAO;
import modelo.Alineacion;
import modelo.Color;
import modelo.Partido;
import modelo.Temporada;
import modelo.Usuario;

public class Controlador {
	private static Controlador unicaInstancia;


	private Controlador(){
		try {
			DAOFactoria.setDAOFActoria(DAOFactoria.JPA);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public static Controlador getUnicaInstancia(){
		if(unicaInstancia == null){
			new Controlador();
		}
		return unicaInstancia;
	}

	public Usuario registrarUsuario(String usuario, String clave, String mail, String movil){
		try{
			UsuarioDAO usuDAO = DAOFactoria.getUnicaInstancia().getUsuarioDAO();
			return usuDAO.createUsuario(usuario, clave, mail, movil);
		} catch(DAOException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public boolean login(String usuario, String clave){
		Usuario user = obtenerUsuario(usuario);
		return user.getClave().equals(clave);
	}
	
	public Usuario obtenerUsuario(String usuario){
		try{
			UsuarioDAO usuDAO = DAOFactoria.getUnicaInstancia().getUsuarioDAO();
			Usuario user = usuDAO.findUsuarioByUsuario(usuario);
			return user;
		} catch(DAOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario actualizarUsuario(String usuario, String clave, String mail, String movil){
		UsuarioDAO usuDAO = DAOFactoria.getUnicaInstancia().getUsuarioDAO();
		try {
			return usuDAO.updateUsuario(usuario, clave, mail, movil);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Temporada registroTemporada(String nombre, String lugar, int minimo){
		TemporadaDAO tempDAO = DAOFactoria.getUnicaInstancia().getTemporadaDAO();
		try {
			return tempDAO.createTemporada(nombre, lugar, minimo);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Temporada anadirUsuarioTemporada(String temporada, String usuario){
		Usuario usu = obtenerUsuario(usuario);
		TemporadaDAO tempDAO = DAOFactoria.getUnicaInstancia().getTemporadaDAO();
		try {
			return tempDAO.addUsuarioTemporada(temporada, usu);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Temporada quitarUsuarioTemporada(String temporada, String usuario){
		Usuario usu = obtenerUsuario(usuario);
		TemporadaDAO tempDAO = DAOFactoria.getUnicaInstancia().getTemporadaDAO();
		try {
			return tempDAO.deleteUsuarioTemporada(temporada, usu);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Temporada obtenerTemporada(String temporada){
		try{
			TemporadaDAO tempDAO = DAOFactoria.getUnicaInstancia().getTemporadaDAO();
			return tempDAO.findTemporada(temporada);
		} catch(DAOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Partido registrarPartido(Date fecha){
		PartidoDAO parDAO = DAOFactoria.getUnicaInstancia().getPartidoDAO();
		
		try {
			return parDAO.createPartido(fecha);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Partido confirmarAsistencia(Long id, String usuario){
		Usuario usu = obtenerUsuario(usuario);
		PartidoDAO parDAO = DAOFactoria.getUnicaInstancia().getPartidoDAO();
		try {
			return parDAO.addUsuarioPartido(id, usu);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Alineacion registrarAlineacion(String nombre, Color color, int tanteo){
		AlineacionDAO aliDAO = DAOFactoria.getUnicaInstancia().getAlineacionDAO();
		try {
			return aliDAO.createAlineacion(nombre, color, tanteo);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public List<Partido> obtenerPartidoEntreFechas(Date f1, Date f2){
		PartidoDAO parDAO = DAOFactoria.getUnicaInstancia().getPartidoDAO();
		try {
			return parDAO.findPartidoByFecha(f1, f2);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
