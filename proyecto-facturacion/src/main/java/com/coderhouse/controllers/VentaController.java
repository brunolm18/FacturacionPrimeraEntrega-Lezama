package com.coderhouse.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dtos.VentaDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;
import com.coderhouse.models.Venta;
import com.coderhouse.services.ClienteService;
import com.coderhouse.services.ProductoService;
import com.coderhouse.services.VentaService;


@RestController
@RequestMapping("/api/ventas")
public class VentaController {

	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProductoService productoService;

	@GetMapping
	public ResponseEntity<List<Venta>> getAllVentas() {
		try {
			List<Venta> ventas = ventaService.findAll();
			return ResponseEntity.ok(ventas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
		try {
			Venta venta = ventaService.getVentaById(id);
			return ResponseEntity.ok(venta);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Venta> createVenta(@RequestBody VentaDTO ventaDTO) {
		 try {
		        
		       Venta venta = new Venta();
		        
		       Cliente cliente = clienteService.findById(ventaDTO.getClienteId());
		        venta.setCliente(cliente);
		        
		       List<Producto> productos = ventaDTO.getProductosIds().stream().map(productoId -> productoService.getProductoById(productoId)).collect(Collectors.toList()); 

		        venta.setProductos(productos);

		        Venta createdVenta = ventaService.createVenta(venta);
		        return ResponseEntity.status(HttpStatus.CREATED).body(createdVenta);
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
		}
	
	@PutMapping("/{id}")
	public ResponseEntity<Venta> updateVenta(@PathVariable Long id, 
			@RequestBody Venta categoriaDetails) {
		try {
			Venta updatedVenta = ventaService.updateVenta(id, categoriaDetails);
			return ResponseEntity.ok(updatedVenta);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
		try {
			if (ventaService.existsById(id)) {
				ventaService.deleteById(id);
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
