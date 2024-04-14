package kz.diploma.adapter.service;

import kz.diploma.adapter.model.entity.ClientEntity;
import kz.diploma.adapter.model.entity.dto.AdminDTO;
import kz.diploma.adapter.model.entity.dto.ClientDTO;
import kz.diploma.adapter.model.entity.dto.ProductDTO;

import java.util.List;

public interface AdapterService {
    Integer addClient(ClientDTO clientDTO);
    void deleteClient(Integer clientId);
    void updateClient(ClientDTO clientDTO, Integer clientId);

    ClientEntity getClientByPan(String pan);

    List<ClientEntity> getClientByFio(String surname, String name, String lastname);

    ClientEntity getClientByPhoneNumber(String phoneNumber);

    void addClient2BlackList(Integer clientId);

    void addClientProduct(Integer clientId);

    void deleteClientProduct(Integer productId);

    void updateClientProduct(ProductDTO productDTO, Integer productId);

    void blockProduct(Integer productId);

    Integer addAdmin(AdminDTO adminDTO);

    void deleteAdmin(Integer adminId);

    void updateAdmin(AdminDTO adminDTO, Integer adminId);


}
