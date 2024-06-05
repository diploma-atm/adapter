package kz.diploma.adapter.controller;

import kz.diploma.adapter.model.entity.response.admin.AdminResponse;
import kz.diploma.adapter.model.entity.response.client.ClientClientResponse;
import kz.diploma.adapter.model.entity.response.product.ProductProductResponse;
import kz.diploma.adapter.service.AdapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adapter")
@CrossOrigin
public class AdapterController {
    private final AdapterService adapterService;

    //CLIENT
    @GetMapping("/client/pan")
    public ResponseEntity<ClientClientResponse> getClient(String pan){
        var clientResponse = adapterService.getClientByPan(pan);

        return ResponseEntity.ok(clientResponse);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientClientResponse> getClient(@PathVariable(name = "id") Integer id){
        var clientResponse = adapterService.getClientById(id);

        return ResponseEntity.ok(clientResponse);
    }

    @GetMapping("/client/phone-number")
    public ResponseEntity<ClientClientResponse> getClientByPhoneNumber(String phoneNumber){
        var clientResponse = adapterService.getClientByPhoneNumber(phoneNumber);

        return ResponseEntity.ok(clientResponse);
    }

    @GetMapping("/client/fio")
    public ResponseEntity<List<ClientClientResponse>> getClientByFio(String surname, String name, String lastname){
        var clientResponse = adapterService.getClientByFio(surname, name, lastname);

        return ResponseEntity.ok(clientResponse);
    }

    //PRODUCT
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductProductResponse> getProductById(@PathVariable(name = "id") Integer id){
        var productResponse = adapterService.getProductById(id);

        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/product/pan/{pan}")
    public ResponseEntity<ProductProductResponse> getProductByPan(@PathVariable(name = "pan") String pan){
        var productResponse = adapterService.getProductByPan(pan);

        return ResponseEntity.ok(productResponse);
    }


    @GetMapping("/admin")
    public ResponseEntity<List<AdminResponse>> getAllAdmins(){
        var adminResponse = adapterService.getAllAdmins();

        return ResponseEntity.ok(adminResponse);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminResponse> getAdminById(@PathVariable(name = "id") Integer id){
        var adminResponse = adapterService.getAdminById(id);

        return ResponseEntity.ok(adminResponse);
    }
}