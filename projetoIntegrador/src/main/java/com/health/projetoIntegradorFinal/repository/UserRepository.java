package com.health.projetoIntegradorFinal.repository;

import com.health.projetoIntegradorFinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gui
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    User findByUsername(String username);
    
}
