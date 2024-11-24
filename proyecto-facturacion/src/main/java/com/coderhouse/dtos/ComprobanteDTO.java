package com.coderhouse.dtos;


import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO que representa un comprobante con información de cliente, productos y fecha de la transacción")
public class ComprobanteDTO {

	 
	    

	    @Schema(description = "ID único del comprobante", 
	            example = "1")
	    private Long id;

	    @Schema(description = "Información del cliente asociado al comprobante")
	    private ClienteDTO cliente;

	    @Schema(description = "Lista de productos incluidos en el comprobante")
	    private List<ProductoDTO> productos;

	    @Schema(description = "Información sobre la fecha de la transacción")
	    private FechaDTO fecha;

	    @Schema(description = "Monto total de la transacción", example = "120.50")
	    private Double total;

	    @Schema(description = "Cantidad total de productos vendidos", example = "5")
	    private Integer cantidadTotal;
	    
	    
	    
		public ComprobanteDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ComprobanteDTO(Long id, ClienteDTO cliente, List<ProductoDTO> productos, FechaDTO fecha, Double total,
				Integer cantidadTotal) {
			super();
			this.id = id;
			this.cliente = cliente;
			this.productos = productos;
			this.fecha = fecha;
			this.total = total;
			this.cantidadTotal = cantidadTotal;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public ClienteDTO getCliente() {
			return cliente;
		}
		public void setCliente(ClienteDTO cliente) {
			this.cliente = cliente;
		}
		public List<ProductoDTO> getProductos() {
			return productos;
		}
		public void setProductos(List<ProductoDTO> productos) {
			this.productos = productos;
		}
		public FechaDTO getFecha() {
			return fecha;
		}
		public void setFecha(FechaDTO fecha) {
			this.fecha = fecha;
		}
		public Double getTotal() {
			return total;
		}
		public void setTotal(Double total) {
			this.total = total;
		}
		public Integer getCantidadTotal() {
			return cantidadTotal;
		}
		public void setCantidadTotal(Integer cantidadTotal) {
			this.cantidadTotal = cantidadTotal;
		}
		@Override
		public String toString() {
			return "ComprobanteDTO [id=" + id + ", cliente=" + cliente + ", productos=" + productos + ", fecha=" + fecha
					+ ", total=" + total + ", cantidadTotal=" + cantidadTotal + "]";
		}
	    
	    
		
	    
	    
	
}
