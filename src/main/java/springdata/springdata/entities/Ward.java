package springdata.springdata.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @OneToOne
    @JoinColumn(name = "supervisor")
    private Nurse supervisor;

    private long wardNumber;

    @OneToMany(mappedBy = "ward")
    private List<Bed> bedList;
}
