package com.miguel.guia5.controller;

import com.miguel.guia5.model.Superhero;
import com.miguel.guia5.model.SuperheroDTO;
import com.miguel.guia5.service.SuperheroService;
import com.mysql.cj.log.Log;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SurveyController {

    private final SuperheroService superheroService;
    private Superhero superhero;
    private static final Logger logger = LogManager.getLogger("SuperheroesSurveyController");

    @GetMapping("/")
    public String index(Model model,
                        @CookieValue(value = "superheroesSurvey.superheroName", defaultValue = "notCookie") String superheroName){

        logger.info("Obteniendo todos los superheroes de la base de datos");
        List<Superhero> superheroes = superheroService.listar();

        if(!superheroName.equals("notCookie")){
            logger.info("Leyendo cookies del usuario");
            model.addAttribute("superheroName", superheroName);
            model.addAttribute("messageCookie", "Tu anterior voto fue para: ");
        }

        model.addAttribute("superheroes", superheroes);

        return "index";
    }

    @GetMapping("/statistics")
    public String votar(@RequestParam(defaultValue = "notId" ) String id,
                        Model model,
                        HttpServletResponse response,
                        @CookieValue(value = "superheroesSurvey.superheroName", defaultValue = "notCookie") String superheroName)
                        throws UnsupportedEncodingException {

        if(!superheroName.equals("notCookie")){
            logger.info("Leyendo cookies del usuario");
            model.addAttribute("superheroName", superheroName);
            model.addAttribute("messageCookie", "Tu anterior voto fue para: ");
        }

        if(!id.equals("notId")) {
            logger.info("Actualizando votos para el superheroe con el id: " + id);
            superhero = superheroService.actualizarVoto(Integer.valueOf(id));
            model.addAttribute("mensaje", "Has votado por: ");
            model.addAttribute("superheroVotado", superhero);

            //      Creando las cookies
            logger.info("Creando cookies del usuario");
            Cookie cookieSuperheroId = new Cookie("superheroesSurvey.superheroId",
                    URLEncoder.encode( String.valueOf(superhero.getId()), "UTF-8" ).replace("+", "%20"));
            Cookie cookieSuperheroName = new Cookie("superheroesSurvey.superheroName",
                    URLEncoder.encode( superhero.getNombre(), "UTF-8" ).replace("+", "%20"));
            Cookie cookieSuperheroVotos = new Cookie("superheroesSurvey.superheroVotos",
                    URLEncoder.encode( String.valueOf(superhero.getId()), "UTF-8" ).replace("+", "%20"));
            //      Vida de la cookie
            cookieSuperheroId.setMaxAge(365 * 24 * 60 * 60); //Un año de vida para la cookie
            cookieSuperheroName.setMaxAge(365 * 24 * 60 * 60); //Un año de vida para la cookie
            cookieSuperheroVotos.setMaxAge(365 * 24 * 60 * 60); //Un año de vida para la cookie
            //      Eviar las cookies en la respuesta
            response.addCookie(cookieSuperheroId);
            response.addCookie(cookieSuperheroName);
            response.addCookie(cookieSuperheroVotos);
        }

        logger.info("Obteniendo los votos totales de los superheroes");
        int votosTotales = superheroService.votosTotales();
        logger.info("Obteniendo porcentaje de votos de cada supeheroe");
        List<SuperheroDTO> superheroes = superheroService.superheroesPercentage();
        model.addAttribute("superheroes", superheroes);
        model.addAttribute("votosTotales", votosTotales);
        return "statistics";

    }

}
