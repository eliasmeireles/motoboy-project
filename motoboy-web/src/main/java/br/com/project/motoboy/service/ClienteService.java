package br.com.project.motoboy.service;

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

	public Cliente localiza(Cliente cliente) {
		return clienteDao.localiza(cliente);
	}

	public Cliente localizaPorEmail(String email) {
		return clienteDao.localizaPorEmail(email);
	}

	public Cliente localizaPorCpf(Cliente cliente) {
		return clienteDao.localizaPorCpf(cliente);
	}

}