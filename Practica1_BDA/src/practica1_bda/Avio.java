/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_bda;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Classe de l'entitat avio
 * @author Karen i Judit
 */
@Entity
@Table(name="AVIO")
public class Avio implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="matricula")
    private String matricula;
    
    @ManyToOne
    @JoinColumn(name="id_model")
    private ModelAvio modelAvio; // Relacio many-to-1
    
    @OneToMany(mappedBy = "avio", cascade=CascadeType.REMOVE)
    private Set<Ruta> rutes;
    
    /**
     * Constructor buit
     */
    public Avio() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor amb tots els parametres
     * @param id
     * @param matricula
     * @param modelAvio 
     */
    public Avio(Integer id, String matricula, ModelAvio modelAvio) {
        this.id = id;
        this.matricula = matricula;
        this.modelAvio = modelAvio;
    }

    /**
     * Constructor sense id, es genera automaticament
     * @param matricula
     * @param modelAvio 
     */
    public Avio(String matricula, ModelAvio modelAvio) {
        this.matricula = matricula;
        this.modelAvio = modelAvio;
    }
    
    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * @return
     */
    public ModelAvio getModelAvio() {
        return modelAvio;
    }

    /**
     *
     * @param modelAvio
     */
    public void setModelAvio(ModelAvio modelAvio) {
        this.modelAvio = modelAvio;
    }

    @Override
    public String toString() {
        //return "Avio{" + "id=" + id + ", matricula=" + matricula + ", modelAvio=" + modelAvio + '}';
        return matricula + ", "+ modelAvio.getNom();
    }

}