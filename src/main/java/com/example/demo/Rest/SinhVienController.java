package com.example.demo.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Dao.Service.SinhVienService;
import com.example.demo.Entity.SinhVien;


@RestController
public class SinhVienController {
	
	@Autowired
	private SinhVienService service;
	
	@GetMapping("/danhsach")
	public List<SinhVien> getDS() {
		return service.getAllStudents();
	}
	
	@GetMapping("/themsv")
	public List<SinhVien> addsv(SinhVien sv) {
		service.addSV(sv);
		return service.getAllStudents();
	}
	
	@GetMapping("/xoasv")
	public List<SinhVien> deleteById(int ID){
		service.deleteByID(ID);
		return service.getAllStudents();
	}
}
