package springdata.springdata.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "PersonsInHospital")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient extends PersonsInHospital {
    @Field("name")
    private String name;

    @Field("patient_number")
    private String patientNumber;

    @Field("diagnosis")
    private String diagnosis;

    @DBRef
    @Field("bed")
    private Bed bed;

    @DBRef
    @Field("doctor")
    private Doctor doctor;
}
