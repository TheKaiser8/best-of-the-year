package org.lessons.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // con l'annotation @ specifico a Spring che questa classe è un controller
@RequestMapping("/") // la rotta a cui rispondono i metodi di questo controller
public class IndexController {

    @GetMapping // specifico che il metodo risponde alle richieste di tipo http GET
    // Per inserire un parametro che può essere dinamico: chiediamo a Spring di invocare questo metodo passandogli il Model
    public String home(Model model) {
        String name = "Stefano";
        model.addAttribute("name", name); // aggiungo alla mappa del Model un attributo

        return "index"; // ritorno il nome del template index.html che si trova nella cartella resources/templates
    }
}
