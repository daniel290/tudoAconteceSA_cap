/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author RCARVOEI
 */
public class Appointment extends Eventos {

    public Appointment(int idEvento, String descricaoEvento, Date dataEvento, Time horaEvento, String local) {
        super(idEvento, descricaoEvento, dataEvento, horaEvento, local);
    }

}
