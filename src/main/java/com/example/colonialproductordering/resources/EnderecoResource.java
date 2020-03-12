package com.example.colonialproductordering.resources;

import com.example.colonialproductordering.domains.Cidade;
import com.example.colonialproductordering.domains.Endereco;
import com.example.colonialproductordering.domains.Estado;
import com.example.colonialproductordering.repositories.CidadeRepository;
import com.example.colonialproductordering.repositories.EnderecoRepository;
import com.example.colonialproductordering.repositories.EstadoRepository;
import com.example.colonialproductordering.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/get")
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @GetMapping("/getCidade")
    public List<Cidade> findAllCidades() {
        return cidadeRepository.findAll();
    }

    @GetMapping("/getEstado")
    public List<Estado> findAllEstado() {
        return estadoRepository.findAll();
    }

    @PostMapping("/addEndereco")
    public String save(@RequestBody Endereco endereco) {
        System.out.println(endereco);
        return enderecoService.saveEndereco(endereco);
    }

}
