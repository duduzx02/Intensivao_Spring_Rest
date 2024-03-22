package com.algaworks.awpag.Controller;

import com.algaworks.awpag.model.Cliente;
import com.algaworks.awpag.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@AllArgsConstructor
@RestController
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return clienteRepository.findByNomeContaining("Lima");
    }
}
