package com.eric.demo.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eric.demo.domain.login;

@Repository
public interface loginrepo extends JpaRepository<login, String> {
    login findByUsernameAndPassword(String username, String password);
}
