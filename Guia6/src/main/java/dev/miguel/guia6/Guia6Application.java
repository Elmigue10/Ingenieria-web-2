package dev.miguel.guia6;

import dev.miguel.guia6.model.Producto;
import dev.miguel.guia6.repository.ProductoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Guia6Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(Guia6Application.class, args);

        ProductoRepository productoRepository = configurableApplicationContext.getBean(ProductoRepository.class);

        Producto producto = new Producto(
                "Tarjeta Grafica 1650",
                "Tarjeta Grafica marca Asus, referencia 1650",
                "https://www.asus.com/media/global/products/j0nKeMNmr3TXMB7y/P_setting_xxx_0_90_end_500.png",
                2425126);

        productoRepository.save(producto);

    }

}
