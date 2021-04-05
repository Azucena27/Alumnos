/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import alumnos.Alumno;
import exception.AlumnoExistenteException;
import exception.ArchivoInvalidoException;
import exception.BuscarAlumnoException;
import exception.CargarArchivoException;
import exception.GuardarArchivoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Azucena
 */
public class Controller implements Serializable {

    private ArrayList<Alumno> alumnos;

    public Controller() throws CargarArchivoException, ArchivoInvalidoException {
        cargar();
    }

    public boolean add(Alumno alumno) throws AlumnoExistenteException {
        if (alumnos.contains(alumno)) {
            throw new AlumnoExistenteException("El número de control ya ha sido asignado anteriormente");
        }
        return alumnos.add(alumno);
    }

    public Alumno getAlumno(int inx) {
        return alumnos.get(inx);
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public int cantidadAlumno() {
        return alumnos.size();
    }

    public void buscarAlumno(String noControl) throws BuscarAlumnoException{
        alumnos.contains(noControl);
    }

    public void guardar() throws GuardarArchivoException {
        try {
            File file = new File("alumnos.dat");
            FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(output);

            writer.writeObject(this);

            writer.close();
            output.close();
        } catch (IOException ex) {
            throw new GuardarArchivoException("Hubo un error en disco duro");
        }
    }

    public void cargar() throws CargarArchivoException, ArchivoInvalidoException {
        File file = new File("alumnos.dat");
        if (file.exists()) {
            try {
                FileInputStream input = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(input);

                alumnos = (ArrayList<Alumno>) reader.readObject();

                reader.close();
                input.close();
            } catch (IOException ex) {
                throw new CargarArchivoException("Error al cargar el archivo inicial");
            } catch (ClassNotFoundException ex) {
                throw new ArchivoInvalidoException("El archivo de origen ha sido corrompido");
            }
        } else {
            alumnos = new ArrayList<Alumno>();
        }

    }
}
