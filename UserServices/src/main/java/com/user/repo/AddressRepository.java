package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
