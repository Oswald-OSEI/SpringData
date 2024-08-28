package springdata.springdata.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Doctor")
public class Doctor extends  Employee {
    private String specialty;

    public void setEmployeeType(){
        this.setEmployeeType("Doctor");
    }

}
