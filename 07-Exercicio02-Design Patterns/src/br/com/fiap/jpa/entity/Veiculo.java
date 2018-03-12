package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_Veiculo")
@SequenceGenerator(name="veiculo", sequenceName="SQ_TB_Veiculo", allocationSize=1)
public class Veiculo implements Serializable{

@Id
@Column(name="CD_VEICULO",nullable=false)
private int codigo;

@Column(name="DS_PLACA", length=9)
private String placa;

@Column(name="DS_COR", length=20)
private String cor;

@Column(name="NR_ANO")
private int ano;

public Veiculo(String placa, String cor, int ano) {
	super();
	this.placa = placa;
	this.cor = cor;
	this.ano = ano;
}

public Veiculo() {
	super();

}

public int getCodigo() {
	return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public String getPlaca() {
	return placa;
}

public void setPlaca(String placa) {
	this.placa = placa;
}

public String getCor() {
	return cor;
}

public void setCor(String cor) {
	this.cor = cor;
}

public int getAno() {
	return ano;
}

public void setAno(int ano) {
	this.ano = ano;
}
	



}
