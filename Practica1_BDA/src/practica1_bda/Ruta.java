/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_bda;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Classe de l'entitat ruta
 * @author Karen i Judit
 */
@Entity
@Table(name="RUTA")
public class Ruta implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="dia")
    private String dia;
    
    @Column(name="hora")
    private Time hora;
    
    @ManyToOne
    @JoinColumn(name="Origen")
    private Aeroport aeroport_origen; // Relacio n-1
    
    @ManyToOne
    @JoinColumn(name="Desti")
    private Aeroport aeroport_desti; // Relacio n-1
    
    @ManyToOne
    @JoinColumn(name="Model")
    private ModelAvio model_avio; // Relacio n-1
    
    @Column(name="data")
    private Date data;
     
    @ManyToOne
    @JoinColumn(name="Avio")
    private Avio avio; // Relacio n-1
     
    @ManyToOne
    @JoinColumn(name="Pilot")
    private Pilot pilot; // Relacio n-1
     
    @Column(name="incidencies")
    private String incidencies;
     
    /**
     * Constructor buit
     */
    public Ruta() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor amb tots els parametres obligatoris
     * @param id
     * @param dia
     * @param hora
     * @param aeroport_origen
     * @param aeroport_desti
     * @param model_avio 
     */
    public Ruta(Integer id, String dia, Time hora, Aeroport aeroport_origen, Aeroport aeroport_desti, ModelAvio model_avio) {
        this.id = id;
        this.dia = dia;
        this.hora = hora; 
        this.aeroport_origen = aeroport_origen;
        this.aeroport_desti = aeroport_desti;
        this.model_avio = model_avio;
    }
    
    /**
     * Constructor sense id, es genera automaticament.
     * @param dia
     * @param hora
     * @param aeroport_origen
     * @param aeroport_desti
     * @param model_avio 
     */
    public Ruta(String dia, Time hora, Aeroport aeroport_origen, Aeroport aeroport_desti, ModelAvio model_avio) {
        this.dia = dia;
        this.hora = hora; 
        this.aeroport_origen = aeroport_origen;
        this.aeroport_desti = aeroport_desti;
        this.model_avio = model_avio;
    }
    
    /**
     * Constructor amb tots els parametres (inclosos els opcionals)
     * @param id
     * @param dia
     * @param hora
     * @param aeroport_origen
     * @param aeroport_desti
     * @param model_avio
     * @param data
     * @param avio
     * @param pilot
     * @param incidencies 
     */
    public Ruta(Integer id, String dia, Time hora, Aeroport aeroport_origen, Aeroport aeroport_desti, ModelAvio model_avio, 
             Date data, Avio avio, Pilot pilot, String incidencies) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
        this.aeroport_origen = aeroport_origen;
        this.aeroport_desti = aeroport_desti;
        this.model_avio = model_avio;
        this.data = data;
        this.avio = avio;
        this.pilot = pilot;
        this.incidencies = incidencies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Aeroport getAeroport_origen() {
        return aeroport_origen;
    }

    public void setAeroport_origen(Aeroport aeroport_origen) {
        this.aeroport_origen = aeroport_origen;
    }

    public Aeroport getAeroport_desti() {
        return aeroport_desti;
    }

    public void setAeroport_desti(Aeroport aeroport_desti) {
        this.aeroport_desti = aeroport_desti;
    }

    public ModelAvio getModel_avio() {
        return model_avio;
    }

    public void setModel_avio(ModelAvio model_avio) {
        this.model_avio = model_avio;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Avio getAvio() {
        return avio;
    }

    public void setAvio(Avio avio) {
        this.avio = avio;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public String getIncidencies() {
        return incidencies;
    }

    public void setIncidencies(String incidencies) {
        this.incidencies = incidencies;
    }

    @Override
    public String toString() {
        /*return "Ruta{" + "id=" + id + ",dia=" + dia + ", hora=" + hora + ", aeroport_origen=" 
                + aeroport_origen + ", aeroport_desti=" + aeroport_desti + ", model_avio=" 
                + model_avio + ", data=" + data + ", avio=" + avio + ", pilot=" + pilot 
                + ", incidencies=" + incidencies +'}';*/
        String r;
        if(avio==null){
            r = dia + ", "+ hora +", "+aeroport_origen.getCodi_int()+", "+aeroport_desti.getCodi_int()
                +", "+model_avio.getNom();
        } else {
            r = dia + ", "+ hora +", "+aeroport_origen.getCodi_int()+", "+aeroport_desti.getCodi_int()
                +", "+model_avio.getNom() +", "+data+", "+avio.getMatricula()+", "+pilot.getNom()+" " +pilot.getCognom()
                +", "+incidencies;
        }
        return r;
    }

}