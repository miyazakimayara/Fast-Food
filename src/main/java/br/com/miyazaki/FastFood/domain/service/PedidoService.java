/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.miyazaki.FastFood.domain.service;

import br.com.miyazaki.FastFood.domain.model.Pedido;
import br.com.miyazaki.FastFood.domain.model.StatusPedido;
import br.com.miyazaki.FastFood.domain.repository.PedidoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjatb
 */
@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public Pedido criar(Pedido pedido){
        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setHorarioPedido(LocalDateTime.now());
        
        return pedidoRepository.save(pedido);
    }
    
    public Pedido salvar (Pedido pedido){
       Pedido pedidoExistente = pedidoRepository.findById(pedido.getId());
       
       if (pedidoExistente != null && !pedidoExistente.equals(pedido)){
           System.out.println("\"Já existe uma ordem de serviço cadastrado com esse Id!\"");
       }
       return pedidoRepository.save(pedido);
   }
   
   public void excluir (Long id){
       pedidoRepository.deleteById(id);
   }
}
