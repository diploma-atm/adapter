package kz.diploma.adapter.service.impl;

import kz.diploma.adapter.model.entity.response.client.ClientClientResponse;
import kz.diploma.adapter.model.entity.response.product.ProductProductResponse;
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
    public ClientClientResponse getClientByPan(String pan) {
        return repository.getClientByPan(pan);
    }

    @Override
    public List<ClientClientResponse> getClientByFio(String surname, String name, String lastname) {
        return repository.getClientByFio(surname, name, lastname);
    }

    @Override
    public ClientClientResponse getClientByPhoneNumber(String phoneNumber) {
        return repository.getClientByPhoneNumber(phoneNumber);
    }

    @Override
    public ClientClientResponse getClientById(Integer id) {
        return repository.getClientById(id);
    }

    @Override
    public ProductProductResponse getProductById(Integer productId) {
        return repository.getProductById(productId);
    }

    @Override
    public ProductProductResponse getProductByPan(String pan) {
        return repository.getProductByPan(pan);
    }
}
