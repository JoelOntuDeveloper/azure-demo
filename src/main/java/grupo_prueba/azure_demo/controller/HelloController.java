package grupo_prueba.azure_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class HelloController {
    
    @GetMapping("/hello")
    public String greet() {
        return "Hola, bienvenido a Azure!";
    }
    
}
