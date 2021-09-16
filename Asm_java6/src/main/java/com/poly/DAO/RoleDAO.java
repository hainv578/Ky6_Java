package com.poly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.Entity.Account;
import com.poly.Entity.Role;

public interface RoleDAO extends JpaRepository<Role, String> {

}
