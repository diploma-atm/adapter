package kz.diploma.adapter.model.entity.response.product;

import kz.diploma.adapter.model.entity.pojo.ProductPojo;
import kz.diploma.adapter.model.entity.response.AccountResponse;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProductProductResponse {
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

    public LocalDate expiredDate;

    public ProductClientResponse clientResponse;

    public AccountResponse accountResponse;

    public ProductProductResponse(ProductPojo productPojo) {
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
        this.expiredDate = productPojo.getExpiredDate();
    }
}
