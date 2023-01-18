package hello.springmvc.first.DTO;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirstDTO {

    private Integer id;

    @NotEmpty
    private String name;
}
