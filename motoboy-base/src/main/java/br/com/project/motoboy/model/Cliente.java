package br.com.project.motoboy.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends BaseEntity<Cliente> {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String celular;
	private String senha;
	private Date cadastrado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getCadastrado() {
		if (cadastrado != null) {
			return cadastrado;
		}
		return this.cadastrado = Calendar.getInstance().getTime();
	}

	public void setCadastrado(Date cadastrado) {
		this.cadastrado = cadastrado;
	}

	@Override
	public void updateBasedOn(Cliente target) {

	}
}
