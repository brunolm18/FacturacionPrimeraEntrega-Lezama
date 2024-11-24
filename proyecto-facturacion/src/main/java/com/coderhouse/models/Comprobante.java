package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Schema(description = "Modelo de Comprobante")
@Entity
@Table(name = "comprobantes")
public class Comprobante {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID del Comprobante", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @Schema(description = "Cliente relacionado con el comprobante", requiredMode = Schema.RequiredMode.REQUIRED)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "comprobante_producto",
        joinColumns = @JoinColumn(name = "comprobante_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    @Schema(description = "Productos asociados al comprobante", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Producto> productos; // Aquí es donde se almacenan los productos de la venta

    @Schema(description = "Fecha del comprobante", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-11-23T01:33:00")
    private LocalDateTime fecha;
    
    @Schema(description = "Total de la venta en el comprobante", requiredMode = Schema.RequiredMode.REQUIRED, example = "120.0")
    private Double total;
    
    @Schema(description = "Cantidad total de productos en el comprobante", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer cantidadTotal;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    @Schema(description = "Venta asociada al comprobante", requiredMode = Schema.RequiredMode.REQUIRED)
    private Venta venta; // Relaciona con la venta

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
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

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	    

	  
	    


}
