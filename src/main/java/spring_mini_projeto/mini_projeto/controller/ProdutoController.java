package spring_mini_projeto.mini_projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_mini_projeto.mini_projeto.DTO.ProdutoDTO;
import spring_mini_projeto.mini_projeto.service.impl.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<ProdutoDTO> getTodosProdutos(){
		return produtoService.getTodosProdutos();
	}
	
	@GetMapping("/{id}")
	public ProdutoDTO buscarPeloId(@PathVariable Long id) {
		return produtoService.buscarPeloId(id);
	}
	
	@PostMapping
	public ProdutoDTO create(@RequestBody ProdutoDTO produto) {
		return produtoService.create(produto);
	}
	
	@PutMapping("/{id}")
	public ProdutoDTO update(@PathVariable Long id, @RequestBody ProdutoDTO produtoAtualizado){
		return produtoService.update(id, produtoAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		produtoService.deletar(id);
	}

}
