package com.example.api.bazar.service;

import com.example.api.bazar.model.Producto;
import com.example.api.bazar.model.Venta;
import java.util.List;


public interface IVentaService {

    public Venta findVenta(Long id);
    
    public List<Venta> findAllVentas();
    
    public List<Producto> getProductsOfVentaById(Long id);
    
    public String amountAndSalesQuantityOfTheDay();
    
    public void saveVenta(Venta venta);
    
    public void deleteVenta(Long id);
    
    public void editVenta(Venta venta);
    
    
}
