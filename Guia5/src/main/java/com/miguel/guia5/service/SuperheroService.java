package com.miguel.guia5.service;

import com.miguel.guia5.model.Superhero;
import com.miguel.guia5.model.SuperheroDTO;
import com.miguel.guia5.repository.SuperheroRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SuperheroService {

    private final SuperheroRepository superheroRepository;
    private Superhero superhero;
    private List<Superhero> superperheroes;
    private static final Logger logger = LogManager.getLogger("SuperheroesSurveyService");

    public List<Superhero> listar(){
        logger.info("Obteniendo superheroes de la base de datos");
        superperheroes = (List<Superhero>) superheroRepository.findAll();
        return superperheroes;
    }

    public Superhero actualizarVoto(Integer id){
        logger.info("Actualizando votos del superheroe con id: " + id);
        superhero = superheroRepository.findById(id).get();

        superhero.setVotos(superhero.getVotos()+1);

        superheroRepository.save(superhero);

        return superhero;
    }

    public int votosTotales(){
        logger.info("Obteniendo la sumatoria de los votos totales");
        superperheroes = (List<Superhero>) superheroRepository.findAll();
        int votosTotales = 0;
        for (Superhero superheroIter: superperheroes) {
            votosTotales += superheroIter.getVotos();
        }
        return votosTotales;
    }

    public List<SuperheroDTO> superheroesPercentage(){
        logger.info("Obteniendo el porcentaje de votos de cada superheroe");
        DecimalFormat df = new DecimalFormat("#.00");
        List<SuperheroDTO> superheroDTOS = new ArrayList<>();
        superperheroes = (List<Superhero>) superheroRepository.findAll();
        int votosTotales = this.votosTotales();
        for (Superhero superheroIter: superperheroes) {
            float porcentajeVotos = (float)(superheroIter.getVotos() * 100) / votosTotales;
            String porcentajeVotosStr = df.format(porcentajeVotos);
            superheroDTOS.add(new SuperheroDTO(
                    superheroIter.getId(),
                    superheroIter.getNombre(),
                    superheroIter.getVotos(),
                    porcentajeVotosStr
            ));
        }

        superheroDTOS.sort(Comparator.comparing(SuperheroDTO::getVotos).reversed());

        return superheroDTOS;
    }

}
