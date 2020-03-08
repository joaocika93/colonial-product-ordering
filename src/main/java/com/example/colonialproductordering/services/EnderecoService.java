package com.example.colonialproductordering.services;

import com.example.colonialproductordering.domains.Cidade;
import com.example.colonialproductordering.domains.Cliente;
import com.example.colonialproductordering.domains.Endereco;
import com.example.colonialproductordering.domains.Estado;
import com.example.colonialproductordering.repositories.CidadeRepository;
import com.example.colonialproductordering.repositories.EnderecoRepository;
import com.example.colonialproductordering.repositories.EstadoRepository;
import com.example.colonialproductordering.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    ClienteService clienteService;

    public Endereco buscar(Integer id) {
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
    }

    public String saveEndereco(Endereco endereco){
        System.out.println();
        Estado estado = new Estado();
        estado.setId(endereco.getCidade().getEstado().getId());
        estado.setNome(endereco.getCidade().getEstado().getNome());

        Cidade cidade = new Cidade();
        cidade.setEstado(estado);
        cidade.setNome(endereco.getCidade().getNome());
        cidade.setId(endereco.getCidade().getId());

        estadoRepository.save(estado);
        cidade.setEstado(estado);
        cidadeRepository.save(cidade);
        endereco.setCidade(cidade);
        enderecoRepository.save(endereco);
        return "Salvo com Sucesso";
    }
}
