package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n01.S04T02N01MartinezJoanCarles.services;

import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n01.S04T02N01MartinezJoanCarles.controllers.FrutaNotFoundException;
import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n01.S04T02N01MartinezJoanCarles.models.FrutaModel;
import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n01.S04T02N01MartinezJoanCarles.repository.IFrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FrutaService {
    @Autowired
    IFrutaRepository frutaRepository;

    public FrutaModel addFruta(FrutaModel fruta){
        return frutaRepository.save(fruta);
    }

    public FrutaModel getFrutaById(Long id){
        Optional<FrutaModel> optionalFruta = frutaRepository.findById(id);
        return optionalFruta.get();
    }

    public List<FrutaModel> listFrutas(){
        return frutaRepository.findAll();
    }

    public FrutaModel updateById(FrutaModel request, Long id) {
        Optional<FrutaModel> optionalFruta = frutaRepository.findById(id);

        if (optionalFruta.isPresent()) {
            FrutaModel fruta = optionalFruta.get();
            fruta.setNom(request.getNom());
            fruta.setQuantitatQuilos(request.getQuantitatQuilos());
            // Guarda los cambios en la base de datos
            return frutaRepository.save(fruta);
        } else {
            // Manejo de fruta no encontrada, por ejemplo, lanzar una excepción
            throw new FrutaNotFoundException("Fruta con ID " + id + " no encontrada");
        }
    }

    public Boolean deleteFruta(long id) {
        try {
            frutaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
