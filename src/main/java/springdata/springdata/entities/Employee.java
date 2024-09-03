package springdata.springdata.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "PersonsInHospital") // Specify the MongoDB collection name
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends  PersonsInHospital {
    @Field("first_name") // Optional: specify a custom field name
    private String firstName;

    @Field("employee_id")
    private String employeeId;

    @Field("employee_type")
    private String employeeType;
}
