package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Venta;
import com.coderhouse.repositories.VentaRepository;

import jakarta.transaction.Transactional;

@Service
public class VentaService {
	
	@Autowired
	private VentaRepository ventaRepository;
	
	public List<Venta> findAll(){
		return ventaRepository.findAll();
	}
	
	public Venta getVentaById(Long id) {
		return ventaRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Venta no encontrada"));
	}
	
	public boolean existsById(Long id) {
		return ventaRepository.existsById(id);	
				
	}
	
	@Transactional
	public Venta createVenta(Venta venta) {
		return ventaRepository.save(venta);
	}
	
	@Transactional
	public Venta updateVenta(Long id,Venta ventaDetails) {
		Venta venta = ventaRepository.findById(id)
				.orElseThrow(() -> new  IllegalArgumentException("Venta no fue encontrada"));
				
		
		venta.setCliente(ventaDetails.getCliente());
		venta.setProductos(ventaDetails.getProductos());
		
		return ventaRepository.save(venta);
		
	}
	
	public void deleteById(Long id) {
		ventaRepository.deleteById(id);
	}
	

}
