package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class MiControlador {

    private static final Logger logger = LoggerFactory.getLogger(MiControlador.class);

    @GetMapping("/endpoint")
    public String handleRequest() {
        // Obteniendo el nombre del pod
        String podName = System.getenv("HOSTNAME"); // Variable de entorno para obtener el nombre del pod en Kubernetes

        // Obteniendo el ID del pod
        String podId = System.getenv("POD_ID"); // Asegúrate de que esta variable de entorno esté configurada en tu entorno

        // Registrando información en los logs
        logger.info("Solicitud manejada por el pod: Nombre={}, ID={}", podName, podId);

        // Tu lógica de negocio aquí
        return "Respuesta de la solicitud";
    }
}


