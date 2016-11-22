package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.domain.Gerente;
import model.util.JpaDAO;


public class GerenteDAO extends JpaDAO<Gerente> {
	
	public GerenteDAO() {
		super();
	}

	public GerenteDAO(EntityManager manager) {
		super(manager);
	}
		
	public Gerente obterPorLogin(String login)
	{
		Gerente retorno = null;
		
		String comando = "from Gerente c where c.login = :paramLogin";
		TypedQuery<Gerente> query = this.getEntityManager().createQuery(comando, Gerente.class);
		
		query.setParameter("paramLogin", login);
		
		try {
			retorno = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

}
