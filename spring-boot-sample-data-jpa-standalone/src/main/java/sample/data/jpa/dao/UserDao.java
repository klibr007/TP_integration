package sample.data.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.User;

// Imports ...

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {
	
}
