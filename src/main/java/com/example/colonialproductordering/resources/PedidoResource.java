package com.example.colonialproductordering.resources;

import com.example.colonialproductordering.domains.Pedido;
import com.example.colonialproductordering.repositories.PedidoRepository;
import com.example.colonialproductordering.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Pedido obj = pedidoService.buscar(id);

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/get")
	public List<Pedido> findAll(){return pedidoRepository.findAll();}

	@PostMapping("/add")
	public String save(@RequestBody Pedido pedido){
		return pedidoService.save(pedido);
	}

}
