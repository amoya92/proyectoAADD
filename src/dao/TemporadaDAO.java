package dao;

import java.util.List;

import modelo.Temporada;
import modelo.Usuario;

public interface TemporadaDAO {
	
	public Temporada createTemporada(String nombre, String lugar, int minimo) throws DAOException;
	
	public Temporada findTemporada(String nombre) throws DAOException;

	public Temporada addUsuarioTemporada(String temporada, Usuario usuario) throws DAOException;

	public Temporada deleteUsuarioTemporada(String temporada, Usuario usuario) throws DAOException;

}
