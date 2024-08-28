package springdata.springdata.entities;

import jakarta.persistence.*;

@Entity
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String bedNumber;

    @ManyToOne
    @JoinColumn(name= "ward")
    private Ward ward;
}
