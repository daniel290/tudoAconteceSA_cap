/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author CLAISA
 */
public class File {

    // Cria JSONObject ou neste caso JSONOParser
    JSONParser jsonParser = new JSONParser();
    //Vai buscar o path do ficheiro ficheirov4.json
    private static final String caminho = "C:\\Users\\claisa\\Desktop\\ficheiroV4.json";
    
    List<Colaborador> listaColaboradores = new ArrayList<Colaborador>();
    //CatalagoColaboradores catCol = new CatalagoColaboradores();

    public void readJSONFile() {

        try (FileReader reader = new FileReader(caminho)) {

            JSONObject root = (JSONObject) jsonParser.parse(reader);

            JSONArray listaColaboradores = (JSONArray) root.get("listaColaboradores");

            for (int i = 0; i < listaColaboradores.size(); i++) {
                JSONObject lista = (JSONObject) listaColaboradores.get(i);
                criaColaborador(lista);
            }
            // catCol.recebeListaColab(listaColaboradores);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void criaColaborador(JSONObject colaborador) {

        JSONObject newC = (JSONObject) colaborador.get("colaborador");

        int numero = Integer.parseInt((String) newC.get("numero"));
        String nome = (String) newC.get("nome");
        String apelido = (String) newC.get("apelido");
        String enderecoEmail = (String) newC.get("enderecoEmail");
        CatalagoColaboradores catColaboradores = new CatalagoColaboradores();
        Colaborador criaC = new Colaborador(numero, nome, apelido, enderecoEmail);
        System.out.println(criaC.getNomeColaborador());
        if (criaC == null) {
            System.out.println("Ta vazio");
        }
        listaColaboradores.add(criaC);

        JSONArray listaEventos = (JSONArray) newC.get("listaEventos");
        //criaEvento(criaC, listaEventos);

        if (!listaEventos.isEmpty()) {
            // System.out.println(criaC.getNomeColaborador() + " tem eventos");
            listaEventos.forEach(ev -> {
                try {
                    criaEvento(criaC, (JSONObject) ev);
                } catch (java.text.ParseException ex) {
                    Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } else {
            // System.out.println(criaC.getNomeColaborador() + " nao tem eventos");     
        }

    }

    private void criaEvento(Colaborador criaC, JSONObject evento) throws java.text.ParseException {

        // System.out.println(evento);
        JSONObject appoint = (JSONObject) evento.get("appointement");
        JSONObject meeting = (JSONObject) evento.get("meeting");

        if (appoint != null) {
            String strIdEvento = (String) appoint.get("idEvento");
            int idEvento = Integer.parseInt(strIdEvento);
            String descricaoEvento = (String) appoint.get("descricaoEvento");

            String strDataEvento = (String) appoint.get("dataEvento");

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Date dataEvento = formatter.parse(strDataEvento);

            String strHoraEvento = (String) appoint.get("horaEvento");
            DateFormat format2 = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
            Date h = format2.parse(strHoraEvento);
            Time horaEvento = new Time(h.getTime());

            String local = (String) appoint.get("local");

            Appointment app = new Appointment(idEvento, descricaoEvento, dataEvento, horaEvento, local);
            System.out.println("Criou app :" + descricaoEvento);
            criaC.addA(app);

        }
        Meeting metee = null;

        if (meeting != null) {

            String strIdEvento = (String) meeting.get("idEvento");
            int idEvento = Integer.parseInt(strIdEvento);
            String descricaoEvento = (String) meeting.get("descricaoEvento");

            String strDataEvento = (String) meeting.get("dataEvento");

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Date dataEvento = formatter.parse(strDataEvento);

            String strHoraEvento = (String) meeting.get("horaEvento");
            DateFormat format2 = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
            Date h = format2.parse(strHoraEvento);
            Time horaEvento = new Time(h.getTime());

            String local = (String) meeting.get("local");

            metee = new Meeting(idEvento, descricaoEvento, dataEvento, horaEvento, local);
            criaC.addM(metee);
            System.out.println("Criou meet :" + descricaoEvento);
            
            //participantess
        JSONArray listPar = (JSONArray) meeting.get("participantes");
        
        for (int i = 0; i < listPar.size(); i++) {
                JSONObject participante = (JSONObject) listPar.get(i);
                System.out.println(participante);
                trataParticipantes(participante, metee);
            }
            
        }

        
       
       
    }
    public void trataParticipantes(JSONObject part, Meeting meeting){
            System.out.println(part);
    }
}
