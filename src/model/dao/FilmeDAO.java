package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.domain.Filme;
import model.util.JpaDAO;

public class FilmeDAO extends JpaDAO<Filme> {
	
	public FilmeDAO() {
		super();
	}

	public FilmeDAO(EntityManager manager) {
		super(manager);
	}
	
	public List<Filme> obterFilmesDisponiveis(){
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("select f from Filme f where disponivel = true");
		List<Filme> filmes = query.getResultList();
		return filmes;
	}
	
}
