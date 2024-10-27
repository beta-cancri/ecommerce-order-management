package Dch.Group.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("products")
public class Product {
    @Id
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
}
