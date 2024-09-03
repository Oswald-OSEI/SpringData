package springdata.springdata.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springdata.springdata.entities.Department;
import springdata.springdata.entities.Doctor;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    Optional<Department> findByCode(String code);

    // For finding by director, you might need to use a custom query method
    Optional<Department> findByDirector_Id(String doctorId);
}
