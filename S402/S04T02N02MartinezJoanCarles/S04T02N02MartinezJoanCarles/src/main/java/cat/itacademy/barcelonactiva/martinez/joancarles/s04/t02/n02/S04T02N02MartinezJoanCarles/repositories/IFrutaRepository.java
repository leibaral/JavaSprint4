package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n02.S04T02N02MartinezJoanCarles.repositories;

import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n02.S04T02N02MartinezJoanCarles.models.FrutaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFrutaRepository extends JpaRepository<FrutaModel, Long> {

}
