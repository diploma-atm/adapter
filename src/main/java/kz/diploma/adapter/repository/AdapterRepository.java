package kz.diploma.adapter.repository;

import kz.diploma.adapter.model.entity.response.client.ClientClientResponse;
import kz.diploma.adapter.model.entity.response.product.ProductProductResponse;

import java.util.List;

public interface AdapterRepository {
    ClientClientResponse getClientByPan(String pan);

    List<ClientClientResponse> getClientByFio(String surname, String name, String lastname);

    ClientClientResponse getClientByPhoneNumber(String phoneNumber);

    ClientClientResponse getClientById(Integer id);

    ProductProductResponse getProductById(Integer id);
}
