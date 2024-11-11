package com.coderhouse.dtos;


import java.util.List;

public class VentaDTO {
	    private Long clienteId;
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
	    
