package Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Service.repository.EmployeeDao;
import Service.entity.EmployeeEntity;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public EmployeeEntity addEmpleado(EmployeeEntity empleadoEntity)throws Exception {
        try{
            return employeeDao.save(empleadoEntity);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
