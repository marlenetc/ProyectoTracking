package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class MiControlador {

    private static final Logger logger = LoggerFactory.getLogger(MiControlador.class);

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
    @GetMapping("/")
    public String getMessage(){

        return "¡Hola mundo!, soy Marlene";
    }

}
