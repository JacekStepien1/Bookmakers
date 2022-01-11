package buk.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class OddsBuk extends Odds {
	
	private String buk;

	public String getBuk() {
		return buk;
	}

	public void setBuk(String buk) {
		this.buk = buk;
	}
	
	

}
