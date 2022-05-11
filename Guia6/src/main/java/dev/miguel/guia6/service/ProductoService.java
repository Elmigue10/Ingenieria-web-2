package dev.miguel.guia6.service;

import dev.miguel.guia6.model.Producto;
import dev.miguel.guia6.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService {

    private ProductoRepository productoRepository;

    public List<Producto> listProducts(){ return productoRepository.findAll(); }

    public void saveProduct(Producto producto){
        productoRepository.save(producto);
    }

    public void deleteById(Integer id) { productoRepository.deleteById(Long.valueOf(id)); }

    public Producto listById(Integer id) { return productoRepository.findById(id.longValue()).get(); }

    public void editProduct(Producto productoRequest){

        Producto producto = productoRepository.findById(productoRequest.getId()).get();

        producto.setNombre(productoRequest.getNombre());
        producto.setDescripcion(productoRequest.getDescripcion());
        producto.setPrecio(productoRequest.getPrecio());
        producto.setImagen(productoRequest.getImagen());

        productoRepository.save(producto);

    }

}
