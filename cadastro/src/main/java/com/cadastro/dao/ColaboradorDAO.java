package com.cadastro.dao;

import java.util.List;

import com.cadastro.model.Colaborador;

public interface ColaboradorDAO {

	Colaborador findById(int id);
	void saveColaborador(Colaborador colaborador);
	void deleteColaboradorBySsn(String ssn);
	List<Colaborador> findAllColaboradores();
	Colaborador findColaboradorBySsn(String ssn);
	
}
