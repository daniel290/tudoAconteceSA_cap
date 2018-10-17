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
 * @author CLAISA
 */
public class CatalagoColaboradores {
    
    List<Colaborador> listaColaboradores = new ArrayList<Colaborador>();
    
    
    
    public void recebeListaColab( List<Colaborador> lc){
        this.listaColaboradores = lc;
    }
    public void imprimeNomeColab(){
        if(!listaColaboradores.isEmpty()){
        for(Colaborador c : listaColaboradores){
            System.out.println(c.getNomeColaborador());
        }
        
    }
        else{
                System.out.println("Lista vazia");
    }
}}
