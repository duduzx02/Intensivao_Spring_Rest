package com.algaworks.awpag.Controller;

import com.algaworks.awpag.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Edardo");
        cliente1.setTelefone("83 993869574");
        cliente1.setEmail("Edu@gmail.com");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("João");
        cliente2.setTelefone("83 993854774");
        cliente2.setEmail("João@gmail.com");

        return Arrays.asList(cliente1, cliente2);
    }
}