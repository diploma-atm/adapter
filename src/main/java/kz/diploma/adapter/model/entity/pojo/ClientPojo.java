package kz.diploma.adapter.model.entity.pojo;

import lombok.Data;

@Data
public class ClientPojo {
    public Integer id;

    public String surname;

    public String name;

    public String lastName;

    public String phoneNumber;

    public Boolean isBlocked;
}
