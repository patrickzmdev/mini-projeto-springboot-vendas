package spring_mini_projeto.mini_projeto.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import spring_mini_projeto.mini_projeto.DTO.VendaDTO;
import spring_mini_projeto.mini_projeto.entity.ProdutoEntity;
import spring_mini_projeto.mini_projeto.entity.VendaEntity;
import spring_mini_projeto.mini_projeto.repository.ProdutoRepository;
import spring_mini_projeto.mini_projeto.repository.VendaRepository;

@Service
public class VendaServiceImpl implements VendaService {
	
	    @Autowired
	    private VendaRepository vendaRepository;
	    
	    @Autowired
	    private ProdutoRepository produtoRepository;

	@Override
	public VendaDTO criarVenda(VendaDTO vendaDTO) {
		VendaEntity venda = new VendaEntity();
		venda.setDataVenda(LocalDateTime.now());
		
		List<ProdutoEntity> produtos = vendaDTO.getProdutos()
				.stream().map(produtoDTO -> produtoRepository.
						findById(produtoDTO.getId()).
						orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"))).
				collect(Collectors.toList());
		
		venda.setProdutos(produtos);
		VendaEntity vendaSalva = vendaRepository.save(venda);
		return new VendaDTO(vendaSalva);
	}

	@Override
	public List<VendaDTO> listarVendas() {
		 List<VendaEntity> vendas = vendaRepository.findAll();
	        return vendas.stream().map(VendaDTO::new).collect(Collectors.toList());
	}

}
