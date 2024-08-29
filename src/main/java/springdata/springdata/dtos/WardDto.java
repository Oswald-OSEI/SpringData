package springdata.springdata.dtos;

import jakarta.persistence.*;
import springdata.springdata.entities.Bed;
import springdata.springdata.entities.Department;
import springdata.springdata.entities.Nurse;

import java.util.List;

public class WardDto {

    private long id;


    private Department department;

    private Nurse supervisor;

    private long wardNumber;


    private List<Bed> bedList;
}
