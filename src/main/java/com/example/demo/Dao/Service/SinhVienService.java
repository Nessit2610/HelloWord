package com.example.demo.Dao.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.SinhVienDao;
import com.example.demo.Entity.SinhVien;

@Service
public class SinhVienService {
	@Autowired
    private SinhVienDao sinhviendao;

    public List<SinhVien> getAllStudents() {
        return sinhviendao.findAll();
    }
    public void addSV(SinhVien sv) {
		sinhviendao.saveAndFlush(sv);
	}
    public void deleteByID(int id) {
    	sinhviendao.deleteById(id);
    }
}
