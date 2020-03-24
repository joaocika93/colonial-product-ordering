package com.example.colonialproductordering.resources;

import com.example.colonialproductordering.domains.Cliente;
import com.example.colonialproductordering.domains.Estado;
import com.example.colonialproductordering.repositories.EstadoRepository;
import com.example.colonialproductordering.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoResource {
    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    EstadoService estadoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Estado obj = estadoService.buscar(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/get")
    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    @PostMapping("/add")
    public String save(@RequestBody Estado estado) {
        return estadoService.save(estado);
    }

    @GetMapping("/buscar/{nome}")
    public Estado buscarEstado(@PathVariable("nome") String uf){
        return estadoService.buscarEstado(uf);
    }


}
