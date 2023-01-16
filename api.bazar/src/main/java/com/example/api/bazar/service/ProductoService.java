package com.example.api.bazar.service;

import com.example.api.bazar.model.Producto;
import com.example.api.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public Producto findProducto(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> findAllProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
        
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }

    @Override
    public List<Producto> lessThanFiveProducts() {
        List<Producto> productosActuales;
        productosActuales = this.findAllProductos();

        List<Producto> menosDe5Productos = new ArrayList<>();
        
        for(Producto p : productosActuales) {
            if (p.getCantidad_disponible() < 5) {
                menosDe5Productos.add(p);
            }
        }
        return menosDe5Productos;
    }
    
}
