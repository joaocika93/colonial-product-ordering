package com.example.colonialproductordering.services;

import com.example.colonialproductordering.domains.Cliente;
import com.example.colonialproductordering.domains.ItemPedido;
import com.example.colonialproductordering.domains.Pedido;
import com.example.colonialproductordering.domains.Produto;
import com.example.colonialproductordering.repositories.ItemPedidoRepository;
import com.example.colonialproductordering.repositories.PedidoRepository;
import com.example.colonialproductordering.repositories.ProdutoRepository;
import com.example.colonialproductordering.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ItemPedidoService itemPedidoService;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public Produto buscarProduto(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public String save(Pedido pedido){
//		{
//			"id": 1,
//				"instante": null,
//				"cliente": 1,
//				"enderecoDeEntrega": null,
//				"itens": []
//		}
		Cliente cliente = clienteService.buscarUsuario(pedido.getCliente().getGoogleId());
		pedido.setCliente(cliente);
		pedido.setEnderecoDeEntrega(cliente.getEnderecos().get(0));
		List<ItemPedido> itemPedidos = itemPedidoService.findByUsuario(pedido.getCliente().getGoogleId());
		pedido.setItens(itemPedidos);


		pedidoRepository.save(pedido);
		return "Salvo com Sucesso";
	}
}
