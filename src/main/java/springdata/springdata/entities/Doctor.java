package springdata.springdata.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "PersonsInHospital") // Specify the MongoDB collection name
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Doctor extends Employee {
    @Field("specialty")
    private String specialty;

    public void setEmployeeType(){
        this.setEmployeeType("Doctor");
    }

}
