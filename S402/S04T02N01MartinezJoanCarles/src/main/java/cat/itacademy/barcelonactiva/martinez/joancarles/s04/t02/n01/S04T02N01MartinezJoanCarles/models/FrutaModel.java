package cat.itacademy.barcelonactiva.martinez.joancarles.s04.t02.n01.S04T02N01MartinezJoanCarles.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="fruta")
@Getter
@Setter
public class FrutaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nom;
    @Column
    private int quantitatQuilos;
}
