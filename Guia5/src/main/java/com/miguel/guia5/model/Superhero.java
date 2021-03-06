package com.miguel.guia5.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "superhero")
public class Superhero implements Serializable {

    @Id
    private int id;
    private String nombre;
    private int votos;

    public Superhero(){}

    public Superhero(int id, String nombre, int votos){
        this.id = id;
        this.nombre = nombre;
        this.votos = votos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", votos=" + votos +
                '}';
    }
}
