package kz.diploma.adapter.service.impl.subservices;

import kz.diploma.adapter.model.entity.AdminEntity;
import kz.diploma.adapter.model.entity.dto.AdminDTO;

public interface AdminService {
    AdminEntity getById(Integer adminId);

    Integer addAdmin(AdminDTO adminDTO);

    void deleteAdmin(Integer adminId);

    void updateAdmin(AdminDTO adminDTO, Integer adminId);
}
