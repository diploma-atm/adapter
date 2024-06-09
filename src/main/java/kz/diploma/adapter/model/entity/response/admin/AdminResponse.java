package kz.diploma.adapter.model.entity.response.admin;

public record AdminResponse(
        Integer id,
        String surname,
        String name,
        String lastname,
        String phoneNumber,
        String post,
        String registration,
        String password
) {
}
