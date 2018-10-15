/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tudoacontecesa;

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
    private static List<Colaborador> listaColaboradores = new ArrayList<Colaborador>();
    
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
    public void add(Colaborador colab){
        listaColaboradores.add(colab);
    }
    public Colaborador getColaborador(int number){
        Colaborador col = null;
        for(Colaborador c : listaColaboradores){
            if(c.getNumeroColaborador() == number){
                col = c;
            }
        }
        return col;
           
    }
}



