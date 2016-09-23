/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_bda;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Karen i Judit
 */
@Entity
@Table(name="MODEL_AVIO")
public class ModelAvio implements Serializable {
    @Id @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="nom")
    private String nom;
    
    @Column(name="descripcio")
    private String descripcio;
    
    @Column(name="places")
    private Integer places;
    
    @Column(name="pes")
    private double pes;
    
    public ModelAvio() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ModelAvio(Integer id, String nom, String descripcio, Integer places, 
            double pes) {
        super();
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.places = places;
        this.pes = pes;
    }
    
    public ModelAvio(String nom, String descripcio, Integer places, 
            double pes) {
        super();
        this.nom = nom;
        this.descripcio = descripcio;
        this.places = places;
        this.pes = pes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

}