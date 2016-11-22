package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.domain.Cliente;
import model.domain.Usuario;
import model.util.JpaDAO;

public class UsuarioDAO extends JpaDAO<Usuario> {
	
	public UsuarioDAO() {
		super();
	}

	public UsuarioDAO(EntityManager manager) {
		super(manager);
	}
	
	public Usuario obterPorLogin(String login)
	{
		Usuario retorno = null;
		
		String comando = "from Usuario u where u.login = :paramLogin";
		TypedQuery<Usuario> query = this.getEntityManager().createQuery(comando, Usuario.class);
		
		query.setParameter("paramLogin", login);
		
		try {
			retorno = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
}
