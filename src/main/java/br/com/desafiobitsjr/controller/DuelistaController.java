package br.com.desafiobitsjr.controller;

import br.com.desafiobitsjr.service.DuelistaService;
import br.com.desafiobitsjr.model.Duelista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/duelistas")
public class DuelistaController {

    @Autowired
    private DuelistaService duelistaService;

    @GetMapping
    public List<Duelista> getDuelistas() {
        return duelistaService.getDuelistas();
    }

    @GetMapping("/{id}")
    public Duelista getDuelistaPorId(@PathVariable String id) {
        return duelistaService.buscarDuelistaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Duelista adicionarDuelista(@Valid @RequestBody Duelista duelista) {
        return duelistaService.adicionarDuelista(duelista);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDuelista(@PathVariable String id, @Valid @RequestBody Duelista duelista) {
        duelistaService.atualizarDuelista(id, duelista);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerDuelista(@PathVariable String id) {
        duelistaService.removerDuelista(id);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(RuntimeException ex) {
        return ex.getMessage();
    }
}