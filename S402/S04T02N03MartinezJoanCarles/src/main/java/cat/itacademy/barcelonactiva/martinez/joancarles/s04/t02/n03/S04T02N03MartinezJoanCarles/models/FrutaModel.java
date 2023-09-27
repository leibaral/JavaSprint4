package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n03.S04T02N03MartinezJoanCarles.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
@ToString
@Document(collection = "fruta")
public class FrutaModel {
    @Id
    @Field("id")
    private ObjectId id;
    private String nom;
    private int quantitatQuilos;
}
