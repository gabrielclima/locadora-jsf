package model.dao;

import javax.persistence.EntityManager;

import model.domain.Filme;
import model.util.JpaDAO;

public class FilmeDAO extends JpaDAO<Filme> {
	
	public FilmeDAO() {
		super();
	}

	public FilmeDAO(EntityManager manager) {
		super(manager);
	}
}
