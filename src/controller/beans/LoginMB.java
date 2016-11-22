package controller.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	
	private UsuarioDAO usuarioDao;
	
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

	@PostConstruct
	public void preencherBanco(){
		
		FilmeDAO dao = new FilmeDAO();
		List<Filme> filmes = dao.lerTodos();
		
		if (filmes.isEmpty()){
			Filme filme = new Filme("Alto da Compadecida", "Um filme muito legal", null, "Comédia");
			dao.salvar(filme);
			filme = new Filme("Terror na Casa Branca", "Uma loucura", null, "Terror");
			dao.salvar(filme);
			filme = new Filme("Sniper Americano", "Um cara que dá tiros", null, "Ação");
			dao.salvar(filme);
			filme = new Filme("A feiticeira", "Um filme de magia", null, "Palhaçada");
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
		
		Usuario usuario = usuarioDao.obterPorLogin(this.getLogin());
		
		if (usuario == null){
			JSFUtil.retornarMensagemErro("Esse usuário não existe.", null, null);
			paginaRetorno = "login";
		}
		else
			paginaRetorno = "catalogo";
		
		return paginaRetorno;
	}

	public String acaoLogout()
	{
		return "login";
	}

}
