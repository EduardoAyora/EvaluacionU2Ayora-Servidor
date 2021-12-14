package ec.edu.ups.pw2.demoapp2.ON;

import javax.ejb.Local;

@Local
public interface PersonaONLocal {
	public void crear(String cedula, String nombre, String direccion);
}
