package io.github.jass2125.beer.api.user.repository;

import io.github.jass2125.beer.api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

    public boolean existsByUsername(String username);
    
}
