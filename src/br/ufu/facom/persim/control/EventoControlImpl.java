/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufu.facom.persim.control;

import br.ufu.facom.frameworkpim.control.EventoControl;
import br.ufu.facom.frameworkpim.model.Evento;
import br.ufu.facom.persim.dao.ConnectionSQLiteDAO;
import br.ufu.facom.persim.dao.EventoAvaliativoDAO;
import br.ufu.facom.persim.dao.EventoDAO;
import br.ufu.facom.persim.model.EventoAvaliativo;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class EventoControlImpl implements EventoControl {

    @Override
    public List<Evento> getEventos() {
        return load ();
    }

    @Override
    public Evento save(Evento evento) {
        try {
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            EventoDAO dao = new EventoDAO();
            dao.save(evento, conn);
            conn.closeDB();
            getEventos().add(evento);
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao salvar o evento: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
        return evento;
    }
    private static List<Evento> load () {
        try {
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            EventoDAO dao = new EventoDAO();
            EventoAvaliativoDAO dao2 = new EventoAvaliativoDAO();
            List<Evento> lista = dao.load(conn);
            List<EventoAvaliativo> lista2 = dao2.load(conn);
            lista.addAll(lista2);
            conn.closeDB();
            return lista;
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao salvar o evento: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
        
        return new ArrayList<>();
    }
}
