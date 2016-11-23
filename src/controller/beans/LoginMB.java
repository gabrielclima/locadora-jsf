package controller.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controller.utils.JSFUtil;
import model.dao.FilmeDAO;
import model.dao.UsuarioDAO;
import model.domain.Filme;
import model.domain.Usuario;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String senha;
	private String login;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public Usuario getUsuario(){
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		return usuario;
	}

	@PostConstruct
	public void preencherBanco(){
		
		FilmeDAO dao = new FilmeDAO();
		List<Filme> filmes = dao.lerTodos();
		
		if (filmes.isEmpty()){
			Filme filme = new Filme("Alto da Compadecida", "Um filme muito legal", null, "Comedia");
			dao.salvar(filme);
			filme = new Filme("Terror na Casa Branca", "Uma loucura", null, "Terror");
			dao.salvar(filme);
			filme = new Filme("Sniper Americano", "Um cara que da tiros", null, "Acao");
			dao.salvar(filme);
			filme = new Filme("A feiticeira", "Um filme de magia", null, "Palhacada");
			dao.salvar(filme);
		}
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDao.lerTodos();
		
		if (usuarios.isEmpty()){
			Usuario usuario = new Usuario("admin", "123", "Administrador", "165.190.247-08", null, true);
			usuarioDao.salvar(usuario);
			usuario = new Usuario("cliente", "123", "Josimar Silva", "165.190.248-08", null, false);
			usuarioDao.salvar(usuario);			
		}
		
	}
	
	public String autenticar(String login)
	{
		String paginaRetorno;
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.obterPorLogin(this.getLogin());
		
		if (usuario == null){
			JSFUtil.retornarMensagemErro("Esse usuario nao existe.", null, null);
			paginaRetorno = "login";
		}
		else {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
			paginaRetorno = "catalogo";
		}
		
		return paginaRetorno;
	}

	public String acaoLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login";
	}

}
