package br.com.project.motoboy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.project.motoboy.dao.MotoboyDao;
import br.com.project.motoboy.model.Motoboy;

public class MotoboyService {

	private MotoboyDao motoboyDao;

	@Autowired
	public MotoboyService(MotoboyDao motoboyDao) {
		this.motoboyDao = motoboyDao;
	}

	public void gravar(Motoboy motoboy) {
		motoboyDao.gravar(motoboy);
	}

	public Motoboy localiza(Motoboy motoboy) {
		return motoboyDao.localiza(motoboy);
	}

	public List<Motoboy> localizaTodos() {
		return motoboyDao.localizaTodos();
	}
	public boolean motoboyEmail(String email) {
		return motoboyDao.motoboyEmail(email).size() > 0;
	}

	public boolean motoboyCpf(String cpf) {
		return motoboyDao.motoboyCpf(cpf).size() > 0;
	}
}
