package br.com.project.motoboy.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "moto")
public class Moto extends BaseEntity<Moto> {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String modelo;
	private String cor;
	private String placa;
	private String motoboy_id;
	private Date datacadastro;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMotoboy_id() {
		return motoboy_id;
	}

	public void setMotoboy_id(String motoboy_id) {
		this.motoboy_id = motoboy_id;
	}

	public Date getDatacadastro() {
		if (datacadastro != null) {
			return datacadastro;
		}
		return this.datacadastro = Calendar.getInstance().getTime();
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	@Override
	public void updateBasedOn(Moto target) {

	}
}
