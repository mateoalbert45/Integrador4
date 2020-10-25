package demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Plan {
	@Id
	private Long id;
	@Column
	private String descripcion;
}
