package spring_mini_projeto.mini_projeto.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring_mini_projeto.mini_projeto.entity.VendaEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO {
	
	private Long id;
    private LocalDateTime dataVenda;
    private List<ProdutoDTO> produtos;

    public VendaDTO(VendaEntity venda) {
        this.id = venda.getId();
        this.dataVenda = venda.getDataVenda();
        this.produtos = venda.getProdutos().stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

}
