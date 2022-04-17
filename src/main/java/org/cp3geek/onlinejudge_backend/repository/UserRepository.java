package org.cp3geek.onlinejudge_backend.repository;

import org.cp3geek.onlinejudge_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserName(String userName);
}
