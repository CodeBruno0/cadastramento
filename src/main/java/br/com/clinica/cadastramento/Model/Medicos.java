package br.com.clinica.cadastramento.Model;

public class Medicos {
    
    private String nome;
    private String especialidade;
    private double consulta;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public double getConsulta() {
        return consulta;
    }
    public void setConsulta(double consulta) {
        this.consulta = consulta;
    }

   
}
