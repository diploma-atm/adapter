package kz.diploma.adapter.service.impl.subservices.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.AdminEntity;
import kz.diploma.adapter.model.entity.dto.AdminDTO;
import kz.diploma.adapter.repository.AdminRepository;
import kz.diploma.adapter.service.impl.subservices.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public Integer addAdmin(AdminDTO adminDTO) {
        var admin = new AdminEntity(adminDTO);
        return adminRepository.save(admin).id;
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        var admin = getById(adminId);
        adminRepository.delete(admin);
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO, Integer adminId) {
        var admin = getById(adminId);
        admin.post = adminDTO.post;
        admin.name = adminDTO.name;
        admin.lastName = adminDTO.lastName;
        admin.surname = adminDTO.surname;
        admin.phoneNumber = adminDTO.phoneNumber;
        admin.registration = adminDTO.registration;

        adminRepository.save(admin);
    }

    @Override
    public AdminEntity getById(Integer adminId){
        return adminRepository.findById(adminId).orElseThrow(() -> new EntityNotFoundException("Admin with this id not found"));
    }
}
