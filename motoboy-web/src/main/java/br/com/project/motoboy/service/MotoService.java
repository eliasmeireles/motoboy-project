package br.com.project.motoboy.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.project.motoboy.dao.MotoDao;
import br.com.project.motoboy.model.Moto;

public class MotoService {
	
	private MotoDao motoDao;

	@Autowired
	public MotoService(MotoDao motoDao) {
		this.motoDao = motoDao;
	}
	
	public void gravar(Moto moto) {
		motoDao.gravar(moto);
	}
	
}
