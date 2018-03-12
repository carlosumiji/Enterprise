package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;

@Entity
@Table(name="TB_Motorista")
@SequenceGenerator(name="motorista", sequenceName="SQ_TB_Motorista", allocationSize=1)
public class Motorista implements Serializable{

@Id
@Column(name="NR_CARTEIRA")
private int numero;

@Column(name="NM_MOTORISTA")
private String motorista;

@Column(name="DT_NASCIMENTO")
@Temporal(TemporalType.DATE)
private Calendar nascimento;

@Column(name="FL_CARTEIRA")
private byte[] carteira;

@Column(name="DS_GENERO")
private Genero genero;



public Motorista(int numeroCarteira, String motorista, Calendar nascimento, byte[] carteira, Genero masculino) {
	super();
	this.numero = numeroCarteira;
	this.motorista = motorista;
	this.nascimento = nascimento;
	this.carteira = carteira;
	this.genero = masculino;
}

public Motorista() {
	super();
}

public int getNumeroCarteira() {
	return numero;
}

public void setNumeroCarteira(int numeroCarteira) {
	this.numero = numeroCarteira;
}

public String getMotorista() {
	return motorista;
}

public void setMotorista(String motorista) {
	this.motorista = motorista;
}

public Calendar getNascimento() {
	return nascimento;
}

public void setNascimento(Calendar nascimento) {
	this.nascimento = nascimento;
}

public byte[] getCarteira() {
	return carteira;
}

public void setCarteira(byte[] carteira) {
	this.carteira = carteira;
}

public Genero getGenero() {
	return genero;
}

public void setGenero(Genero genero) {
	this.genero = genero;
}



}
