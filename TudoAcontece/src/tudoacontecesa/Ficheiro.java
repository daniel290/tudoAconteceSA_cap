/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tudoacontecesa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author MMOTEIRO
 */
public class Ficheiro {

    JSONParser jsonParser = new JSONParser();
    private static final String caminho = "D:\\Capgemini\\Projetos\\Projeto_final_java\\";
    Colaborador colaboradorAux =  new Colaborador();
    
    public void readJSONFile() {
        try (FileReader reader = new FileReader(caminho + "ficheiro.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject todoFicheiro = (JSONObject) obj;
            JSONArray listaColaboradores = (JSONArray) todoFicheiro.get("listaColaboradores");
            listaColaboradores.forEach( col -> listaColaboradores( (JSONObject) col ) );
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void listaColaboradores(JSONObject col) {       
        JSONArray cadaColaborador = (JSONArray) col.get("colaborador");
        cadaColaborador.forEach( coll -> cadaColaborador( (JSONObject) coll ) );
        System.out.println(cadaColaborador);

    }
    public void cadaColaborador(JSONObject coll) {
        String strNumero = (String) coll.get("numero");       
        int numero = Integer.parseInt(strNumero);
        String nome = (String) coll.get("nome");
        String apelido = (String) coll.get("apelido");
        String enderecoEmail = (String) coll.get("enderecoEmail");  
        System.out.println(strNumero + " " + nome + " " + apelido + " " + enderecoEmail);
        
//***********************COLABORADOR
        Colaborador colab = new Colaborador(numero, nome, apelido, enderecoEmail);
        colaboradorAux.add(colab);
        
        JSONArray listaEventos = (JSONArray) coll.get("listaEventos");
        listaEventos.forEach( colll -> listaEventos( (JSONObject) colll ) ); 
    }
    public void listaEventos(JSONObject colll) {
        JSONArray meeting = (JSONArray) colll.get("meeting");
        JSONArray appointement = (JSONArray) colll.get("appointement");
        if(meeting == null) appointement.forEach( colllll -> listaMeetingAppointement( (JSONObject) colllll ) );
        else meeting.forEach( collll -> listaMeetingAppointement( (JSONObject) collll ) );
    }   
    public void listaMeetingAppointement(JSONObject collll) {
        String strIdEvento = (String) collll.get("idEvento");
        int idEvento = Integer.parseInt(strIdEvento);
        String descricaoEvento = (String) collll.get("descricaoEvento");
        String dataEvento = (String) collll.get("dataEvento");
        String horaEvento = (String) collll.get("horaEvento");
        String local = (String) collll.get("local");
        JSONArray participantes = (JSONArray) collll.get("participantes");
        System.out.println(strIdEvento + " " + descricaoEvento + " " + dataEvento + " " +  horaEvento + " " + local);
        if(participantes == null) participantes.forEach( colllll -> listaParticipantesMeeting( (JSONObject) colllll ) );
     }
    public void listaParticipantesMeeting(JSONObject colllll) {
        JSONArray cadaParticipante = (JSONArray) colllll.get("participante");
        cadaParticipante.forEach( collllll -> numeroParticipante( (JSONObject) collllll ) );
        
     }
    public void numeroParticipante(JSONObject collllll) {
        String strNumero = (String) collllll.get("numero");
        int numero = Integer.parseInt(strNumero);
        System.out.println(strNumero);
     }
}
