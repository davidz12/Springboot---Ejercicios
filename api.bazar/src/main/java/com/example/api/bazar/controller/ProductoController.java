package com.example.api.bazar.controller;

import com.example.api.bazar.model.Producto;
import com.example.api.bazar.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productoServ;

    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long id) {
        return productoServ.findProducto(id);
    }
    
    @GetMapping("/productos")
    public List<Producto> findAllProductos() {
        return productoServ.findAllProductos();
    }

    @PostMapping("/productos/crear")
    public void saveProducto(@RequestBody Producto producto) {
        productoServ.saveProducto(producto);
    }
        
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void deleteProducto(@PathVariable Long id) {
        productoServ.deleteProducto(id);
    }

    @PutMapping("/productos/editar")
    public void editProducto(@RequestBody Producto producto) {
        productoServ.editProducto(producto);
    }

    @GetMapping("/prodcutos/falta_stock")
    public List<Producto> lessThanFiveProducts() {
        return productoServ.lessThanFiveProducts();
    }
}
