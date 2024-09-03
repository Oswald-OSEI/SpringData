package springdata.springdata.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "PersonsInHospital")
@AllArgsConstructor
@NoArgsConstructor
public class PersonsInHospital {

    @Id
    private String id;  // Use String for MongoDB's ObjectId

    @Field("surname")
    private String surname;

    @Field("address")
    private String address;

    @Field("tel_number")
    private String telNumber;

    @Field("PersonType")
    private String PersonType;
}
