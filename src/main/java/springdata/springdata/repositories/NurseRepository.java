package springdata.springdata.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springdata.springdata.entities.Department;
import springdata.springdata.entities.Nurse;

import java.util.List;

@Repository
public interface NurseRepository extends MongoRepository<Nurse, String> {
    List<Nurse> findAllBySurname(String surname);
    List<Nurse> findAllByRotation(String rotation);
    List<Nurse> findAllByFirstName(String firstName);
    List<Nurse> findAllByDepartment_Id(String departmentId);
}
