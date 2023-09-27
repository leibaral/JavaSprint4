package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t01.n02.S04T01N02MartinezJoanCarles.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/HelloWorld")
    public String saluda (@RequestParam(defaultValue = "UNKNOWN") String nombre){
        return "Hola, " + nombre + ". Estàs executant un projecte Gradle.";
    }

    @GetMapping({"/HelloWorld2", "/HelloWorld2/{nombre}"})
    public String saluda2 (@PathVariable(required = false) String nombre){
        if (nombre == null){
            nombre = "UNKNOWN";
        }
        return "Hola, " + nombre + ". Estàs executant un projecte Gradle.";
    }
}
