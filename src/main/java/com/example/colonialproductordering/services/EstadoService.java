package com.example.colonialproductordering.services;

import com.example.colonialproductordering.domains.Estado;
import com.example.colonialproductordering.repositories.EstadoRepository;
import com.example.colonialproductordering.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    public Estado buscar(Integer id) {
        Optional<Estado> obj = estadoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
    }

    public String save(Estado estado) {
        estado.setNome(toUpperCase(estado.getNome()));
        estadoRepository.save(estado);

        return "Salvo com sucesso";
    }

    public Estado buscarEstado(String uf) {
        return estadoRepository.findByEstado(uf);
    }


}
