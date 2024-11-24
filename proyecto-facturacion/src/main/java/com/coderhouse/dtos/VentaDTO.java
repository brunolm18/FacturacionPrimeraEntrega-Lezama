package com.coderhouse.dtos;


import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para representar una venta realizada por un cliente, incluyendo los productos vendidos")
public class VentaDTO {
	@Schema(description = "ID único del cliente asociado a la venta", example = "1")
	    private Long clienteId;
	

    @Schema(description = "Lista de IDs de los productos vendidos", 
            example = "[10, 12, 15]")
    private List<Long> productosIds;
	   
	    
	    
	    public VentaDTO() {}

	    public VentaDTO(Long clienteId, List<Long> productosIds) {
	        this.clienteId = clienteId;
	        this.productosIds = productosIds;
	    }

	    public Long getClienteId() {
	        return clienteId;
	    }

	    public void setClienteId(Long clienteId) {
	        this.clienteId = clienteId;
	    }

	    public List<Long> getProductosIds() {
	        return productosIds;
	    }

	    public void setProductosIds(List<Long> productosIds) {
	        this.productosIds = productosIds;
	    }
	}
	    
