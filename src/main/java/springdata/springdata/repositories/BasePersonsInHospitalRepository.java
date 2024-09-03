package springdata.springdata.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import springdata.springdata.entities.PersonsInHospital;

import java.util.List;

@NoRepositoryBean
public interface BasePersonsInHospitalRepository<T extends PersonsInHospital> extends MongoRepository<T, String> {
    List<T> findAllBySurname(String surname);
}
