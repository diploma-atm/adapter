package kz.diploma.adapter.model.entity;

import jakarta.persistence.*;
import kz.diploma.adapter.model.entity.dto.AdminDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@AllArgsConstructor
@NoArgsConstructor
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "sur_name")
    public String surname;

    @Column(name = "name")
    public String name;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "phone_number")
    public String phoneNumber;

    @Column(name = "post")
    public String post;

    @Column(name = "registration")
    public String registration;

    public AdminEntity(AdminDTO adminDTO){
        this.surname = adminDTO.surname;
        this.name = adminDTO.name;
        this.lastName = adminDTO.lastName;
        this.phoneNumber = adminDTO.phoneNumber;
        this.post = adminDTO.post;
        this.registration = adminDTO.registration;
    }
}
