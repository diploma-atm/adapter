package kz.diploma.adapter.repository;

import kz.diploma.adapter.model.entity.response.ClientResponse;

import java.util.List;

public interface AdapterRepository {
    ClientResponse getClientByPan(String pan);

    List<ClientResponse> getClientByFio(String surname, String name, String lastname);

    ClientResponse getClientByPhoneNumber(String phoneNumber);

    ClientResponse getClientById(Integer id);
}
