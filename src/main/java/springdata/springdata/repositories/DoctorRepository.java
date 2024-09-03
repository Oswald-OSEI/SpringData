package springdata.springdata.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springdata.springdata.entities.Doctor;

import java.util.List;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
    List<Doctor> findAllBySpecialty(String specialty);
    List<Doctor> findAllBySurname(String surname);
    List<Doctor> findBySpecialtyAndSurname(String specialty, String surname);
}
