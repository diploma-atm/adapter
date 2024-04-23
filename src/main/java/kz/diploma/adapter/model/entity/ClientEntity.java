package kz.diploma.adapter.model.entity;

import jakarta.persistence.*;
import kz.diploma.adapter.model.entity.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "sur_name")
    public String surname;

    @Column(name = "name")
    public String name;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "phone_number", unique = true)
    public String phoneNumber;

    @OneToMany(mappedBy = "id")
    public List<ProductEntity> products;

    @OneToMany(mappedBy = "id")
    public List<AccountEntity> accounts;

    @Column(name = "is_blocked")
    public Boolean isBlocked;


    public ClientEntity(ClientDTO clientDTO){
        this.surname = clientDTO.surname;
        this.name = clientDTO.name;
        if(!Objects.isNull(clientDTO.lastName)){
            this.lastName = clientDTO.lastName;
        }
        this.phoneNumber = clientDTO.phoneNumber;
        this.isBlocked = false;
    }
}
