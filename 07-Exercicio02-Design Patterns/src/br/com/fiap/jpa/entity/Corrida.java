package br.com.fiap.jpa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="TB_CORRIDA")
@SequenceGenerator(name="CD_CORRIDA",sequenceName="SQ_TB_CORRIDA")
public class Corrida {

@Id
@Column(name="CD_CODIGO")
private int codigo;

@Column(name="DS_ORIGEM")
private String origem;

@Column(name="DS_DESTINO")
private String destino;

@Column(name="DT_CORRIDA")
//@Temporal(TemporalType.DATE)
private Date corrida;

@Column(name="VL_CORRIDA")
private float valor;
	
}
