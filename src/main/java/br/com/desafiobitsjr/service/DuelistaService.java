package br.com.desafiobitsjr.service;

import br.com.desafiobitsjr.model.Duelista;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DuelistaService {
    private final List<Duelista> duelistas = new ArrayList<>();
    private int idCounter = 1;

    public List<Duelista> getDuelistas() {
        return duelistas;
    }

    public Duelista adicionarDuelista(Duelista duelista) {
        duelista.setId(String.valueOf(idCounter++));
        duelistas.add(duelista);
        return duelista;
    }

    public void atualizarDuelista(String id, Duelista duelistaAtualizado) {
        for (int i = 0; i < duelistas.size(); i++) {
            Duelista d = duelistas.get(i);
            if (d.getId().equals(id)) {
                duelistaAtualizado.setId(id); // Preserva o ID
                duelistas.set(i, duelistaAtualizado);
                return;
            }
        }
        throw new RuntimeException("Duelista com ID " + id + " não encontrado");


    }

    public void removerDuelista(String id) {
        boolean removed = duelistas.removeIf(duelista -> duelista.getId().equals(id));
        if (!removed) {
            throw new RuntimeException("Duelista com ID " + id + " não encontrado");
        }
    }

    public Duelista buscarDuelistaPorId(String id) {
        for (Duelista duelista : duelistas) {
            if (duelista.getId().equals(id)) {
                return duelista;
            }
        }
        throw new RuntimeException("Duelista com ID " + id + " não encontrado");
    }
}