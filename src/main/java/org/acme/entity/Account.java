package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account extends PanacheEntity {

    @NotNull
    @Column(nullable = false, unique = true)
    public String accountNumber;

    @Column(name = "customer_id", nullable = false)
    public Long customerId;

    @NotNull
    @Column(nullable = false)
    public BigDecimal balance;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public AccountType type;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public AccountStatus status;


}
