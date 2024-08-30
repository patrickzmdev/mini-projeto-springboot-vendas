package spring_mini_projeto.mini_projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_mini_projeto.mini_projeto.DTO.VendaDTO;
import spring_mini_projeto.mini_projeto.service.impl.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@PostMapping
    public VendaDTO criarVenda(@RequestBody VendaDTO vendaDTO) {
        return vendaService.criarVenda(vendaDTO);
    }
    
    @GetMapping
    public List<VendaDTO> listarVendas() {
        return vendaService.listarVendas();
    }

}
