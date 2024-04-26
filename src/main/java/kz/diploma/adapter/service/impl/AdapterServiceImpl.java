package kz.diploma.adapter.service.impl;

import kz.diploma.adapter.model.entity.response.ClientResponse;
import kz.diploma.adapter.repository.AdapterRepository;
import kz.diploma.adapter.service.AdapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdapterServiceImpl implements AdapterService {
    private final AdapterRepository repository;

    @Override
    public ClientResponse getClientByPan(String pan) {
        return repository.getClientByPan(pan);
    }

    @Override
    public List<ClientResponse> getClientByFio(String surname, String name, String lastname) {
        return repository.getClientByFio(surname, name, lastname);
    }

    @Override
    public ClientResponse getClientByPhoneNumber(String phoneNumber) {
        return repository.getClientByPhoneNumber(phoneNumber);
    }

    @Override
    public ClientResponse getClientById(Integer id) {
        return repository.getClientById(id);
    }
}
