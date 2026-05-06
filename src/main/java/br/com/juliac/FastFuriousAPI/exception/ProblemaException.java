/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author sesi3dia
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemaException {
    private Integer status; // [cite: 144]
    private LocalDateTime dataHora; // [cite: 144]
    private String titulo; // [cite: 144]
    private List<CampoProblema> campos; // 

    // Subclasse estática para os detalhes de cada campo (Página 7 do PDF)
    public static class CampoProblema { // [cite: 234]
        private String nomeCampo; // [cite: 235]
        private String mensagemCampo; // [cite: 236]

        public CampoProblema(String nomeCampo, String mensagemCampo) { // [cite: 238]
            this.nomeCampo = nomeCampo;
            this.mensagemCampo = mensagemCampo;
        }

        // Getters e Setters dos Campos
        public String getNomeCampo() { return nomeCampo; }
        public String getMensagemCampo() { return mensagemCampo; }
    }

    // Getters e Setters da classe principal (Página 4 do PDF)
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public List<CampoProblema> getCampos() { return campos; }
    public void setCampos(List<CampoProblema> campos) { this.campos = campos; }
}

