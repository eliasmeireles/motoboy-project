package br.com.project.motoboy.model;

import javax.persistence.Embeddable;

@Embeddable
public class MinhaMoto {

	private Motoboy motoboy_id;

	public Motoboy getMotoboy_id() {
		return motoboy_id;
	}

	public void setMotoboy_id(Motoboy motoboy_id) {
		this.motoboy_id = motoboy_id;
	}
}
