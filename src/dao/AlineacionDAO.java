package dao;

import modelo.Alineacion;
import modelo.Color;

public interface AlineacionDAO {

	public Alineacion createAlineacion(String nombre, Color color, int tanteo) throws DAOException;
}
