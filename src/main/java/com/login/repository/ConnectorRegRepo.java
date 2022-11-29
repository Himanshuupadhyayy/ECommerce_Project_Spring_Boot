package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.models.ConnectorRegistration;

public interface ConnectorRegRepo extends JpaRepository<ConnectorRegistration, Integer>{



}