/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MMOTEIRO
 */
public class Colaborador {
    
    private int numeroColaborador;
    private String nomeColaborador;
    private String apelidoColaborador;
    private String emailColaborador;
    private static List<Appointment> listaAppointements = new ArrayList<Appointment>();
    private static List<Meeting> listaMeetings = new ArrayList<Meeting>();
    
    public Colaborador(){};
    
    public Colaborador(int numeroColaborador, String nomeColaborador, 
            String apelidoColaborador, String emailColaborador) {
        
        this.numeroColaborador = numeroColaborador;
        this.nomeColaborador = nomeColaborador;
        this.apelidoColaborador = apelidoColaborador;
        this.emailColaborador = emailColaborador;
       
     
}

    public int getNumeroColaborador() {
        return numeroColaborador;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }


    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getApelidoColaborador() {
        return apelidoColaborador;
    }

    public void setApelidoColaborador(String apelidoColaborador) {
        this.apelidoColaborador = apelidoColaborador;
    }

    public String getEmailColaborador() {
        return emailColaborador;
    }


    public void setEmailColaborador(String emailColaborador) {
        this.emailColaborador = emailColaborador;
    }
    
    
    public void addA(Appointment a){
    
        listaAppointements.add(a);
         
    }
    public void addM(Meeting m){
        //System.out.println("Vai adicionar meeting :" + m.getDescricaoEvento() + " a " + this.nomeColaborador);
     listaMeetings.add(m);
 
    }

    
    public List<Meeting> getListMeeting(){
    
        return this.listaMeetings;
    }
    
    public List<Appointment> getListAppoint(){
        return this.listaAppointements;
    }
}
