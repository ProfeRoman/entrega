package com.portfolio.rsf.service;

import com.portfolio.rsf.Model.Persona;
import java.util.List;

public interface IPersonaService {
    //traer una lista de persona
    public List<Persona> verPersonas();
    
    public void crearPersona(Persona per);
    
    //eliminar un objeto pero lo hacemos por ID
    public void borrarPersona(Long id);
    
    //buscar persona por ID 
    public Persona buscarPersona(Long id);
    
    //guardar un objeto de tipo persona
    public void save(Persona persona);
    
    
    public Persona verPersona(String userName);
}
