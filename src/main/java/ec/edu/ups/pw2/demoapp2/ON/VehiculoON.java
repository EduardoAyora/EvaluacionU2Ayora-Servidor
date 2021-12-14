package ec.edu.ups.pw2.demoapp2.ON;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw2.demoapp2.dao.VehiculoDAO;
import ec.edu.ups.pw2.demoapp2.model.Vehiculo;

@Stateless
public class VehiculoON implements VehiculoONRemote {
	@Inject
	private VehiculoDAO vehiculoDAO;
	
	public List<String> buscarPorMarca(String marca) {
		List<Vehiculo> vehiculos = vehiculoDAO.findByMarca(marca);
		return convertirVehiculosEnTexto(vehiculos);
	}
	
	public List<String> buscarPorModelo(String modelo) {
		List<Vehiculo> vehiculos = vehiculoDAO.findByModelo(modelo);
		return convertirVehiculosEnTexto(vehiculos);
	}
	
	public List<String> buscarPorAnio(String anio) {
		List<Vehiculo> vehiculos = vehiculoDAO.findByAnio(anio);
		return convertirVehiculosEnTexto(vehiculos);
	}
	
	private List<String> convertirVehiculosEnTexto(List<Vehiculo> vehiculos) {
		List<String> vehiculosEnTexto = new ArrayList<>();
		for (Vehiculo vehiculo : vehiculos) {
			String vehiculoEnTexto = "Placa: " + vehiculo.getPlaca() + ", Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo()
					 + ", Año: " + vehiculo.getAnio();
			vehiculosEnTexto.add(vehiculoEnTexto);
        }
		System.out.println(vehiculosEnTexto);
		return vehiculosEnTexto;
	}

}
