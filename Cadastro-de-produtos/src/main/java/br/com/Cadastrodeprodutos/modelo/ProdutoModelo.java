package br.com.Cadastrodeprodutos.modelo;


import br.com.Cadastrodeprodutos.dto.AtualizarDto;
import br.com.Cadastrodeprodutos.dto.ProdutoModeloDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Produtos")
@Table(name  = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModelo {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	
	private String marca;
	
	public ProdutoModelo(@Valid ProdutoModeloDto prod) {
		this.codigo = prod.codigo();
		this.nome = prod.nome();
		this.marca = prod.marca();
	}

	public void updata(AtualizarDto atualize) {
		if(atualize.nome()!= null) {
			this.nome = atualize.nome();
		}
		if(atualize.marca()!= null) {
			this.marca = atualize.marca();
		}
 }

	
	
	
}
