package grupo_prueba.azure_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class HelloController {
    
    @Value("${app.name}")
    private String appName;

    @GetMapping("/hello")
    public String hello() {
        return "Hola desde " + appName;
    }
    
}
