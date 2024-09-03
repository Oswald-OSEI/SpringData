package springdata.springdata.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
public class Nurse extends Employee {
    @Field("rotation")
    private String rotation;

    @Field("salary")
    private String salary;

    @DBRef // Reference to a Department document
    @Field("department")
    private Department department;

    public void setEmployeeType(){
        this.setEmployeeType("Nurse");
    }
}
