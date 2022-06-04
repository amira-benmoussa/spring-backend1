package com.elcom.flux.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Data
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private boolean statut;
    @ManyToOne
    private Operateur operateur;

}
