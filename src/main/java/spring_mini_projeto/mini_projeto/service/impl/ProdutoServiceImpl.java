package spring_mini_projeto.mini_projeto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import spring_mini_projeto.mini_projeto.DTO.ProdutoDTO;
import spring_mini_projeto.mini_projeto.entity.ProdutoEntity;
import spring_mini_projeto.mini_projeto.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	private ProdutoRepository produtoRepository;

	

	@Override
	public List<ProdutoDTO> getTodosProdutos() {
		List<ProdutoEntity> produtos = produtoRepository.findAll();
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}

	@Override
	public ProdutoDTO create(ProdutoDTO dto) {
		ProdutoEntity novoProduto = new ProdutoEntity(dto);
		
		ProdutoEntity produtoSalvo = produtoRepository.save(novoProduto);
		return new ProdutoDTO(produtoSalvo);
	}

	@Override
	public ProdutoDTO buscarPeloId(Long id) {
		return produtoRepository.findById(id).map(ProdutoDTO::new).orElse(null);
	}

	@Override
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		
		Optional<ProdutoEntity> produtoOptional = produtoRepository.findById(id);
		
		if(produtoOptional.isPresent()) {
			ProdutoEntity produto = produtoOptional.get();
			produto.setNome(dto.getNome());
			produto.setDescricao(dto.getDescricao());
			produto.setPreco(dto.getPreco());
			produto.setQntEstoque(dto.getQntEstoque());
			ProdutoEntity produtoAtualizado = produtoRepository.save(produto);
			return new ProdutoDTO(produtoAtualizado);
		} else {
			throw new EntityNotFoundException("Produto não encotrado");
		}
	}

	@Override
	public void deletar(Long id) {
		
		var entidade = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto nao encontrado"));
		produtoRepository.delete(entidade);
		
	}

}
