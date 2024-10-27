package Dch.Group.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.UUID;

@Data
@Table("customers")
public class Customer {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String address;
    private String password; // Hashed password field
    private Boolean isAdmin = false; // Field for admin status
    private Boolean isActive = true; // New field for soft deletion logic
}
