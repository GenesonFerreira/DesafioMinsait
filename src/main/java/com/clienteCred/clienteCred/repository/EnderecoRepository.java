package com.clienteCred.clienteCred.repository;

import com.clienteCred.clienteCred.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel,Long> {

}
