package spring_mini_projeto.mini_projeto.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_mini_projeto.mini_projeto.DTO.ProdutoDTO;
import spring_mini_projeto.mini_projeto.DTO.VendaDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "venda")
public class VendaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private LocalDateTime dataVenda;
    
    @ManyToMany
    @JoinTable(
        name = "venda_produto",
        joinColumns = @JoinColumn(name = "venda_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<ProdutoEntity> produtos = new ArrayList<>();
    
    public VendaEntity(VendaDTO dto) {
    	this.id = dto.getId();
    	this.dataVenda = dto.getDataVenda();
    	this.produtos = dto.getProdutos().stream()
    			.map(produtoDTO -> new ProdutoEntity(produtoDTO)).collect(Collectors.toList());
    }
    

}
