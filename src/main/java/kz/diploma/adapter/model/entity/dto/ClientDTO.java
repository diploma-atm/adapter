package kz.diploma.adapter.model.entity.dto;

import kz.diploma.adapter.model.entity.ClientEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class ClientDTO {
    public String surname;
    public String name;
    public String lastName;
    public String phoneNumber;

    public ClientDTO(ClientEntity clientEntity){
        this.surname = clientEntity.surname;
        this.name = clientEntity.name;
        if(!Objects.isNull(lastName)){
            this.lastName = clientEntity.lastName;
        }
        this.phoneNumber = clientEntity.phoneNumber;
    }
}
