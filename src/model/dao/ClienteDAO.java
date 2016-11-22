package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.domain.Cliente;
import model.util.JpaDAO;

public class ClienteDAO extends JpaDAO<Cliente> {
	
	public ClienteDAO() {
		super();
	}

	public ClienteDAO(EntityManager manager) {
		super(manager);
	}
	
	public Cliente obterPorLogin(String login)
	{
		Cliente retorno = null;
		
		String comando = "from Cliente c where c.login = :paramLogin";
		TypedQuery<Cliente> query = this.getEntityManager().createQuery(comando, Cliente.class);
		
		query.setParameter("paramLogin", login);
		
		try {
			retorno = query.getSingleResult();
		} catch (Exception e) {
		//	retorno = null;
		}
		
		return retorno;
	}
	
}
