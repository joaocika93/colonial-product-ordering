package com.example.colonialproductordering.services;

import java.util.Optional;

import com.example.colonialproductordering.domains.Pedido;
import com.example.colonialproductordering.repositories.PedidoRepository;
import com.example.colonialproductordering.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public String save(Pedido pedido){
		repo.save(pedido);
		return "Salvo com Sucesso";
	}
}
