package springdata.springdata.redisCRUD;

import lombok.*;
import springdata.springdata.entities.Ward;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RedisBedDto {
    private String id;
    private String bedNumber;
    private String ward;
}
