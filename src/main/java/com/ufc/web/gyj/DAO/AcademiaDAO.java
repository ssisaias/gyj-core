package com.ufc.web.gyj.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ufc.web.gyj.model.Academia;

@Transactional
public interface AcademiaDAO extends JpaRepository<Academia, Long>{
	
}
