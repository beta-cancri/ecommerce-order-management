package Dch.Group.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class CustomerDTO {
    private UUID id;
    private String name;
    private String email;
    private String address;
    private Boolean isAdmin; // Added field for admin status
    private Boolean isActive; // Added field for active status
    // No password field here for security
}
