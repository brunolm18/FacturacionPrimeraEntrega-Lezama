package com.coderhouse.dtos;

import com.coderhouse.models.Producto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "DTO para representar un producto")
public class ProductoDTO {

 
    
    @Schema(description = "ID único del producto", 
            example = "10")
    private Long id;

    @Schema(description = "Nombre del producto", 
            example = "Pan")
    private String nombre;

    @Schema(description = "Precio unitario del producto", 
            example = "15.50")
    private Double precio;

    @Schema(description = "Cantidad en stock del producto", 
            example = "20")
    private Integer stock;
    
    
    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.stock = producto.getStock();
    }
    
    

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
    
    
  	
    
}
