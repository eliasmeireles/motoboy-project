package br.com.project.motoboy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.project.motoboy.dao.ClienteDao;
import br.com.project.motoboy.model.Cliente;

public class ClienteService {

	private ClienteDao clienteDao;

	
	@Autowired
	public ClienteService(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public void gravar(Cliente cliente) {
		clienteDao.gravar(cliente);
	}
	
	public List<Cliente> localiza(Cliente cliente) {
		return clienteDao.localiza(cliente);
	}
	
	public boolean localizaEmail(String email) {
		return clienteDao.localizaEmail(email).size() > 0;

	}

	public boolean validaCpf(Cliente cliente) {
		return clienteDao.validaCpf(cliente).size() > 0;
	}
}
