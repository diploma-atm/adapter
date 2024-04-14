package kz.diploma.adapter.service.impl.subservices.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.ClientEntity;
import kz.diploma.adapter.model.entity.dto.ClientDTO;
import kz.diploma.adapter.repository.ClientRepository;
import kz.diploma.adapter.service.impl.subservices.ClientService;
import kz.diploma.adapter.service.impl.subservices.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ProductService productService;

    @Override
    public void addClient2BlackList(Integer clientId) {
        var client = getClientById(clientId);
        client.isBlocked = true;

        clientRepository.save(client);
    }

    @Override
    public ClientEntity getClientById(Integer clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new EntityNotFoundException("Client with this id not found"));
    }

    @Override
    public Integer addClient(ClientDTO clientDTO) {
        var clientEntity = new ClientEntity(clientDTO);

        return clientRepository.save(clientEntity).id;
    }

    @Override
    public void deleteClient(Integer clientId) {
        var client = getClientById(clientId);

        clientRepository.delete(client);
    }

    @Override
    public void updateClient(ClientDTO clientDTO, Integer clientId) {
        var client = getClientById(clientId);


        updateClient(clientDTO, client);
        clientRepository.save(client);
    }

    private void updateClient(ClientDTO clientDTO, ClientEntity clientEntity) {
        clientEntity.surname = clientDTO.surname;
        clientEntity.name = clientDTO.name;
        clientEntity.phoneNumber = clientDTO.phoneNumber;
        if(!Objects.isNull(clientDTO.lastName)) {
            clientEntity.lastName = clientDTO.lastName;
        }
    }


    @Override
    public ClientEntity getClientByPan(String pan) {
        var product = productService.getByPan(pan);

        return getClientById(product.clientEntity.id);
    }

    @Override
    public List<ClientEntity> getClientByFio(String surname, String name, String lastname) {
        return clientRepository.findClientByFio(surname, name, lastname);
    }

    @Override
    public ClientEntity getClientByPhoneNumber(String phoneNumber) {
        var client = clientRepository.findClientByPhoneNumber(phoneNumber);

        if(client.isPresent()){
            return client.get();
        } else{
            throw new EntityNotFoundException("Client with this phone number not found");
        }
    }
}
