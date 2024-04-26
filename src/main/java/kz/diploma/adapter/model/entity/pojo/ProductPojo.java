package kz.diploma.adapter.model.entity.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductPojo {
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
}
