package controller.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.dao.UsuarioDAO;
import model.domain.Usuario;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String listarUsuarios(){
		UsuarioDAO usuarioDao = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDao.lerTodos();
	}
	
}
