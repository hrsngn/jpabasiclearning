package com.mitrais.cdc.jpabasic.repository;

import com.mitrais.cdc.jpabasic.model.Money;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<Money,Integer> {
}
