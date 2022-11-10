 package com.portfolio.rsf.Controller;

import com.portfolio.rsf.Model.Persona;
import com.portfolio.rsf.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendscollouno.web.app")
public class Controller {
    
    @Autowired
    private IPersonaService persoServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/persona")
    public String agregarPersona(@RequestBody Persona pers){
       persoServ.crearPersona(pers);
       return "La persona fue creada correctamente";
    }
    
   
    @GetMapping ("/ver/personas")
    @CrossOrigin("https://frontendscollouno.web.app/")
    @ResponseBody
    public List<Persona> verPersonas(){
    return persoServ.verPersonas();
    }
    
    @GetMapping ("/ver/personas/{userName}")
    @ResponseBody
    public Persona verPersona(@PathVariable String userName){
    return persoServ.verPersona(userName);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/personas/{id}")
        public Persona editPersona(@PathVariable Long id,
                                   @RequestParam("nombre") String nuevoNombre,
                                   @RequestParam("apellido") String nuevoApellido,
                                   @RequestParam("img") String nuevoImg){
        Persona persona = persoServ.buscarPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        persoServ.save(persona);
            return persona;
        }
}
