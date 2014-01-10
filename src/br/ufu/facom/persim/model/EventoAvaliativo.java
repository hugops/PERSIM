package br.ufu.facom.persim.model;

import br.ufu.facom.frameworkpim.model.Evento;
import java.sql.Timestamp;

public class EventoAvaliativo extends Evento{
    
    private String tipo;
    private Float pontuacao;
    
    public EventoAvaliativo(){
        super();
        this.pontuacao = 0.0f;
    }
    
    public EventoAvaliativo (Timestamp dataHora, Timestamp duracao, 
            String descricao, String tipo, Float pontuacao) {
        super(dataHora, duracao, descricao);
        this.tipo = tipo;
        this.pontuacao = pontuacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Float pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    @Override
    public String toString(){
        String str = "";
        
        if (this.getDataHora() != null){
            String[] d = this.getDataHora().toString().split("[^0-9]");        
            str = "Marcado para as: "+d[3]+" horas e "+d[4]+" minutos.\n";
        }
        if (this.getDuracao() != null){
            String[] e = this.getDuracao().toString().split("[^0-9]");
            str += "Duração: "+e[3]+" horas e "+e[4]+" minutos.\n";
        }
        if (this.getPontuacao() != null) {
            str += "Pontuação: "+this.getPontuacao()+"\n";
        }
        if (this.getTipo() != null) {
            str += "Tipo: "+this.getTipo()+"\n";
        }
        if (this.getDescricao() != null){
            str += "Sobre: "+this.getDescricao();
        }
        
        return str;
    }
}
