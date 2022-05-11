package dev.miguel.guia6.controller;

import dev.miguel.guia6.model.Producto;
import dev.miguel.guia6.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ProductoController {


    private ProductoService productoService;

    @GetMapping("/productos")
    public String list(Model model){

        model.addAttribute("productos", productoService.listProducts());
        model.addAttribute("producto", new Producto());

        return "index";
    }

    @PostMapping("/save")
    public String save(Producto producto, Model model){

        model.addAttribute("producto", producto);
        productoService.saveProduct(producto);

        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        productoService.deleteById(id);

        return "redirect:/productos";
    }

    @GetMapping("/producto/{id}")
    public String listById(@PathVariable Integer id, Model model){

        Producto producto = productoService.listById(id);

        model.addAttribute("producto", producto);
        model.addAttribute("productoId", id);

        return "edit";
    }

    @PostMapping("/edit")
    public String editById(Producto producto, Model model){

        productoService.editProduct(producto);

        return "redirect:/productos";
    }
}
