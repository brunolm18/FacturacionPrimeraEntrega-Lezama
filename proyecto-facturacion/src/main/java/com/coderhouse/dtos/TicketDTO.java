package com.coderhouse.dtos;

import java.time.LocalTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para representar un ticket generado por una venta")
public class TicketDTO {
	
	@Schema(description = "ID único del cliente asociado al ticket", example = "1")
	private Long clienteId;
	
	
    @Schema(description = "Hora de generación del ticket", example = "14:30:00")
    private LocalTime fecha;

    @Schema(description = "Nombre del cliente asociado al ticket", example = "Bruno Lezama")
    private String clienteNombre;

    @Schema(description = "Lista de IDs de los productos incluidos en el ticket", example = "[10, 12, 20]")
    private List<Long> productosIDs;

    @Schema(description = "Monto total de la venta asociado al ticket", example = "120.50")
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
	
	
	
