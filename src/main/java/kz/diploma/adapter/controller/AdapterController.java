package kz.diploma.adapter.controller;

import kz.diploma.adapter.model.entity.dto.AdminDTO;
import kz.diploma.adapter.model.entity.dto.ClientDTO;
import kz.diploma.adapter.model.entity.dto.ProductDTO;
import kz.diploma.adapter.service.AdapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adapter")
@RequiredArgsConstructor
public class AdapterController {
    private final AdapterService adapterService;

    //CLIENT
    @PostMapping("/client/save")
    public ResponseEntity<String> saveClient(@RequestBody ClientDTO clientDTO){
        adapterService.addClient(clientDTO);

        return ResponseEntity.ok("Save client finished successfully");
    }

    @DeleteMapping("/client/delete")
    public ResponseEntity<String> deleteClient(@RequestParam(name = "client_id") Integer clientId){
        adapterService.deleteClient(clientId);

        return ResponseEntity.ok("Delete client finished successfully");
    }

    @PutMapping("/client/update")
    public ResponseEntity<String> updateClient(@RequestBody ClientDTO clientDTO, @RequestParam(name = "client_id") Integer clientId){
        adapterService.updateClient(clientDTO, clientId);

        return ResponseEntity.ok("Update client finished successfully");
    }

    @GetMapping("/client/pan")
    public ResponseEntity<ClientDTO> getClient(String pan){
        var entity = adapterService.getClientByPan(pan);
        var clientDTO = new ClientDTO(entity);

        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping("/client/phone-number")
    public ResponseEntity<ClientDTO> getClientByPhoneNumber(String phoneNumber){
        var entity = adapterService.getClientByPhoneNumber(phoneNumber);
        var clientDTO = new ClientDTO(entity);

        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping("/client/fio")
    public ResponseEntity<List<ClientDTO>> getClientByPhoneNumber(String surname, String name, String lastname){
        var entities = adapterService.getClientByFio(surname, name, lastname);
        var response = entities.stream().map(ClientDTO::new).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/client/ban")
    public ResponseEntity<String> addClient2BlackList(@RequestParam(name = "clientId") Integer clientId){
        adapterService.addClient2BlackList(clientId);

        return ResponseEntity.ok("Add client to black list was successfully");
    }


    //PRODUCT
    @PostMapping("/product/save")
    public ResponseEntity<String> addProduct(@RequestParam(name = "clientId") Integer clientId){
        adapterService.addClientProduct(clientId);

        return ResponseEntity.ok("Add product to black list was successfully");
    }

    @DeleteMapping("/product/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam(name = "product_id") Integer productId){
        adapterService.deleteClientProduct(productId);

        return ResponseEntity.ok("Delete client finished successfully");
    }

    @PutMapping("/product/update")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO, @RequestParam(name = "client_id") Integer productId){
        adapterService.updateClientProduct(productDTO, productId);

        return ResponseEntity.ok("Update client finished successfully");
    }

    @GetMapping("/product/ban")
    public ResponseEntity<String> banProduct(@RequestParam(name = "productId") Integer productId){
        adapterService.blockProduct(productId);

        return ResponseEntity.ok("Add client to black list was successfully");
    }


    //ADMIN
    @PostMapping("/admin/save")
    public ResponseEntity<String> saveClient(@RequestBody AdminDTO adminDTO){
        adapterService.addAdmin(adminDTO);

        return ResponseEntity.ok("Save client finished successfully");
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<String> deleteAdmin(@RequestParam(name = "admin_id") Integer adminId){
        adapterService.deleteClient(adminId);

        return ResponseEntity.ok("Delete client finished successfully");
    }

    @PutMapping("/admin/update")
    public ResponseEntity<String> updateClient(@RequestBody AdminDTO adminDTO, @RequestParam(name = "admin_id") Integer adminId){
        adapterService.updateAdmin(adminDTO, adminId);

        return ResponseEntity.ok("Update client finished successfully");
    }
}