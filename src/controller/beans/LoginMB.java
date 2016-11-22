package controller.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.dao.FilmeDAO;
import model.domain.Filme;

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

	public String autenticar()
	{
		Filme filme = new Filme("Alto da Compadecida", "Um filme muito legal", null, "Comédia");
		FilmeDAO dao = new FilmeDAO();
		dao.salvar(filme);
		
		if(login.equals("gerente"))
			return "cadastroFilmes";
		
		else
			return "catalogo";			
		
	}

	public String acaoLogout()
	{
		return "login";
	}

}
