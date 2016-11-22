package model.dao;

import javax.persistence.EntityManager;

import model.domain.Locacao;
import model.util.JpaDAO;

public class LocacaoDAO extends JpaDAO<Locacao> {
	
	public LocacaoDAO() {
		super();
	}

	public LocacaoDAO(EntityManager manager) {
		super(manager);
	}
}
