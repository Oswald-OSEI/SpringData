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

@Document(collection = "wards") // Specify the MongoDB collection name
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Ward {
    @Id

    @Field("_id") // Optional: specify a custom field name for the MongoDB Object ID
    private String id; // MongoDB uses String for Object IDs

    @DBRef // Reference to a Department document
    @Field("department")
    private Department department;

    @DBRef // Reference to a Nurse document
    @Field("supervisor")
    private Nurse supervisor;

    @Field("ward_number")
    private long wardNumber;

    @DBRef // List of references to Bed documents
    @Field("bed_list")
    private List<Bed> bedList;
}
