package spring_mini_projeto.mini_projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_mini_projeto.mini_projeto.DTO.ProdutoDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "produto")
public class ProdutoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer qntEstoque;
	
	public ProdutoEntity(ProdutoDTO dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.descricao = dto.getDescricao();
		this.preco = dto.getPreco();
		this.qntEstoque = dto.getQntEstoque();
	}
	
	

}
