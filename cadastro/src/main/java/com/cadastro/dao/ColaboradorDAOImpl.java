package com.cadastro.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.cadastro.model.Colaborador;

public class ColaboradorDAOImpl extends AbstractDAO<Integer, Colaborador> implements ColaboradorDAO{

	@Override
	public Colaborador findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveColaborador(Colaborador colaborador) {
		persist(colaborador);
	}

	@Override
	public void deleteColaboradorBySsn(String ssn) {
		Query query = getSession().createSQLQuery("DELETE FROM Colaborador WHERE ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Colaborador> findAllColaboradores() {
		Criteria criteria = createEntityCriteria();
		return (List<Colaborador>) criteria.list();
	}

	@Override
	public Colaborador findColaboradorBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Colaborador) criteria.uniqueResult();
	}

}
