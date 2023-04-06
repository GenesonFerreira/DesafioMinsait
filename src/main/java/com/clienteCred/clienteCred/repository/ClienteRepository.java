package com.clienteCred.clienteCred.repository;

import com.clienteCred.clienteCred.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel,String> {

}
