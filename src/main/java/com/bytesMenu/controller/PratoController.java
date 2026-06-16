package com.bytesMenu.controller;

import com.bytesMenu.dto.CriarPratoDTO;
import com.bytesMenu.entity.Prato;
import com.bytesMenu.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pratos")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @PostMapping
    public ResponseEntity<Prato> criar(@RequestBody CriarPratoDTO dto) {
        Prato prato = pratoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(prato);
    }

    @GetMapping
    public ResponseEntity<List<Prato>> listarTodos() {
        return ResponseEntity.ok(pratoService.listarTodos());
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Prato>> listarDisponiveis() {
        return ResponseEntity.ok(pratoService.listarTodosDisponiveis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prato> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pratoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prato> atualizar(@PathVariable Long id, @RequestBody CriarPratoDTO prato) {
        return ResponseEntity.ok(pratoService.atualizar(id, prato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prato> deletar(@PathVariable Long id) {
        pratoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/disponivel")
    public ResponseEntity<Prato> atualizarDisponivel(@PathVariable Long id){
        return ResponseEntity.ok(pratoService.disponivel(id));
    }
}
