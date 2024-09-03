package springdata.springdata.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springdata.springdata.entities.PersonsInHospital;

import java.util.List;

@Repository
public interface AllPersonsInHospitalRepository extends MongoRepository<PersonsInHospital, String> {
    List<PersonsInHospital> findAllBySurname(String surname);
    List<PersonsInHospital> findAllByAddress(String address);
}
