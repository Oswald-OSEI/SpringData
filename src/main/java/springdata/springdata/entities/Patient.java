package springdata.springdata.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Patient")
public class Patient extends PersonsInHospital {
    private String name;
    private String patientNumber;
    private String diagnosis;

    @OneToOne
    @JoinColumn(name = "bed")
    private Bed bed;

    @ManyToOne
    @JoinColumn(name = "Doctor")
    private Doctor doctor;

}
