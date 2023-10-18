package med.voll.api.controller;


import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadoslistagemMedico;
import med.voll.api.medico.MedicoRepository;
import med.voll.api.medico.medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("medicos")
    public class MedicoController{


        @Autowired
        private MedicoRepository repository;

        @PostMapping
        @Transactional
        public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados)  {
          repository.save(new medico(dados));

        }

        @GetMapping
        public List<DadoslistagemMedico> listar () {
           return repository.findAll();
        }
    }

