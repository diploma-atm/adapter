package kz.diploma.adapter.model.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "account")
@Builder
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "account_number", unique = true)
    public String accountNumber;

    @Column(name = "amount")
    public Integer amount;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public ProductEntity product;
}
