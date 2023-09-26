package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n01.S04T02N01MartinezJoanCarles.repository;

import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n01.S04T02N01MartinezJoanCarles.models.FrutaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFrutaRepository extends JpaRepository<FrutaModel,Long> {

}
