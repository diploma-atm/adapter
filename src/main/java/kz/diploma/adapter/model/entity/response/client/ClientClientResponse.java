package kz.diploma.adapter.model.entity.response.client;

import kz.diploma.adapter.model.entity.pojo.ClientPojo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientClientResponse {
    public Integer id;

    public String surname;

    public String name;

    public String lastName;

    public String phoneNumber;

    public Boolean isBlocked;

    public List<ClientProductResponse> products;

    public ClientClientResponse(ClientPojo clientPojo) {
        this.id = clientPojo.getId();
        this.surname = clientPojo.getSurname();
        this.name = clientPojo.getName();
        this.lastName = clientPojo.getLastName();
        this.phoneNumber = clientPojo.getPhoneNumber();
        this.isBlocked = clientPojo.getIsBlocked();
    }
}
