package com.coderhouse.dtos;

public class ProductoDTO {

	
	private String productoid;
	private Double precio;
	private Integer cantidad;
	public String getProductoId() {
		return productoid;
	}
	public void setProductoId(String productoid) {
		this.productoid = productoid;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}