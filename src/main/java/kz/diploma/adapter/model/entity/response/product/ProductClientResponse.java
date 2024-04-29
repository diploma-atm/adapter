package kz.diploma.adapter.model.entity.response.product;

import lombok.Data;

@Data
public class ProductClientResponse {
    public Integer id;

    public String surname;

    public String name;

    public String lastName;

    public String phoneNumber;

    public Boolean isBlocked;
}
