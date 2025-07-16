/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.miyazaki.FastFood.DTO;

import br.com.miyazaki.FastFood.domain.model.StatusPedido;

/**
 *
 * @author ppjatb
 */
public class PedidoDTO {
    
    private StatusPedido status;

    public PedidoDTO() {
    }

    public PedidoDTO(StatusPedido status) {
        this.status = status;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    
    
    
}
