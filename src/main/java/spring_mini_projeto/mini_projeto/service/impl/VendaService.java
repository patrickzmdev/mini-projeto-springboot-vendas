package spring_mini_projeto.mini_projeto.service.impl;

import java.util.List;

import spring_mini_projeto.mini_projeto.DTO.VendaDTO;

public interface VendaService {
	
	VendaDTO criarVenda(VendaDTO vendaDTO);
	List<VendaDTO> listarVendas();

}
