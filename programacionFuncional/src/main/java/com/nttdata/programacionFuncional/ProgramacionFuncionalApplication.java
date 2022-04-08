package com.nttdata.programacionFuncional;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.programacionFuncional.model.Product;
import com.nttdata.programacionFuncional.model.Tax;

@SpringBootApplication
public class ProgramacionFuncionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramacionFuncionalApplication.class, args);
		
		Product product = new Product();
		
		List<Product> shoppingCart = List.of(
				new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
				new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
				new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
				new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
				new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
				new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));
		
		System.out.println(product.calcularCosteTotal(shoppingCart));
		product.listarProductosOrdenados(shoppingCart);
		
		
		
		
	}

}
