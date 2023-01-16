package com.example.api.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaClienteDTO {
    private Long codigo_venta;
    private Double total;
    private int cantidad_productos;
    private String nombre_Cliente;
    private String apellido_cliente;

    public VentaClienteDTO() {
    }

    public VentaClienteDTO(Long codigo_venta, Double total, int cantidad_productos, String nombre_Cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_productos = cantidad_productos;
        this.nombre_Cliente = nombre_Cliente;
        this.apellido_cliente = apellido_cliente;
    }
    
    
}
