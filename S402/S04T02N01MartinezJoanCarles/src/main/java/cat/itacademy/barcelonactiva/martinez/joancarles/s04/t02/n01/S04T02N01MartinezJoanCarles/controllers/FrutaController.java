package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n01.S04T02N01MartinezJoanCarles.controllers;

import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n01.S04T02N01MartinezJoanCarles.models.FrutaModel;
import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n01.S04T02N01MartinezJoanCarles.services.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping("/fruta")
public class FrutaController {
    @Autowired
    FrutaService frutaService;
    @PostMapping
    public FrutaModel addFruta(@RequestBody FrutaModel fruta){
        return this.frutaService.addFruta(fruta);
    }
    @GetMapping
    public List<FrutaModel> listFrutas(){
        return this.frutaService.listFrutas();
    }
    @GetMapping("/{id}")
    public FrutaModel getFrutaById(@PathVariable("id") Long id){
        return this.frutaService.getFrutaById(id);
    }
    @PutMapping(path = "/{id}")
    public FrutaModel updateFrutaById(@RequestBody FrutaModel fruta, @PathVariable("id") Long id){
        return this.frutaService.updateById(fruta, id);
    }
    @DeleteMapping("/{id}")
    public String deleteFruta(@PathVariable("id") Long id){
        boolean ok = this.frutaService.deleteFruta(id);
        if(ok){
            return "La fruta con id =" + id + " se ha eliminado";
        }else{
            return "Error";
        }
    }
}

