package com.example.demo;


import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends LdapRepository<User> { }
