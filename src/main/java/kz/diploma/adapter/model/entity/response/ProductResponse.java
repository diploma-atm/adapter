package kz.diploma.adapter.model.entity.response;

import kz.diploma.adapter.model.entity.pojo.ProductPojo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductResponse {
    public Integer id;

    public LocalDateTime createdAt;

    public String pan;

    public String pin;

    public String cvv;

    public String rbs;

    public Boolean active;

    public Boolean inAccess;

    public Boolean outAccess;

    public Boolean isBlocked;

    public AccountResponse accountResponse;

    public ProductResponse(ProductPojo productPojo) {
        this.id = productPojo.getId();
        this.createdAt = productPojo.getCreatedAt();
        this.pan = productPojo.getPan();
        this.pin = productPojo.getPin();
        this.cvv = productPojo.getCvv();
        this.rbs = productPojo.getRbs();
        this.active = productPojo.getActive();
        this.inAccess = productPojo.getInAccess();
        this.outAccess = productPojo.getOutAccess();
        this.isBlocked = productPojo.getIsBlocked();
    }
}
