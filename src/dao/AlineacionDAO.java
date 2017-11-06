package dao;

import modelo.Alineacion;
import modelo.Color;
import modelo.Usuario;

public interface AlineacionDAO {

	public Alineacion createAlineacion(String nombre, Color color, int tanteo, Long partido) throws DAOException;

	public Alineacion addUsuario(String alineacion, String usuario) throws DAOException;
}
