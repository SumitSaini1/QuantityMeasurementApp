package quantitymeasurement.dto;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    
}
