package org.hdcola.carnet.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hdcola.carnet.Validation.Vin;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 17, max = 17, message = "VIN must be 17 characters")
    @Vin(message = "VIN must be valid")
    @Column(nullable = false, unique = true)
    private String VIN;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String make;
    private String model;
    private int year;
}
