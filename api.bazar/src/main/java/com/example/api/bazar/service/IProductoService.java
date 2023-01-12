package com.example.api.bazar.service;

import com.example.api.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public Producto findProducto(Long id);
    
    public List<Producto> findAllProductos();
    
    public List<Producto> lessThanFiveProducts();
    
    public void saveProducto(Producto producto);
    
    public void deleteProducto(Long id);
    
    public void editProducto(Producto producto);
    
    
    
}
