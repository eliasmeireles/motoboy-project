package br.com.project.motoboy.testes;
import br.com.project.motoboy.data.DataConverte;
import br.com.project.motoboy.model.Cliente;

public class TestaData {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		
		
		System.out.println(DataConverte.dataConverte(cliente.getCadastrado()));
		
	}
}
