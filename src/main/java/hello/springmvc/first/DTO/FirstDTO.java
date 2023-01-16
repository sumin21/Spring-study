package hello.springmvc.first.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirstDTO {

    private Integer id;

    @NotEmpty
    private String name;
}
