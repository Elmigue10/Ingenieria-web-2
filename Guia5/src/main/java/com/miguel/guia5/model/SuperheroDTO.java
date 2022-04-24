package com.miguel.guia5.model;

public class SuperheroDTO extends Superhero{

    private String porcentajeVotos;

    public SuperheroDTO (){
        super();
    }

    public SuperheroDTO(int id, String nombre, int votos, String porcentajeVotos){
        super(id, nombre, votos);
        this.porcentajeVotos = porcentajeVotos;
    }

    public String getPorcentajeVotos() { return porcentajeVotos; }

    public void setPorcentajeVotos(String porcentajeVotos) { this.porcentajeVotos = porcentajeVotos; }

}
