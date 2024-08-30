package spring_mini_projeto.mini_projeto.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring_mini_projeto.mini_projeto.entity.ProdutoEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer qntEstoque;
	
	
	public ProdutoDTO(ProdutoEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
		this.preco = entity.getPreco();
		this.qntEstoque = entity.getQntEstoque();
	}

}
