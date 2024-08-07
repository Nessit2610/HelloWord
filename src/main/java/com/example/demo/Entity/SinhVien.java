package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sinhvien")
public class SinhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int ID;
	
	@Column(name = "hodem", length = 50)
	private String HoDem;
	
	@Column(name = "ten", length = 50)
	private String Ten;
	
	@Column(name = "email", length = 100)
	private String Email;

	public SinhVien() {
		super();
	}

	public SinhVien(String hoDem, String ten, String email) {
		super();
		HoDem = hoDem;
		Ten = ten;
		Email = email;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getHoDem() {
		return HoDem;
	}

	public void setHoDem(String hoDem) {
		HoDem = hoDem;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
}
