package modelo;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
public class Alquiler {
	
	

	
	protected String tipodeCarro;
	protected Sedes sedeEntrega;
	protected Cliente cliente;
	protected Persona conductorAdicional;
	private Categoria categoria;
	protected Sedes sedeDevolucion;
	protected int dias;
	protected List<String> seguro;
	private AdministradorGeneral admin;
	
	
	
	public Alquiler(String tipodeCarro, Sedes sedeEntrega, Persona conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, List<String> seguro, AdministradorGeneral admin, Categoria categoria) {
		super();
		this.tipodeCarro = tipodeCarro;
		this.sedeEntrega = sedeEntrega;
		this.cliente = cliente;
		this.conductorAdicional = conductorAdicional;
		this.sedeDevolucion = sedeDevolucion;
		this.dias = dias;
		this.seguro = seguro;
		this.admin = admin;
		this.categoria = categoria;
				}
	
	
	
	public String toString() {
		return "Alquiler[" +
		           "tipodeCarro='" + tipodeCarro + '\'' +
		           ", sedeEntrega=" + sedeEntrega +
		           ", cliente=" + cliente +
		           ", conductorAdicional=" + conductorAdicional +
		           ", sedeDevolucion=" + sedeDevolucion +
		           ", dias=" + dias +
		           ", seguro='" + seguro + '\'' +
		           "]";
	}
	
	
	
	public String getTipodeCarro() {
		return tipodeCarro;
	}


	
	public void setTipodeCarro(String tipodeCarro) {
		this.tipodeCarro = tipodeCarro;
	}


	
	public Sedes getSedeEntrega() {
		return sedeEntrega;
	}


	
	public void setSedeEntrega(Sedes sedeEntrega) {
		this.sedeEntrega = sedeEntrega;
	}


	
	public Persona getConductorAdicional() {
		return conductorAdicional;
	}


	
	public void setConductorAdicional(Cliente conductorAdicional) {
		this.conductorAdicional = conductorAdicional;
	}
	

	
	public int cobroSeguros(List<String> segurosElegidos) {
		Map<String, Integer> mapa = admin.getSeguros();
		int precioF = 0;
		for (String seguro : segurosElegidos)
			if (mapa.containsKey(seguro)) {
				precioF += mapa.get(seguro);
		}
		return precioF * dias;
	}
	
	
	
	public int cobroConductorAdicional() {
		int precioF = 0;
		if (conductorAdicional != null) {
			precioF = 100;
		}
		else {
			precioF = 0;
		}
		return precioF;
	}
	
	
	
	public int tarifaTemporada() {
		String temporada = admin.getTemporada();
		int precioF = 0;
		if (temporada.equals("ALTA")) {
			precioF = 50;
					
		}
		else if (temporada.equals("BAJA")) {
			precioF = 0;
	}
		else {
			precioF = 25;
		}
	return precioF;
	}
	
	
	
	public int cobroPorDias() {
		int precioCarro;
		if (tipodeCarro.equals("PEQUENO")) {
            precioCarro = categoria.getTarifaPequeños();
        } else if (tipodeCarro.equals("SUV")) {
        	precioCarro = categoria.getTarifaSUV();
        } else if (tipodeCarro.equals("VAN")) {
        	precioCarro = categoria.getTarifaVans();
        } else if (tipodeCarro.equals("LUJO")) {
            precioCarro = categoria.getTarifaLujo();
        } else {
        	precioCarro = categoria.getTarifaElectricos();
        }
		int precioF = precioCarro * dias;
		return precioF ;
	}
	
	
	
	public int cobroFinal(List<String> seguroElegido) {
		int precioSeguros = cobroSeguros(seguroElegido);
		int precioConductorAdicional = cobroConductorAdicional();
		int precioTemporada = tarifaTemporada();
		int precioPorDias = cobroPorDias();
		return (precioSeguros + precioConductorAdicional + precioTemporada + precioPorDias);
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public Sedes getSedeDevolucion() {
		return sedeDevolucion;
	}



	public void setSedeDevolucion(Sedes sedeDevolucion) {
		this.sedeDevolucion = sedeDevolucion;
	}



	public int getDias() {
		return dias;
	}



	public void setDias(int dias) {
		this.dias = dias;
	}



	public List<String> getSeguro() {
		return seguro;
	}



	public void setSeguro(List<String> seguro) {
		this.seguro = seguro;
	}



	public AdministradorGeneral getAdmin() {
		return admin;
	}



	public void setAdmin(AdministradorGeneral admin) {
		this.admin = admin;
	}



	public void setConductorAdicional(Persona conductorAdicional) {
		this.conductorAdicional = conductorAdicional;
	}
	
	

}
