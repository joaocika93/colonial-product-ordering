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

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public String save(Cliente cliente){
		Cliente cliente0 = new Cliente();
		cliente0.setEnderecos(null);
		cliente0.setId(cliente.getId());
		cliente0.setCpfOuCnpj(cliente.getCpfOuCnpj());
		cliente0.setEmail(cliente.getEmail());
		cliente0.setNome(cliente.getNome());
		cliente0.setTelefones(cliente.getTelefones());
		clienteRepository.save(cliente0);

		Estado estado = new Estado();
		estado.setId(cliente.getEnderecos().get(0).getCidade().getEstado().getId());
		estado.setNome(cliente.getEnderecos().get(0).getCidade().getEstado().getNome());

		Cidade cidade = new Cidade();
		cidade.setId(cliente.getEnderecos().get(0).getCidade().getId());
		cidade.setNome(cliente.getEnderecos().get(0).getCidade().getNome());
		cidade.setEstado(estado);

		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		endereco.setId(cliente.getEnderecos().get(0).getId());
		endereco.setBairro(cliente.getEnderecos().get(0).getBairro());
		endereco.setLogradouro(cliente.getEnderecos().get(0).getLogradouro());
		endereco.setCep(cliente.getEnderecos().get(0).getCep());
		endereco.setComplemento(cliente.getEnderecos().get(0).getComplemento());
		endereco.setNumero(cliente.getEnderecos().get(0).getNumero());
		endereco.setCliente(cliente);

		estadoRepository.save(estado);
		cidadeRepository.save(cidade);
		enderecoRepository.save(endereco);
		clienteRepository.save(cliente);
		return "Salvo com sucesso";
	}

}
