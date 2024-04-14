package kz.diploma.adapter.service.impl.subservices;

import kz.diploma.adapter.model.entity.ClientEntity;
import kz.diploma.adapter.model.entity.ProductEntity;
import kz.diploma.adapter.model.entity.dto.ProductDTO;

public interface ProductService {
    ProductEntity getById(Integer productId);

    void blockProduct(Integer productId);

    ProductEntity getByPan(String pan);

    void addClientProduct(ClientEntity clientEntity);

    void deleteClientProduct(Integer productId);

    void updateClientProduct(ProductDTO productDTO, Integer productId);
}
