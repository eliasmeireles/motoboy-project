package br.com.project.motoboy.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motoboy")
public class Motoboy extends BaseEntity<Motoboy> {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String telefone;
	private String senha;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public void updateBasedOn(Motoboy target) {

	}

	@Override
	public String toString() {
		return "Motoboy [nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", email=" + email
				+ ", telefone=" + telefone + ", senha=" + senha + ", id=" + id + "]";
	}

}
