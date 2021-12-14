package ec.edu.ups.pw2.demoapp2.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pw2.demoapp2.model.Persona;

@Stateless
public class PersonaDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public Persona read(int id) {
		Persona persona = em.find(Persona.class, id);
		return persona;
	}
	
	public Persona find(String cedula) {
		Persona persona = em.find(Persona.class, cedula);
		return persona;
	}
	
	public void delete(int id) {
		Persona persona = em.find(Persona.class, id);
		em.remove(persona);
	}
}
