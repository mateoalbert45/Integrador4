package demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Viaje {
	@Id
	private Long id;
	@Column
	private String nombre;
	@Column
	private List<String> destinos;
	@Column
	private String fechaInicio;
	@Column
	private String fechaFin;
	@Column
	private String descripcion;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "plan")
	private List <ViajePlan> planes;
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
	private Usuario usuario;
	
	
	public Viaje(Long id, String nombre, List<String> destinos, String fechaInicio, String fechaFin, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.destinos = destinos;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
	}
	
	
}
