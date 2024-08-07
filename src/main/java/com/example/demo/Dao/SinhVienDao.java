package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.SinhVien;

@Repository
@RepositoryRestResource(path="dssv")
public interface SinhVienDao extends JpaRepository<SinhVien, Integer>{

}
