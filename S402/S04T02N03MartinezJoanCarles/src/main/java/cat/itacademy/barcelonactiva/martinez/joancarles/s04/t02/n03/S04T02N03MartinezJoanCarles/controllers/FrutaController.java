package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n03.S04T02N03MartinezJoanCarles.controllers;

import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n03.S04T02N03MartinezJoanCarles.models.FrutaModel;
import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n03.S04T02N03MartinezJoanCarles.services.FrutaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class FrutaController {
    @Autowired
    private FrutaService frutaService;

    @GetMapping(value="/frutas",produces = "application/json")
    public ArrayList<FrutaModel> getFrutas(){
        return this.frutaService.getFrutas();
    }

    @PostMapping(value = "/addFruta")
    public FrutaModel saveFruta(@RequestBody FrutaModel fruta){
        return this.frutaService.saveFruta(fruta);
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public Optional<FrutaModel> getFrutaById(@PathVariable("id") String idStr){
        ObjectId id = new ObjectId(idStr);
        return this.frutaService.getById(id);
    } //En Postman, poner el ID obtenido al leerlo en MongoDB, 24 caracteres HEX, sin comillas.

    @PutMapping(value = "/{id}")
    public FrutaModel updateFruta(@RequestBody FrutaModel request, @PathVariable("id") String idStr) {
        ObjectId id = new ObjectId(idStr);
        return this.frutaService.updateById(request, id);
    }  //En Postman, poner el ID obtenido al leerlo en MongoDB, 24 caracteres HEX, sin comillas.

    @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable("id") String idStr){
        ObjectId id = new ObjectId(idStr);
        boolean ok = this.frutaService.deleteFruta(id);

        if(ok){
            return "La Fruta con id " + idStr + " se ha eliminado";
        }else {
            return "Se ha producido un error";
        }
    }  //En Postman, poner el ID obtenido al leerlo en MongoDB, 24 caracteres HEX, sin comillas.
}
