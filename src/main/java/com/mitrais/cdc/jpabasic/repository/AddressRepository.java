package com.mitrais.cdc.jpabasic.repository;

import com.mitrais.cdc.jpabasic.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
