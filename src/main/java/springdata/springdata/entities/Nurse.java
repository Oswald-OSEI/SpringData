package springdata.springdata.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("Nurse")
public class Nurse extends  Employee{
private String rotation;
private String salary;

@OneToOne
@JoinColumn(name = "Department")
private Department department;


public void setEmployeeType(){
    this.setEmployeeType("Nurse");
    }
}
