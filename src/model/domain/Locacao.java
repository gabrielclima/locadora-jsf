package model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "locacoes")
public class Locacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_registro")
	@SequenceGenerator(name = "id_registro", sequenceName = "SEQ_registro",
	                    allocationSize = 1, initialValue=1)
	private int registro;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_FILME")
	private Filme filme;
	
	public Locacao() {
		super();
	}

	public Filme getFilme(Filme filme) {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
