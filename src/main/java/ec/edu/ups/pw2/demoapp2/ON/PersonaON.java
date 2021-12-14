package ec.edu.ups.pw2.demoapp2.ON;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw2.demoapp2.dao.PersonaDAO;
import ec.edu.ups.pw2.demoapp2.model.Persona;


@Stateless
public class PersonaON implements PersonaONLocal, PersonaONRemote {
	@Inject
	private PersonaDAO personaDAO;
	
	public void crear(String cedula, String nombre, String direccion) {
		try {
			Persona persona = new Persona();
			persona.setCedula(cedula);
			persona.setNombre(nombre);
			persona.setDireccion(direccion);
			personaDAO.insert(persona);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
	}
	
	public Persona buscar(String cedula) {
		Persona persona;
		try {
			persona = personaDAO.find(cedula);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
		return persona;
	}
}
