package com.example.api.bazar.service;

import com.example.api.bazar.model.Producto;
import com.example.api.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {

    public Venta findVenta(Long id);
    
    public List<Venta> findAllVentas();
    
    public List<Producto> getProductsOfVentaById(Long id);

    public String ventaMostExpensive();
    
    public String amountAndSalesQuantityOfTheDay(LocalDate fecha);
    
    public void saveVenta(Venta venta);
    
    public void deleteVenta(Long id);
    
    public void editVenta(Venta venta);
    
    
}
