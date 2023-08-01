package br.com.clinica.cadastramento.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.cadastramento.Model.Medicos;

@RestController
@RequestMapping("/medicos")
public class MedicosController {
    List<Medicos>medicos = new ArrayList<>();

    //READ
    @GetMapping
    private List<Medicos> obterMedicos(){
        return medicos;
    }
    @GetMapping("/{nome}")
    private Medicos obterMedicoPorNome(@PathVariable String nome){
        Medicos medico = medicos.stream().filter(m -> m.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
        return medico;
    }
    //CREATE
    @PostMapping
    private ResponseEntity<String> cadastrarMedicos(@RequestBody Medicos medico){
        if(medico != null){
            medicos.add(medico);
            String mensagem = "Nome: " + medico.getNome() + ".\n"
            + "Especialidade: " + medico.getEspecialidade() + ".\n"
            + "Valor da consulta: R$ " + medico.getConsulta() + ".\n"
            + "Medico cadastrado com sucesso!";
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);

        }
        String mensagem = "Medico informado e nulo.";
        return new ResponseEntity<String>(mensagem, HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/{nome}")
    private Medicos atualizarMedicos(@PathVariable String nome,
                                    @RequestBody Medicos medicoNovo){
    Medicos medico = medicos.stream().filter(m -> m.getNome().equalsIgnoreCase(nome))
    .findFirst().orElse(null);
    if(medico != null){
        medico.setNome(medicoNovo.getNome());
        medico.setEspecialidade(medicoNovo.getEspecialidade());
        medico.setConsulta(medicoNovo.getConsulta());

    }
    return medico;
    }

    //DELETE
    @DeleteMapping("/{nome}")
    private void removerMedico(@PathVariable String nome){
        medicos.removeIf(m -> m.getNome().equalsIgnoreCase(nome));
    }
}
