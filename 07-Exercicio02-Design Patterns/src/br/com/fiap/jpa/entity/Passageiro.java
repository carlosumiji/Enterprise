package br.com.fiap.jpa.entity;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PASSAGEIRO")
@SequenceGenerator(name="passageiro", sequenceName="SQ_TB_PASSGEIRO", allocationSize=1)
public class Passageiro {

@Id
@GeneratedValue(generator="passageiro",strategy=GenerationType.SEQUENCE)
@Column(name="CD_PASSAGEIRO")
private int codigo; 

@Column(name="NM_PASSAGEIRO")
private String nome;

@Column(name="Dt_NASCIMENTO")
@Temporal(TemporalType.DATE)
private Calendar nascimento;

@Column(name="DS_GENERO")
private Genero genero;



public Passageiro() {
	super();
	// TODO Auto-generated constructor stub
}


public Passageiro(int codigo, String nome, Calendar dataNascimento, Genero genero) {
	super();
	this.codigo = codigo;
	this.nome = nome;
	this.nascimento = dataNascimento;
	this.genero = genero;
}


public int getCodigo() {
	return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Calendar getDataNascimento() {
	return nascimento;
}

public void setDataNascimento(Calendar dataNascimento) {
	this.nascimento = dataNascimento;
}

public Genero getGenero() {
	return genero;
}

public void setGenero(Genero genero) {
	this.genero = genero;
}



}
