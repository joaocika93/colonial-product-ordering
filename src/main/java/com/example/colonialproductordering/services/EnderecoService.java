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

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.upperCase;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoService estadoService;

    public Endereco buscar(Integer id) {
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
    }

    public String saveEndereco(Endereco endereco) {
        if (cidadeRepository.findByCidade(endereco.getCidade().getNome()) == null) {
            return "Cidade não encontrada";
        } else {
            List<Cidade> cidadeList = cidadeRepository.findByCidade(endereco.getCidade().getNome());

            Estado estado;
            Cidade thisCidade = new Cidade();
            for (Cidade cidade : cidadeList) {
                estado = estadoService.buscar(cidade.getEstado().getId());
                if(estado.getUf().equalsIgnoreCase(endereco.getCidade().getEstado().getUf())){
                    thisCidade = cidade;
                    break;
                }
            }

            endereco.setCidade(thisCidade);

            enderecoRepository.save(endereco);
            return "Salvo com Sucesso";
        }
    }
}
