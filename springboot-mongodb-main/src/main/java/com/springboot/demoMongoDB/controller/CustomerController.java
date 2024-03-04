package com.springboot.demoMongoDB.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import com.springboot.demoMongoDB.repository.CustomerRepository;
import com.springboot.demoMongoDB.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {


    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    // Inyectar el nombre del pod desde la variable de entorno
    @Value("${HOSTNAME}")
    private String podName;

    // Inyectar la dirección IP del pod desde la variable de entorno
    @Value("${POD_IP}")
    private String podIp;

    @GetMapping("/")
    public String handleRequest() {
        // Registrar información del pod en los logs
        logger.info("Handling request in pod: {} with IP: {}", podName, podIp);
        // Resto de la lógica para manejar la solicitud...
        return "Solicitud manejada por el pod: " + podName + " con IP: " + podIp;
    }
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customers")
    public Customer save(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
}
