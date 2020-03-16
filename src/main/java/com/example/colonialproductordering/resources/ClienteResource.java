package com.example.colonialproductordering.resources;

import com.example.colonialproductordering.domains.Cliente;
import com.example.colonialproductordering.repositories.ClienteRepository;
import com.example.colonialproductordering.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) {

        Cliente obj = clienteService.buscar(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/get")
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @PostMapping("/add")
    public String save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("/buscar/{nome}")
    public Cliente buscarUsuario(@PathVariable("nome") String nome){
        return clienteService.buscarUsuario(nome);
    }
}
