package kz.diploma.adapter.repository.impl;

import kz.diploma.adapter.model.entity.response.ClientResponse;
import kz.diploma.adapter.repository.AdapterRepository;
import kz.diploma.adapter.repository.impl.subrepository.AdapterByFioRepository;
import kz.diploma.adapter.repository.impl.subrepository.AdapterByIdRepository;
import kz.diploma.adapter.repository.impl.subrepository.AdapterByPanRepository;
import kz.diploma.adapter.repository.impl.subrepository.AdapterByPhoneNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdapterRepositoryImpl implements AdapterRepository {
    private final AdapterByPanRepository adapterByPanRepository;
    private final AdapterByPhoneNumberRepository adapterByPhoneNumberRepository;
    private final AdapterByFioRepository adapterByFioRepository;
    private final AdapterByIdRepository adapterByIdRepository;

    @Override
    public ClientResponse getClientByPan(String pan) {
        return adapterByPanRepository.findByPan(pan);
    }

    @Override
    public List<ClientResponse> getClientByFio(String surname, String name, String lastname) {
        return adapterByFioRepository.getClientByFio(surname, name, lastname);
    }

    @Override
    public ClientResponse getClientByPhoneNumber(String phoneNumber) {
        return adapterByPhoneNumberRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public ClientResponse getClientById(Integer id) {
        return adapterByIdRepository.getClientById(id);
    }
}
