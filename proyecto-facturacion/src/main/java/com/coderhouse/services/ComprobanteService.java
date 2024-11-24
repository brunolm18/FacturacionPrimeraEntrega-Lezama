package com.coderhouse.services;

import java.time.LocalDateTime;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.coderhouse.dtos.ClienteDTO;
import com.coderhouse.dtos.ComprobanteDTO;
import com.coderhouse.dtos.FechaDTO;
import com.coderhouse.dtos.ProductoDTO;

import com.coderhouse.models.Comprobante;

import com.coderhouse.models.Producto;
import com.coderhouse.models.Venta;

import com.coderhouse.repositories.ComprobanteRepository;
import com.coderhouse.repositories.ProductoRepository;
import com.coderhouse.repositories.VentaRepository;



@Service
public class ComprobanteService {
	 
	@Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ComprobanteRepository comprobanteRepository;
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private FechaService fechaService;  // Se Inyecta el servicio de fecha

    public ComprobanteDTO generarComprobante(Long ventaId) {
        // Buscar la venta y los productos relacionados
        Venta venta = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));

        List<Producto> productos = productoRepository.findByIdIn(venta.getProductos().stream()
                .map(Producto::getId)
                .collect(Collectors.toList()));

        // Obtener fecha desde el servicio externo
        FechaDTO fechaDTO = fechaService.obtenerFecha();  //Se  Llama al servicio para obtener la fecha

        // Calcular total y cantidad total
        Double total = 0.0;
        Integer cantidadTotal = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getStock();  // Asumimos que stock es la cantidad vendida
            cantidadTotal += producto.getStock();
        }

        // Crear el comprobante
        Comprobante comprobante = new Comprobante();
        comprobante.setFecha(LocalDateTime.now()); // Si no se usa la fecha del DTO, puedes poner LocalDateTime.now()
        comprobante.setCliente(venta.getCliente());
        comprobante.setProductos(productos);
        comprobante.setTotal(total);
        comprobante.setCantidadTotal(cantidadTotal);

        // Guardar comprobante
        comprobante = comprobanteRepository.save(comprobante);

        // Crear el DTO de respuesta
        ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
        comprobanteDTO.setId(comprobante.getId());
        comprobanteDTO.setCliente(new ClienteDTO(comprobante.getCliente()));
        comprobanteDTO.setProductos(productos.stream()
                .map(producto -> new ProductoDTO(producto))
                .collect(Collectors.toList()));
        comprobanteDTO.setFecha(fechaDTO); // Aquí asignamos la fecha obtenida del servicio externo
        comprobanteDTO.setTotal(comprobante.getTotal());
        comprobanteDTO.setCantidadTotal(comprobante.getCantidadTotal());

        return comprobanteDTO;
    }
}