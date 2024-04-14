package kz.diploma.adapter.service.impl.subservices;

import kz.diploma.adapter.model.entity.AccountEntity;
import kz.diploma.adapter.model.entity.ProductEntity;

public interface AccountService {
    AccountEntity createAccount(ProductEntity product);
    void deleteAccount(Integer accountId);
}
