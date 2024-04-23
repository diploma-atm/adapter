package kz.diploma.adapter.service.impl.subservices.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.ClientEntity;
import kz.diploma.adapter.model.entity.ProductEntity;
import kz.diploma.adapter.model.entity.dto.ProductDTO;
import kz.diploma.adapter.repository.ProductRepository;
import kz.diploma.adapter.service.impl.subservices.AccountService;
import kz.diploma.adapter.service.impl.subservices.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final AccountService accountService;


    @Override
    public ProductEntity getById(Integer productId){
        return productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product with this id not found"));
    }

    @Override
    public void blockProduct(Integer productId) {
        var product = getById(productId);

        product.isBlocked = true;
        productRepository.save(product);
    }

    @Override
    public ProductEntity getByPan(String pan) {
        return productRepository.findByPan(pan).orElseThrow(() -> new EntityNotFoundException("Product with this id not found"));
    }

    @Override
    public void addClientProduct(ClientEntity clientEntity) {
        var newProduct = ProductEntity.builder()
                .pin("0000")
                .cvv(generateCVV())
                .pan(generateCard())
                .inAccess(true)
                .outAccess(true)
                .isBlocked(false)
                .rbs(generateRbs())
                .clientEntity(clientEntity)
                .build();

        newProduct = productRepository.save(newProduct);

        newProduct.account = accountService.createAccount(newProduct);

        productRepository.save(newProduct);
    }

    @Override
    public void deleteClientProduct(Integer productId) {
        var product = getById(productId);

        accountService.deleteAccount(product.account.id);
        productRepository.delete(product);
    }

    @Override
    public void updateClientProduct(ProductDTO productDTO, Integer productId) {
        var product = getById(productId);
        product.pin = productDTO.pin;

        productRepository.save(product);
    }

    private String generateCVV(){
        var random = new Random(102);
        var sb = new StringBuilder();

        IntStream.rangeClosed(1, 3)
                .mapToObj(i -> random.nextInt())
                .forEach(sb::append);

        return sb.toString();
    }

    private String generateCard(){
        var i = 0;

        while(true){
            var generatedCardNumber = generateCardNumber(i);
            var cardOpt = productRepository.findByPan(generatedCardNumber);

            if(cardOpt.isEmpty()){
                return generatedCardNumber;
            }

            i++;
        }

    }

    private String generateCardNumber(Integer seed){
        var random = new Random(seed);
        var sb = new StringBuilder();

        IntStream.rangeClosed(1,16)
                .mapToObj(i -> random.nextInt())
                .forEach(sb::append);

        return sb.toString();
    }

    private String generateRbs(){
        //TODO
        return "";
    }
}
