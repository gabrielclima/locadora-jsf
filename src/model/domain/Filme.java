package model.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_FILME")
	@SequenceGenerator(name = "ID_FILME", sequenceName = "SEQ_ID_FILME",
	                    allocationSize = 1, initialValue=1)
	private int registro;
	private String nomeFilme;
	private String descricao;

	private Date dataLancamento;
	private String categoria;
	private boolean disponivel;
	
	@OneToMany(mappedBy="filme", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private List<Locacao> locacao;
	
	public Filme(String nomeFilme, String descricao, Date dataLancamento, String categoria) {
		super();
		this.nomeFilme = nomeFilme;
		this.descricao = descricao;
		this.disponivel = true; 
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
	}
	
	public int getRegistro() {
		return registro;
	}
	
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Filme(){
		super();
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getDataFormatada() {
		if (this.dataLancamento == null)
			return "";
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatador.format(this.dataLancamento);
		return dataFormatada;
	}
}
