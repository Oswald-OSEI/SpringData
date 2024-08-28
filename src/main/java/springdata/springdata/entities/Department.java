package springdata.springdata.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private String building;

    @OneToOne
    @JoinColumn(name = "director")
    private Doctor director;

    @OneToMany(mappedBy = "department")
    private List<Ward> wardList;
}
