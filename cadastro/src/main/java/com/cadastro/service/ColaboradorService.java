package com.cadastro.service;

import java.util.List;

import com.cadastro.model.Colaborador;

public interface ColaboradorService {

	Colaborador findById(int id);
	void saveColaborador(Colaborador colaborador);
	void updateColaborador(Colaborador colaborador);
	void deleteColaboradorBySsn(String ssn);
	List<Colaborador> findAllColaboradores();
	Colaborador findColaboradorBySsn(String ssn);
	boolean isColaboradorSsnUnique(Integer id, String ssn);
}
