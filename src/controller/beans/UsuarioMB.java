package controller.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.utils.JSFUtil;
import model.dao.UsuarioDAO;
import model.domain.Usuario;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable{

	private static final long serialVersionUID = 1L;
		
	private UsuarioDAO usuarioDao = new UsuarioDAO();
	private List<Usuario> usuarios = null;
	private Usuario usuario = new Usuario();
	
	public List<Usuario> getUsuarios(){
		if (usuarios == null)
			usuarios = usuarioDao.lerTodos();
		
		return usuarios;		
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public String listarUsuarios(){
		return "cadastroUsuarios";
	}
	
	public String abrirInclusao(){
		this.setUsuario(new Usuario());
		
		return "editarUsuario";
	}
	
	public String alterarUsuario(Usuario usuario){
		this.setUsuario(usuario);
		
		return "editarUsuario";
	}
	
	public String salvarUsuario(){
		Usuario usuario = usuarioDao.obterPorLogin(this.usuario.getLogin());
		
		if (usuario != null){
			JSFUtil.retornarMensagemErro("Já existe um usuário com esse login.", null, null);
			return null;
		} else {
			usuarioDao.salvar(this.usuario);
			this.usuarios = null;
			this.setUsuario(new Usuario());
			return "cadastroUsuarios";
		}
	}
	
	public String cancelar(){
		this.setUsuario(new Usuario());
		
		return "cadastroUsuarios";
	}
	
	public String excluirUsuario(Usuario usuario){
		usuarioDao.excluir(usuario);
		
		this.setUsuario(new Usuario());
		
		this.usuarios = null;
		
		return "cadastroUsuarios";
	}
	
}
