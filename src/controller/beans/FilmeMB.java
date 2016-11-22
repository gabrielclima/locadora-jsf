package controller.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.dao.FilmeDAO;
import model.dao.LocacaoDAO;
import model.domain.Filme;
import model.domain.Locacao;

@ManagedBean(name = "filmeMB")
public class FilmeMB {
	
	private Filme filme = new Filme();
	private FilmeDAO filmeDao = new FilmeDAO();
	private LocacaoDAO LocacaoDAO = new LocacaoDAO();
	
	@ManagedProperty("#{loginMB.login}")
	private String login;
	
	private List<Filme> filmes = null;
	
	public List<Filme> getFilmes() {
		if (this.filmes == null) 
			this.filmes = this.filmeDao.obterFilmesDisponiveis();
		
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public Filme getFilme() {
		return filme;
	}
	
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	public String abrirCatalogo(){
		return "catalogo";
	}
	
	public String alugarFilme(Filme filme){		
		filme.setDisponivel(false);
		filmeDao.alterar(filme);
		
		return "catalogo.jsf";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
