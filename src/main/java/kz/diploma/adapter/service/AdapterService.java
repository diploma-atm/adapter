package kz.diploma.adapter.service;

import kz.diploma.adapter.model.entity.response.admin.AdminResponse;
import kz.diploma.adapter.model.entity.response.client.ClientClientResponse;
import kz.diploma.adapter.model.entity.response.client.ClientResponse;
import kz.diploma.adapter.model.entity.response.product.ProductProductResponse;
import kz.diploma.library.shared.model.entity.ClientEntity;

import java.util.List;

public interface AdapterService {
    ClientClientResponse getClientByPan(String pan);

    List<ClientClientResponse> getClientByFio(String surname, String name, String lastname);

    ClientClientResponse getClientByPhoneNumber(String phoneNumber);

    ClientClientResponse getClientById(Integer id);

    ProductProductResponse getProductById(Integer productId);

    ProductProductResponse getProductByPan(String pan);

    List<AdminResponse> getAllAdmins();

    AdminResponse getAdminById(Integer id);

    List<ClientResponse> getAllClients();

    AdminResponse getAdminByPhoneNumber(String phoneNumber);
}
