package springdata.springdata.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Patient")
public class Patient extends PersonsInHospital {
    private String name;
    private String patientNumber;
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "bed")
    private Bed bed;

    @OneToOne
    @JoinColumn(name = "Doctor")
    private Doctor doctor;

}
