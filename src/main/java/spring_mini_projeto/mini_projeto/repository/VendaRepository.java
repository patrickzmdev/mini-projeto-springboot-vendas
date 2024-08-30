package spring_mini_projeto.mini_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring_mini_projeto.mini_projeto.entity.VendaEntity;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long> {

}
