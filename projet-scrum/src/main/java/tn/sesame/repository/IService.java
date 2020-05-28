package tn.sesame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sesame.domain.Service;

public interface IService extends JpaRepository<Service, Integer> {

}
