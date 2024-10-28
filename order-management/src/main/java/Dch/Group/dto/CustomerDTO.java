package Dch.Group.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class CustomerDTO {
    private UUID id;
    private String name;
    private String email;
    private String address;
    private Boolean isAdmin; 
    private Boolean isActive; 
    // No password field here for security
}
