package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SQ_TB_CLIENTE", allocationSize=1)

public class Cliente implements Serializable {

	@Id
	@Column(name="CD_CLIENTE")
	@GeneratedValue(generator="cliente", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="NM_NOME", nullable=false, length=150 )
	private String nome;
	
	@Column(name="DT_ANIVERSARIO", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataDeAniversario;
	
	@Column(name="NR_CARTAO_FIDELIDADE", nullable=false)
	private int codiogoCartaoFidelidade;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DS_SEXO")
	private Sexo sexo;
	
	@Column(name="FL_FOTO")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING) 
	@Column(name="DS_STATUS", nullable=false)
	private Status status;

	public Cliente(String nome, Calendar dataDeAniversario, int codiogoCartaoFidelidade, Sexo sexo, byte[] foto,
			Status status) {
		super();
		this.nome = nome;
		this.dataDeAniversario = dataDeAniversario;
		this.codiogoCartaoFidelidade = codiogoCartaoFidelidade;
		this.sexo = sexo;
		this.foto = foto;
		this.status = status;
	}

	public Cliente() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataDeAniversario() {
		return dataDeAniversario;
	}

	public void setDataDeAniversario(Calendar dataDeAniversario) {
		this.dataDeAniversario = dataDeAniversario;
	}

	public int getCodiogoCartaoFidelidade() {
		return codiogoCartaoFidelidade;
	}

	public void setCodiogoCartaoFidelidade(int codiogoCartaoFidelidade) {
		this.codiogoCartaoFidelidade = codiogoCartaoFidelidade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	


}
