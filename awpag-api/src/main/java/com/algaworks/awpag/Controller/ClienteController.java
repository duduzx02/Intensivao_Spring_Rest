package com.algaworks.awpag.Controller;

import com.algaworks.awpag.model.Cliente;
import com.algaworks.awpag.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findByNomeContaining("Lima");
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente){
        if(!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        Cliente clienteAtualizado = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteId){
        if(!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(clienteId);
            return ResponseEntity.noContent().build();
        }
}
