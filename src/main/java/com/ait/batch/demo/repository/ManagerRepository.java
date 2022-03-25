package com.ait.batch.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.batch.demo.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
