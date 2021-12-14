package ec.edu.ups.pw2.demoapp2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw2.demoapp2.model.Vehiculo;

@Stateless
public class VehiculoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo vehiculo) {
		em.persist(vehiculo);
	}
	
	public void update(Vehiculo vehiculo) {
		em.merge(vehiculo);
	}
	
	public Vehiculo read(String placa) {
		Vehiculo vehiculo = em.find(Vehiculo.class, placa);
		return vehiculo;
	}
	
	public List<Vehiculo> findByMarca(String marca) {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT veh FROM Vehiculo veh WHERE veh.marca = ?1";
		Query query = em.createQuery(jpql, Vehiculo.class);
		query.setParameter(1, marca);
		listado = query.getResultList();
		return listado;
	}
	
	public List<Vehiculo> findByModelo(String modelo) {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT veh FROM Vehiculo veh WHERE veh.modelo = ?1";
		Query query = em.createQuery(jpql, Vehiculo.class);
		query.setParameter(1, modelo);
		listado = query.getResultList();
		return listado;
	}
	
	public List<Vehiculo> findByAnio(String anio) {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT veh FROM Vehiculo veh WHERE veh.anio = ?1";
		Query query = em.createQuery(jpql, Vehiculo.class);
		query.setParameter(1, anio);
		listado = query.getResultList();
		return listado;
	}
	
	public void delete(int id) {
		Vehiculo vehiculo = em.find(Vehiculo.class, id);
		em.remove(vehiculo);
	}
}
