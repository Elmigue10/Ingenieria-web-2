package com.miguel.guia5.controller;

import com.miguel.guia5.model.Superhero;
import com.miguel.guia5.model.SuperheroDTO;
import com.miguel.guia5.service.SuperheroService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/")
    public String index(Model model,
                        @CookieValue(value = "superheroesSurvey.superheroName", defaultValue = "notCookie") String superheroName){

        List<Superhero> superheroes = superheroService.listar();

        if(!superheroName.equals("notCookie")){
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
            model.addAttribute("superheroName", superheroName);
            model.addAttribute("messageCookie", "Tu anterior voto fue para: ");
        }

        if(!id.equals("notId")) {
            superhero = superheroService.actualizarVoto(Integer.valueOf(id));
            model.addAttribute("mensaje", "Has votado por: ");
            model.addAttribute("superheroVotado", superhero);
        }

//      Creando las cookies
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

        int votosTotales = superheroService.votosTotales();
        List<SuperheroDTO> superheroes = superheroService.superheroesPercentage();
        model.addAttribute("superheroes", superheroes);
        model.addAttribute("votosTotales", votosTotales);
        return "statistics";

    }

}
