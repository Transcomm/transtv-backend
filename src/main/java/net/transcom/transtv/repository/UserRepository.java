package net.transcom.transtv.repository;


import net.transcom.transtv.entities.Role;
import net.transcom.transtv.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    User findByRole(Role role);
}
