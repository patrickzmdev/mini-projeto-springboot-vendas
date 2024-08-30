package spring_mini_projeto.mini_projeto.service.impl;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import spring_mini_projeto.mini_projeto.DTO.ProdutoDTO;

public interface ProdutoService {
	
	public List<ProdutoDTO> getTodosProdutos();
	
	public ProdutoDTO create(ProdutoDTO dto);
	
	public ProdutoDTO buscarPeloId(Long id);
	
	public ProdutoDTO update(Long id, ProdutoDTO dto);
	
	public void deletar(Long id);

}
