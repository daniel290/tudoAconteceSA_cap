/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MMOTEIRO
 */
public class Eventos {

    private int idEvento;
    private String descricaoEvento;
    private Date dataEvento;
    private Time horaEvento;
    private String local;
    private List<Colaborador> participantes;
    
    public Eventos(int idEvento, String descricaoEvento,
            Date dataEvento, Time horaEvento, String local) {
        this.idEvento = idEvento;
        this.descricaoEvento = descricaoEvento;
        this.dataEvento = dataEvento;
        this.horaEvento = horaEvento;
        this.local = local; 
    }
        /**
         * @return the idEvento
         */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * @return the descricaoEvento
     */
    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    /**
     * @param descricaoEvento the descricaoEvento to set
     */
    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    /**
     * @return the dataEvento
     */
    public Date getDataEvento() {
        return dataEvento;
    }

    /**
     * @param dataEvento the dataEvento to set
     */
    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    /**
     * @return the horaEvento
     */
    public Time getHoraEvento() {
        return horaEvento;
    }

    /**
     * @param horaEvento the horaEvento to set
     */
    public void setHoraEvento(Time horaEvento) {
        this.horaEvento = horaEvento;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the participantes
     */
    public List<Colaborador> getParticipantes() {
        return participantes;
    }

    /**
     * @param participantes the participantes to set
     */
    public void setParticipantes(List<Colaborador> participantes) {
        this.participantes = participantes;
    }

   
}
