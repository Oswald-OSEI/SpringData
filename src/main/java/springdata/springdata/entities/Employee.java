package springdata.springdata.entities;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@DiscriminatorValue("Employee")
@Setter
public class Employee extends PersonsInHospital {
    private String firstName;
    private String employeeId;
    private String employeeType;
}
