package com.example.ResponseEntity.CustomEndPoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@Endpoint(id = "kmj")
public class EndpointDemo {
    private Map<String,Object> kk=new ConcurrentHashMap<>();

@ReadOperation
        public Map<String,Object> end(){
            kk.put("kmj","hello Jeeva");
        return kk;
    }
}
