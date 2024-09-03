package springdata.springdata.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import springdata.springdata.entities.Bed;
import springdata.springdata.entities.Department;
import springdata.springdata.entities.Ward;

import java.util.List;
import java.util.Optional;

public interface BedRepository extends MongoRepository<Bed, String> {
    Optional<Bed> findByBedNumber(String bedNumber);

    List<Bed> findAllByWard(Ward ward);

    List<Bed> findAllByWardDepartment(Department department);
}
