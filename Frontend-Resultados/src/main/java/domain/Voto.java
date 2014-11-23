package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;



@Entity
@Access(AccessType.PROPERTY)
public class Voto extends DomainEntity implements Serializable {
	
// Constructors -----------------------------------------------------------

	public Voto() {
		super();
	}

// Attributes -------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	Opcion opcion;
	Integer num_votos;
	Date createdDate;
	Votacion votacion;




	@Valid
	@NotNull
	@OneToOne
	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public Integer getNum_votos() {
		return num_votos;
	}

	public void setNum_votos(Integer num_votos) {
		this.num_votos = num_votos;
	}

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Votacion getVotacion() {
		return votacion;
	}

	public void setVotacion(Votacion votacion) {
		this.votacion = votacion;
	}

	@JsonSerialize(using=DateSerializer.class)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
