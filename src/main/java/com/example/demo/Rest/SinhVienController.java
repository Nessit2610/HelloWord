package com.example.demo.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/themsv")
	public ResponseEntity<SinhVien> addsv(@RequestBody SinhVien sv) {
	    SinhVien newStudent = service.addSV(sv);
	    return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
	}

	@DeleteMapping("/xoasv/{id}")
	public ResponseEntity<List<SinhVien>> deleteById(@PathVariable("id") int id) {
	    service.deleteByID(id);
	    List<SinhVien> updatedStudents = service.getAllStudents();
	    return ResponseEntity.ok(updatedStudents);
	}
}
