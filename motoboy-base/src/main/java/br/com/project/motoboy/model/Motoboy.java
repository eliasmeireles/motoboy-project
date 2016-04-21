package br.com.project.motoboy.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "motoboy")
public class Motoboy extends BaseEntity<Motoboy> {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 4)
	private String nome;
	@NotNull
	@Size(min = 4)
	private String sobrenome;

	@NotNull
	@Size(max = 11, min = 11)
	private String cpf;

	@NotNull
	@Size(min = 15)
	private String email;
	@NotNull
	@Size(max = 11)
	private String celular;

	@NotNull
	@Size(min = 8)
	private String senha;
	private Date datacadastro;

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
	public void updateBasedOn(Motoboy target) {

	}
}
