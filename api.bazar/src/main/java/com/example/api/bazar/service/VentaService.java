package com.example.api.bazar.service;

import com.example.api.bazar.model.Producto;
import com.example.api.bazar.model.Venta;
import com.example.api.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public Venta findVenta(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Venta> findAllVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }

    @Override
    public List<Producto> getProductsOfVentaById(Long id) {
        Venta ventaActual = this.findVenta(id);
        return ventaActual.getListaProductos();
        
        
    }

    @Override
    public String amountAndSalesQuantityOfTheDay(LocalDate fecha){
        Integer ventasFecha = 0;
        Double sumaMonto = 0.0;
            
        
        return "La cantidad de ventas de la fecha fueron: " + ventasFecha 
                + " y la suma del monto es de: " + sumaMonto;
    }
    
}
