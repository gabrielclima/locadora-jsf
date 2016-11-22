package controller.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.dao.FilmeDAO;
import model.dao.LocacaoDAO;
import model.domain.Filme;

@ManagedBean(name = "cadastroFilmesMB")
public class CadastroFilmesMB {

	private Filme filme = new Filme();
	private FilmeDAO filmeDao = new FilmeDAO();
	private LocacaoDAO locacaoDAO = new LocacaoDAO();
	
	@ManagedProperty("#{loginMB.login}")
	private String login;
	
	private List<Filme> filmes = null;
	
	public List<Filme> getFilmes() {
		if (this.filmes == null) 
			this.filmes = this.filmeDao.lerTodos();
		
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
	
	public String alugarFilme(){		
		return "alugarFilme";
	}

	public String excluirFilme(){
		return "excluirFilme";
	}
	
	public String editarFilme(){
		return "editarFilme";
	}
	
	public String incluirFilme(){
		return "incluirFilme";
	}
	
}
