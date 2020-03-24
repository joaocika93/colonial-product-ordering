package com.example.colonialproductordering.resources;

import com.example.colonialproductordering.domains.Cidade;
import com.example.colonialproductordering.domains.Estado;
import com.example.colonialproductordering.repositories.CidadeRepository;
import com.example.colonialproductordering.services.CidadeService;
import com.example.colonialproductordering.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {
    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    CidadeService cidadeService;

    @Autowired
    EstadoService estadoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) {

        Cidade obj = cidadeService.buscar(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/get")
    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }


    @GetMapping("/buscar/{nome}")
    public List<Cidade> buscarCidade(@PathVariable String nome) {
        return cidadeRepository.findByCidade(nome);
    }
}
