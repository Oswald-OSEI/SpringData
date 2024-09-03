package springdata.springdata.dtos;

import lombok.*;
import springdata.springdata.entities.Ward;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BedDto {
    private String id;
    private String bedNumber;
    private Ward ward;
}
