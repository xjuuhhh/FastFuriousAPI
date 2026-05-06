/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author sesi3dia
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
    
    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, 
            HttpHeaders headers, 
            HttpStatusCode status, 
            WebRequest request) {

        ProblemaException problema = new ProblemaException(); // [cite: 192]
        problema.setStatus(status.value()); // [cite: 193]
        problema.setTitulo("Um ou mais campos inválidos! Tente novamente."); // [cite: 194]
        problema.setDataHora(LocalDateTime.now()); // [cite: 194]

        List<ProblemaException.CampoProblema> camposComErro = new ArrayList<>(); // [cite: 291]

        // Loop para pegar todos os erros de validação (Página 8)
        for (ObjectError error : ex.getBindingResult().getAllErrors()) { // [cite: 292]
            String nomeCampo = ((FieldError) error).getField(); // [cite: 294]
            String mensagemCampo = error.getDefaultMessage(); // [cite: 295]
            camposComErro.add(new ProblemaException.CampoProblema(nomeCampo, mensagemCampo)); // [cite: 296]
        }

        problema.setCampos(camposComErro); // [cite: 297]

        return handleExceptionInternal(ex, problema, headers, status, request); // [cite: 298]
    }
}