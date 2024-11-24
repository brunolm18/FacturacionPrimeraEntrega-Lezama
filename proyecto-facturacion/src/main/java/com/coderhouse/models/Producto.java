package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "Productos")
@Schema(description = "Modelo de Productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del producto", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    
    @Schema(description = "Nombre del producto", example = "Pan",requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private String nombre;
    
    @Schema(description = "Precio del producto", example = "15.50")
    private Double precio;

    @Schema(description = "Cantidad disponible del producto en el inventario",requiredMode = Schema.RequiredMode.REQUIRED,example = "20")
    private Integer stock;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "producto_cliente",
        joinColumns = @JoinColumn(name = "producto_id"),
        inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    @JsonIgnore
    @Schema(description = "Lista de clientes que han comprado este producto",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Cliente> clientes = new ArrayList<>();
    
   
    public Producto() { }

    
    public Producto(Long id, String nombre, Double precio, Integer stock, List<Cliente> clientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.clientes = clientes;
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


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", clientes="
				+ clientes + "]";
	}


}