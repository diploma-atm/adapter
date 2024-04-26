package kz.diploma.adapter.model.entity.response;

import kz.diploma.adapter.model.entity.pojo.ClientPojo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientResponse {
    public Integer id;

    public String surname;

    public String name;

    public String lastName;

    public String phoneNumber;

    public Boolean isBlocked;

    public List<ProductResponse> products;

    public ClientResponse(ClientPojo clientPojo) {
        this.id = clientPojo.getId();
        this.surname = clientPojo.getSurname();
        this.name = clientPojo.getName();
        this.lastName = clientPojo.getLastName();
        this.phoneNumber = clientPojo.getPhoneNumber();
        this.isBlocked = clientPojo.getIsBlocked();
    }
}
