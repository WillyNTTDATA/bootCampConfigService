package com.nttdata.programacionFuncional.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;





public class Product implements Comparable<Product> {

	BigDecimal total = new BigDecimal(0);
	BigDecimal ivaAsignado = new BigDecimal(0);

	private String nombre;
	private BigDecimal precio;
	Tax tax;

	// getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	// constructores

	public Product(String nombre, BigDecimal precio, Tax tax) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.tax = tax;
	}

	public Product() {
		super();

	}

	// ToString

	@Override
	public String toString() {
		return "Product [nombre=" + nombre + ", precio=" + precio + ", tax=" + tax + "]";
	}

	@Override
	public int compareTo(Product o) {
		int ordenar = this.nombre.compareTo(o.getNombre());
		return ordenar;
	}

	public BigDecimal calcularCosteTotal(List<Product> shoppingCart) {

		shoppingCart.stream().forEach((p) -> {

			ivaAsignado = p.getPrecio().multiply(p.getTax().getPrecio());
			total = total.add(p.getPrecio().add(ivaAsignado));

		});
		return total;

	}

	public void listarProductosOrdenados(List<Product> shoppingCart) {

		Stream<Product> listado = shoppingCart.stream().filter(prod -> prod.getNombre().startsWith("C")).sorted();
		listado.forEach((p) -> {
			
			String listadoSeparadoPorComa = String.join("",p.getNombre(),",");
			//listadoSeparadoPorComa = StringUtils.removeEnd(listadoSeparadoPorComa, ",");
			
			System.out.print(listadoSeparadoPorComa);
		});
		
	}

}
