package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n03.S04T02N03MartinezJoanCarles.services;

import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n03.S04T02N03MartinezJoanCarles.models.FrutaModel;
import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n03.S04T02N03MartinezJoanCarles.repositories.IFrutaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FrutaService {

    @Autowired
    IFrutaRepository frutaRepository;

    public ArrayList<FrutaModel> getFrutas(){
        return (ArrayList<FrutaModel>) frutaRepository.findAll();
    }

    public FrutaModel saveFruta(FrutaModel fruta){
        return frutaRepository.save(fruta);
    }

    public Optional<FrutaModel> getById(ObjectId id){
        return frutaRepository.findById(id);
    }

    public FrutaModel updateById(FrutaModel request, ObjectId id){
        FrutaModel fruta = frutaRepository.findById(id).orElse(null);
        if (fruta != null) {
            fruta.setNom(request.getNom());
            fruta.setQuantitatQuilos(request.getQuantitatQuilos());
            frutaRepository.save(fruta);
        }
        return fruta;
    }

    public Boolean deleteFruta(ObjectId id){
        try{
            frutaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}