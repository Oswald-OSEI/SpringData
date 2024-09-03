package springdata.springdata.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springdata.springdata.entities.Department;
import springdata.springdata.entities.Nurse;
import springdata.springdata.entities.Ward;

import java.util.List;
import java.util.Optional;

@Repository
public interface WardRepository extends MongoRepository<Ward, String> {
    List<Ward> findAllByDepartment_Id(String departmentId);
    List<Ward> findAllByDepartment_Code(String departmentCode);
    Optional<Ward> findBySupervisor_Id(String nurseId);
}
