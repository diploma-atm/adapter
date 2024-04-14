package kz.diploma.adapter.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "product")
@AllArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "pan")
    public String pan;

    @Column(name = "pin")
    public String pin;

    @Column(name = "cvv")
    public String cvv;

    @OneToOne(mappedBy = "product")
    public AccountEntity account;

    @Column(name = "rbs")
    public String rbs;

    @Column(name = "active")
    public Boolean active;

    @Column(name = "in_access")
    public Boolean inAccess;

    @Column(name = "out_access")
    public Boolean outAccess;

    @Column(name = "is_blocked")
    public Boolean isBlocked;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    public ClientEntity clientEntity;

}
