package com.elcom.flux.entities;




import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class Operateur extends Employee  implements Serializable {
	
	@ManyToOne
	private Responsable responsable;
	
	

	

	

}
