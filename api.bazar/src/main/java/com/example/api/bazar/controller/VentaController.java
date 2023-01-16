package com.example.api.bazar.controller;

import com.example.api.bazar.model.Producto;
import com.example.api.bazar.model.Venta;
import com.example.api.bazar.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    private IVentaService ventaServ;

    @GetMapping("/ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable Long id) {
        return ventaServ.findVenta(id);
    }
    
    @GetMapping("/ventas")
    public List<Venta> findAllVentas() {
        return ventaServ.findAllVentas();
    }
    
    @PostMapping("/ventas/crear")
    public void saveVenta(@RequestBody Venta venta) {
        ventaServ.saveVenta(venta);
    }

    @GetMapping("/ventas/eliminar/{codigo_venta}")
    public void deleteVenta(@PathVariable Long id) {
        ventaServ.deleteVenta(id);
    }

    @PutMapping("/ventas/editar")
    public void editVenta(@RequestBody Venta venta) {
        ventaServ.editVenta(venta);
    }
    
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductsOfVentaById(@PathVariable Long codigo_venta) {
        return ventaServ.getProductsOfVentaById(codigo_venta);
    }
    
    @GetMapping("/ventas/dia")
    public String amountAndSalesQuantityOfTheDay(@RequestParam LocalDate fecha){
        return ventaServ.amountAndSalesQuantityOfTheDay(fecha);
    }
    
    @GetMapping("/ventas/masCara")
    public String ventaMostExpensive() {
        return ventaServ.ventaMostExpensive();
    }
}
