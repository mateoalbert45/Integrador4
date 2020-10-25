package demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Vuelo {
	@Id
	private Long id;
	@Column
	private String compania;
	@Column
	private String fechaSalida;
	//fijate que tiene que ser formato fecha y hora
	@Column
	private String fechaLlegada;
	//fijate que tiene que ser formato fecha y hora
	@Column
	private String aeropuertoSalida;
	@Column
	private String aeropuertoLlegada;
	@Column
	private Long codigoReserva;
	@Column
	private Long tiempoEntreEscalas;
	@Column
	private String informacionAeronave;
	
	
	public Vuelo(Long id, String compania, String fechaSalida, String fechaLlegada, String aeropuertoSalida,
			String aeropuertoLlegada, Long codigoReserva, Long tiempoEntreEscalas, String informacionAeronave) {
		super();
		this.id = id;
		this.compania = compania;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.codigoReserva = codigoReserva;
		this.tiempoEntreEscalas = tiempoEntreEscalas;
		this.informacionAeronave = informacionAeronave;
	}
	
	
	
	
}
