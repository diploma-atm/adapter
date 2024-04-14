package kz.diploma.adapter.service.impl.subservices.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.AccountEntity;
import kz.diploma.adapter.model.entity.ProductEntity;
import kz.diploma.adapter.repository.AccountRepository;
import kz.diploma.adapter.service.impl.subservices.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public AccountEntity createAccount(ProductEntity product) {
        var newAccount = AccountEntity.builder()
                .accountNumber(generateAccount())
                .amount(0)
                .product(product)
                .build();


        return accountRepository.save(newAccount);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        var account = accountRepository.findById(accountId).orElseThrow(() -> new EntityNotFoundException("Account with this id not found"));
        accountRepository.delete(account);
    }

    private String generateAccount(){
        var i = 0;

        while(true){
            var generatedCardNumber = generateAccountNumber(i);
            var account = accountRepository.findByAccountNumber(generatedCardNumber);

            if(account.isEmpty()){
                return generatedCardNumber;
            }

            i++;
        }
    }

    private String generateAccountNumber(Integer seed){
        var random = new Random(seed);
        var sb = new StringBuilder();
        sb.append("KZ");
        IntStream.rangeClosed(1,10)
                .mapToObj(i -> random.nextInt())
                .forEach(sb::append);

        return sb.toString();
    }
}
