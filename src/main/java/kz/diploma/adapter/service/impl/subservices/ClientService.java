package kz.diploma.adapter.service.impl.subservices;

import kz.diploma.adapter.model.entity.ClientEntity;
import kz.diploma.adapter.model.entity.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    void addClient2BlackList(Integer clientId);
    ClientEntity getClientById(Integer clientId);
    Integer addClient(ClientDTO clientDTO);
    void deleteClient(Integer clientId);
    void updateClient(ClientDTO clientDTO, Integer clientId);

    ClientEntity getClientByPan(String pan);

    List<ClientEntity> getClientByFio(String surname, String name, String lastname);

    ClientEntity getClientByPhoneNumber(String phoneNumber);
}
