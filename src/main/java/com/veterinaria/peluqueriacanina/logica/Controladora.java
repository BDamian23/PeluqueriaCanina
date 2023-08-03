
package com.veterinaria.peluqueriacanina.logica;

import com.veterinaria.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color,
                        String observaciones, String nombreDuenio,
                        String celDuenio, String alergico, String atEspecial) {
        
        Duenio duenio = new Duenio();
        duenio.setNombreDuenio(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        Mascota mascota = new Mascota();
        mascota.setNombreMascota(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atEspecial);
        mascota.setObservaciones(observaciones);
        mascota.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio, mascota);
        
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersis.traerMascotas();
        
    }

    public void borrarDatos(int id) {
        
        controlPersis.borrarDatos(id);
        
    }

    public Mascota traerMascota(int id) {
        return controlPersis.traerMascota(id);
        
    }

    public void modificarMascota(Mascota mascota, String nombreMascota,
                                 String raza, String color, String observaciones,
                                 String nombreDuenio, String celDuenio, String alergico,
                                 String atEspecial) {
        
        mascota.setNombreMascota(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atEspecial);
        controlPersis.modificarMascota(mascota);
        
        Duenio duenio = this.buscarDuenio(mascota.getUnDuenio().getIdDuenio());
        duenio.setCelDuenio(celDuenio);
        duenio.setNombreDuenio(nombreDuenio);
        
        this.modificarDuenio(duenio);
        
    }

    private Duenio buscarDuenio(int idDuenio) {
        return controlPersis.buscarDuenio(idDuenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
    
}
