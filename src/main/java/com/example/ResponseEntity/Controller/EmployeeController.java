package com.example.ResponseEntity.Controller;

import com.example.ResponseEntity.Service.EmployeeService;
import com.example.ResponseEntity.mode.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addingAll(@Validated @RequestBody Employee employee) {
        try {
            Employee e = employeeService.adding(employee);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","One Employee added");
            return new ResponseEntity<>(e, headers, HttpStatus.CREATED);
        }
        catch (UserAlreadyExsitsException ex){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }
    }
    @GetMapping("view/{id}")
    public ResponseEntity<Employee>getByiD(@PathVariable("id")long id){
       try{
        Employee idk=employeeService.getById(id);
        if(idk!=null){
            return new ResponseEntity<>(idk,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
       catch (EmployeeNotFoundException e){
           return new ResponseEntity<>(HttpStatus.CONFLICT);
       }
}
@GetMapping("/viewAll")
public ResponseEntity<List<Employee>>viewAll(){
        List<Employee>emp=employeeService.getAll();

        return new ResponseEntity<>(emp,HttpStatus.OK);
}
@PutMapping("/up")
public ResponseEntity<Employee>up(@RequestBody Employee emp){
        try{
            Employee e=employeeService.upda(emp);
            return new ResponseEntity<>(e,HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
    }
        return null;
}
@PatchMapping("pat/{id}")
    public ResponseEntity<Employee>patching(@PathVariable long id, Map<String,Object> k){
       Employee ee=employeeService.pat(id,k);
        return new ResponseEntity<>(ee,HttpStatus.OK);
}


}