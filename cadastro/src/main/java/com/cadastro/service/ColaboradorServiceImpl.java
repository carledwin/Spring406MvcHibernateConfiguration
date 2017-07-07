package com.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cadastro.dao.ColaboradorDAO;
import com.cadastro.model.Colaborador;

public class ColaboradorServiceImpl implements ColaboradorService {

	@Autowired
	private ColaboradorDAO dao;
	
	@Override
	public Colaborador findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveColaborador(Colaborador colaborador) {
		dao.saveColaborador(colaborador);
	}

	@Override
	public void updateColaborador(Colaborador colaborador) {
		Colaborador entity = dao.findById(colaborador.getId());
		
		if(entity != null){
			entity.setName(colaborador.getName());
			entity.setJoiningDate(colaborador.getJoiningDate());
            entity.setSalary(colaborador.getSalary());
            entity.setSsn(colaborador.getSsn());
		}
	}

	@Override
	public void deleteColaboradorBySsn(String ssn) {
		dao.deleteColaboradorBySsn(ssn);
		
	}

	@Override
	public List<Colaborador> findAllColaboradores() {
		return dao.findAllColaboradores();
	}

	@Override
	public Colaborador findColaboradorBySsn(String ssn) {
		return dao.findColaboradorBySsn(ssn);
	}

	@Override
	public boolean isColaboradorSsnUnique(Integer id, String ssn) {
		Colaborador colaborador = findColaboradorBySsn(ssn);
		return (colaborador == null || (id != null) && (colaborador.getId() == id));
	}


}
