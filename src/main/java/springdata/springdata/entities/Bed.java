package springdata.springdata.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection = "Bed")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bed {
    @Id
    @Field("id")
    private String id;

    @Field("bed_number")
    private String bedNumber;

    @DBRef
    @Field("ward")
    private Ward ward;
}
