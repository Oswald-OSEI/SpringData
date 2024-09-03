package springdata.springdata.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springdata.springdata.entities.Bed;
import springdata.springdata.entities.Patient;
import springdata.springdata.entities.Ward;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findAllByDiagnosis(String diagnosis);
    List<Patient> findAllBySurname(String surname);
    List<Patient> findAllByName(String firstName);
    List<Patient> findAllByBed_Id(String bedId);
    Optional<Patient> findByBed_Id(String bedId);
    List<Patient> findAllByBed_Ward_Id(String wardId);
}
