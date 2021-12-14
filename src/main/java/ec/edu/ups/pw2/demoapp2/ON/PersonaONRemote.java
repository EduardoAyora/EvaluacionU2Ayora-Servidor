package ec.edu.ups.pw2.demoapp2.ON;

import javax.ejb.Remote;

import ec.edu.ups.pw2.demoapp2.model.Persona;

@Remote
public interface PersonaONRemote {
	public void crear(String cedula, String nombre, String direccion);
	public Persona buscar(String cedula);
}
