/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.miyazaki.FastFood.domain.repository;

import br.com.miyazaki.FastFood.domain.model.Pedido;
import br.com.miyazaki.FastFood.domain.model.StatusPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ppjatb
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
    Pedido findById(long id);
    
    @Override
    List<Pedido> findAll();

    public List<Pedido> findByStatus(StatusPedido status);
}
