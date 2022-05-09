package dev.miguel.guia6.service;

import dev.miguel.guia6.model.Producto;
import dev.miguel.guia6.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

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
