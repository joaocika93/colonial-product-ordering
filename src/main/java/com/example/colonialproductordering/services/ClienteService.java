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
	private  EstadoService estadoService;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CidadeService cidadeService;

	public Cliente buscar(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente buscarUsuario(String googleId){
		return clienteRepository.findByUsuario(googleId);
	}

	public String save(Cliente cliente) {
		if (cidadeRepository.findByCidade(cliente.getEnderecos().get(0).getCidade().getNome()) == null) {
			return "Cidade não encontrada";
		} else {
			clienteRepository.save(cliente);
			List<Cidade> cidadeList = cidadeRepository.findByCidade(cliente.getEnderecos().get(0).getCidade().getNome());

			Estado estado;
			Cidade thisCidade = new Cidade();
			for (Cidade cidade : cidadeList) {
				estado = estadoService.buscar(cidade.getEstado().getId());
				if(estado.getUf().equalsIgnoreCase(cliente.getEnderecos().get(0).getCidade().getEstado().getUf())){
					thisCidade = cidade;
					break;
				}
			}


			Endereco endereco = new Endereco();
			endereco.setCidade(thisCidade);
			endereco.setCep(cliente.getEnderecos().get(0).getCep());
			endereco.setNumero(cliente.getEnderecos().get(0).getNumero());
			endereco.setLogradouro(cliente.getEnderecos().get(0).getLogradouro());
			endereco.setBairro(cliente.getEnderecos().get(0).getBairro());
			endereco.setCliente(cliente);
			enderecoRepository.save(endereco);

			List<Endereco> enderecoList = new ArrayList<>();
			enderecoList.add(endereco);
			cliente.setEnderecos(enderecoList);

			clienteRepository.save(cliente);

			return "Salvo com sucesso";
		}
	}
}
