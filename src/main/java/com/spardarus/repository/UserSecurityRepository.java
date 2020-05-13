package com.spardarus.repository;

import com.spardarus.entity.UserSecurity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecurityRepository extends CrudRepository<UserSecurity, Integer> {

    UserSecurity findByEmail(String email);
}
