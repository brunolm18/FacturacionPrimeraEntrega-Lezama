package com.coderhouse.dtos;

import java.time.LocalTime;
import java.util.List;

public class TicketDTO {
	private Long clienteId;
	private LocalTime fecha;
	private String clienteNombre;
	private List<Long> productosIDs;
	private Double total;
	
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public LocalTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalTime fecha) {
		this.fecha = fecha;
	}
	public String getClienteNombre() {
		return clienteNombre;
	}
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}
	public List<Long> getProductosIDs() {
		return productosIDs;
	}
	public void setProductos(List<Long> productosIDs) {
		this.productosIDs = productosIDs;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}
	
	
	
