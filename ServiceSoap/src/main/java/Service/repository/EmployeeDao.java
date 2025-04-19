package Service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Service.entity.EmployeeEntity;

@Repository

public interface EmployeeDao extends CrudRepository<EmployeeEntity, Long> {
}
