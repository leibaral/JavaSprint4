package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n02.S04T02N02MartinezJoanCarles.controllers;

import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n02.S04T02N02MartinezJoanCarles.models.FrutaModel;
import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n02.S04T02N02MartinezJoanCarles.services.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/fruta")
public class FrutaController {

    @Autowired
    private FrutaService frutaService;

    @GetMapping
    public ArrayList<FrutaModel> getFrutas(){
        return this.frutaService.getFrutas();
    }

    @PostMapping
    public FrutaModel saveFruta(@RequestBody FrutaModel fruta){
        return this.frutaService.saveFruta(fruta);
    }

    @GetMapping(path = "/{id}")
    public Optional<FrutaModel> getFrutaById(@PathVariable("id") Long id){
        return this.frutaService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public FrutaModel updateFrutaById(@RequestBody FrutaModel fruta, @PathVariable("id") Long id){
        return this.frutaService.updateById(fruta, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.frutaService.deleteFruta(id);

        if(ok){
            return "La fruta con id =" + id + " se ha eliminado";
        }else{
            return "Error";
        }
    }

}
