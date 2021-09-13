package com.example.postapi.feign;

import com.example.postapi.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-api")
public interface ClientFeign {
    @GetMapping("/post/client/{client_id}")
    ResponseEntity<Client> getClient(@PathVariable("client_id") String clientId);
}
