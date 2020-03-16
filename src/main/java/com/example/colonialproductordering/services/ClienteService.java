package com.example.colonialproductordering.services;

import com.example.colonialproductordering.domains.Cidade;
import com.example.colonialproductordering.domains.Cliente;
import com.example.colonialproductordering.domains.Endereco;
import com.example.colonialproductordering.domains.Estado;
import com.example.colonialproductordering.repositories.CidadeRepository;
import com.example.colonialproductordering.repositories.ClienteRepository;
import com.example.colonialproductordering.repositories.EnderecoRepository;
import com.example.colonialproductordering.repositories.EstadoRepository;
import com.example.colonialproductordering.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public Cliente buscar(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente buscarUsuario(String nome){
		return clienteRepository.findByUsuario(nome);
	}

	public String save(Cliente cliente){
		Cliente cliente0 = new Cliente();
		cliente0.setEnderecos(null);
		cliente0.setId(cliente.getId());
		cliente0.setEmail(cliente.getEmail());
		cliente0.setNome(cliente.getNome());
		cliente0.setImagem(cliente.getImagem());
		cliente0.setGoogleId(cliente.getGoogleId());
		cliente0.setTelefones(cliente.getTelefones());
		clienteRepository.save(cliente0);

		Endereco endereco = enderecoService.buscar(cliente.getEnderecos().get(0).getId());
		endereco.setCliente(cliente0);

		enderecoRepository.save(endereco);
		List<Endereco> enderecoList = new ArrayList<>();
		enderecoList.add(endereco);
		cliente0.setEnderecos(enderecoList);

		clienteRepository.save(cliente0);
		return "Salvo com sucesso";
	}

}
