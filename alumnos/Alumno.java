/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import exception.CalificacionErroneaException;
import java.io.Serializable;

/**
 *
 * @author Azucena
 */
public class Alumno implements Serializable{
    
    private String noControl;
    private String nombre;
    private String paterno;
    private String materno;
    private Double calificacion;
    private Carrera carrera;
    
    public Alumno(String noControl, String nombre, String paterno, String materno, Double calificacion, Carrera carrera) throws CalificacionErroneaException{
        this.noControl=noControl;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.setCalificacion(calificacion);
        this.carrera = carrera;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Alumno){
        Alumno alumno= (Alumno)obj;
        if(this.noControl.compareTo(alumno.getNoControl()) == 0){
            return true;
        }
    }
        return false;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the paterno
     */
    public String getPaterno() {
        return paterno;
    }


    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }


    public void setMaterno(String materno) {
        this.materno = materno;
    }


    public Double getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(Double calificacion) throws CalificacionErroneaException {
        if ((calificacion >= 0)&&(calificacion <= 10)){
            this.calificacion=calificacion;
        }else{
            throw new CalificacionErroneaException("La calificación debe ser entre 0 y 10");
        }
    }

    
    public Carrera getCarrera() {
        return carrera;
    }


    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    
}
