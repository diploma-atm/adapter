package kz.diploma.adapter.repository.impl;

import kz.diploma.adapter.model.entity.response.client.ClientClientResponse;
import kz.diploma.adapter.model.entity.response.product.ProductProductResponse;
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
    public ClientClientResponse getClientByPan(String pan) {
        return adapterByPanRepository.findByPan(pan);
    }

    @Override
    public List<ClientClientResponse> getClientByFio(String surname, String name, String lastname) {
        return adapterByFioRepository.getClientByFio(surname, name, lastname);
    }

    @Override
    public ClientClientResponse getClientByPhoneNumber(String phoneNumber) {
        return adapterByPhoneNumberRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public ClientClientResponse getClientById(Integer id) {
        return adapterByIdRepository.getClientById(id);
    }

    @Override
    public ProductProductResponse getProductById(Integer id) {
        return adapterByIdRepository.getProductById(id);
    }
}
