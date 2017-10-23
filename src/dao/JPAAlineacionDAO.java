package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import modelo.Alineacion;
import modelo.Color;

public class JPAAlineacionDAO implements AlineacionDAO {

	EntityManagerFactory emf;
	
	public JPAAlineacionDAO(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public Alineacion createAlineacion(String nombre, Color color, int tanteo) throws DAOException {
		EntityManager em = null;
		
		synchronized (emf) {
			em = emf.createEntityManager();
		}
		
		Alineacion ali = new Alineacion();
		ali.setColor(color);
		ali.setNombre(nombre);
		ali.setTanteo(tanteo);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(ali);
		tx.commit();
		em.close();
		
		return ali;
	}

}
