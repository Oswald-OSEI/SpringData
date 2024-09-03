package springdata.springdata.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Document(collection = "departments") // Specify the MongoDB collection name
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Department {
    @Id
    @Field("_id") // Optional: specify a custom field name for the MongoDB Object ID
    private String id; // MongoDB uses String for Object IDs

    @Field("code")
    private String code;

    @Field("building")
    private String building;

    @DBRef // Reference to another document
    @Field("director")
    private Doctor director;

    @DBRef // List of references to Ward documents
    @Field("ward_list")
    private List<Ward> wardList;
}
