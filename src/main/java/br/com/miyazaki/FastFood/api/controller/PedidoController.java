/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.miyazaki.FastFood.api.controller;

import br.com.miyazaki.FastFood.DTO.PedidoDTO;
import br.com.miyazaki.FastFood.domain.model.Pedido;
import br.com.miyazaki.FastFood.domain.model.StatusPedido;
import br.com.miyazaki.FastFood.domain.repository.PedidoRepository;
import br.com.miyazaki.FastFood.domain.service.PedidoService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */
@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping
    public List<Pedido> listas(){
              
        return pedidoRepository.findAll();
    }
    
    
    @GetMapping("/{id}")
    public Optional<Pedido> buscar(@PathVariable Long id){
        return pedidoRepository.findById(id);
    }
    
    @GetMapping("/status/{status}")
    public List<Pedido> buscarPorStatus (@PathVariable StatusPedido status){
        return pedidoRepository.findByStatus(status);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido criar(@RequestBody Pedido pedido){
        return pedidoService.criar(pedido);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar (@Valid @PathVariable Long id, 
                                             @RequestBody Pedido pedido){
     
     
      if (!pedidoRepository.existsById(id)){
        return ResponseEntity.notFound().build();
      }
      
        pedido.setId(id);
        pedido = pedidoService.salvar(pedido);
        return ResponseEntity.ok(pedido);
     }
    
    @PutMapping("/status/{id}")
    public ResponseEntity<Pedido> atualizarStatus (@Valid @PathVariable Long id, 
                                                   @RequestBody PedidoDTO status){
     Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
       
      if (optionalPedido.isEmpty()){
        return ResponseEntity.notFound().build();
      }
      
        Pedido pedido = optionalPedido.get();
        pedido.setStatus(status.getStatus());
        pedido = pedidoRepository.save(pedido);
        
        return ResponseEntity.ok(pedido);
     }
    
    @DeleteMapping("/{id}")
     public ResponseEntity<Void> excluir (@PathVariable Long id){
     
     
       if (!pedidoRepository.existsById(id)){
        return ResponseEntity.notFound().build();
       }
        pedidoService.excluir(id);
        return ResponseEntity.noContent().build();
       
     }
}
