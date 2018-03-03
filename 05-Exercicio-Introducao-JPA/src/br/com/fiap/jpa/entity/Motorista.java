package br.com.fiap.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.crypto.Data;

@Entity
@Table(name="TB_Motorista")
@SequenceGenerator(name="motorista", sequenceName="SQ_TB_Motorista", allocationSize=1)
public class Motorista implements Serializable{

@Id
@Column(name="NR_CARTEIRA")
private int numeroCarteira;

@Column(name="NM_MOTORISTA")
private String motorista;

@Column(name="DT_NASCIMENTO")
private Data nascimento;

@Column(name="FL_CARTEIRA")
private byte[] carteira;

@Column(name="DS_GENERO")
private String genero;
}
