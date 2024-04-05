package com.example.ResponseEntity.Service;

import com.example.ResponseEntity.Controller.UserAlreadyExsitsException;
import com.example.ResponseEntity.Repo.EmployeeRepo;
import com.example.ResponseEntity.mode.Employee;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee adding(Employee e) {
        if (employeeRepo.findByEmail(e.getEmail()) != null) {
            throw new UserAlreadyExsitsException("Employee with the same email already exists");
        }
        return employeeRepo.save(e);
    }
    public Employee getById(Long id){
        return employeeRepo.findById(id).get();
    }
    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }
    public Employee getByEmail(String email){
        return employeeRepo.findByEmail(email);
    }

    public Employee upda(Employee ees){
        Employee ee=employeeRepo.findById(ees.getId()).orElse(null);
        ee.setId(ees.getId());
        ee.setName(ees.getName());
        ee.setEmail(ees.getEmail());
        return employeeRepo.save(ee);
    }

    public Employee pat(Long id, Map<String,Object> s){
        Optional<Employee>optionalEmployee=employeeRepo.findById(id);
        if(optionalEmployee.isPresent()){
            s.forEach((key, Value)->{
                Field field= ReflectionUtils.findField(Employee.class,key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,optionalEmployee.get(),Value);
            });
            return employeeRepo.save(optionalEmployee.get());
        }
        return null;
    }
}
