package com.example.api.bazar.service;

import com.example.api.bazar.dto.VentaClienteDTO;
import com.example.api.bazar.model.Producto;
import com.example.api.bazar.model.Venta;
import com.example.api.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
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
        calculatePrice(venta);
        ventaRepo.save(venta);
    }
    
    public void calculatePrice(Venta venta){
        //calculo el total de los productos, asi no lo tengo que poner a mano en el JSON
        List<Producto> listaProductos = venta.getListaProductos();
        Double totalPrice = 0.0;
        for (Producto p : listaProductos) {
            totalPrice = totalPrice + p.getCosto();
        }
        venta.setTotal(totalPrice);
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
        
        List<Venta> listaVentas = this.findAllVentas();
        List<Venta> listaVentasSegunFecha = new ArrayList<>();
        
        
        //Guardo en una lista aparte, las ventas que tienen la misma fecha que el paremetro.
        for(Venta venta : listaVentas) {
            if(venta.getFecha_venta().equals(fecha)) {
                listaVentasSegunFecha.add(venta);
            }
        }
        
        //Por cada venta de esa fecha sumamos el monto total y la cantidad de ventas de ese dia.
        for(Venta v : listaVentasSegunFecha){
            sumaMonto += v.getTotal();
            ventasFecha += 1;
        }
        
        return " La cantidad de ventas de la fecha fueron: " + ventasFecha
                + ", la suma total de las ventas es de: " + sumaMonto;
    }

    @Override
    public String ventaMostExpensive() {
        List<Venta> ventasActuales = this.findAllVentas();
        Double comparacion = 0.0;
        Venta venta = null;
        VentaClienteDTO ventaCliente = new VentaClienteDTO();
        
        for (Venta v : ventasActuales) {
            if (v.getTotal() > comparacion){
                comparacion = v.getTotal();
                venta = v;
            }
        }
        
        ventaCliente.setCodigo_venta(venta.getCodigo_venta());
        ventaCliente.setCantidad_productos(venta.getListaProductos().size());
        ventaCliente.setTotal(venta.getTotal());
        ventaCliente.setNombre_Cliente(venta.getUnCliente().getNombre());
        ventaCliente.setApellido_cliente(venta.getUnCliente().getApellido());
        
        
        return "codigo de venta: " + ventaCliente.getCodigo_venta() +
                ", cantidad de productos: " + ventaCliente.getCantidad_productos() +
                ", nombre de cliente: " + ventaCliente.getNombre_Cliente() +
                ", apellido de cliente: " + ventaCliente.getApellido_cliente();
    }
}
