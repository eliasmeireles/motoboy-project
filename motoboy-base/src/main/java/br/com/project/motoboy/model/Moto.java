package br.com.project.motoboy.model;

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
	private String cliente_id;

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

	public String getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(String cliente_id) {
		this.cliente_id = cliente_id;
	}

	@Override
	public void updateBasedOn(Moto target) {

	}

	@Override
	public String toString() {
		return "Moto [nome=" + nome + ", modelo=" + modelo + ", cor=" + cor + ", placa=" + placa + ", cliente_id="
				+ cliente_id + "]";
	}

}
