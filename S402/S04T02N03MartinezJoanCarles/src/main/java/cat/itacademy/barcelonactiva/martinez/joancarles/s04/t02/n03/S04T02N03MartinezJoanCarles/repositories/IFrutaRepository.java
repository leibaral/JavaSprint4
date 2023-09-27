package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n03.S04T02N03MartinezJoanCarles.repositories;

import cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n03.S04T02N03MartinezJoanCarles.models.FrutaModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IFrutaRepository extends MongoRepository<FrutaModel, ObjectId> {

}
