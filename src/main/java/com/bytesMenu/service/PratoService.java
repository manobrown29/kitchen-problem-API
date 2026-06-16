package com.bytesMenu.service;

import com.bytesMenu.dto.CriarPratoDTO;
import com.bytesMenu.entity.Prato;
import com.bytesMenu.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratoService {

    @Autowired
    private PratoRepository pratoRepository;

    public List<Prato> listarTodos() {
        return pratoRepository.findAll();
    }

    public List<Prato> listarTodosDisponiveis() {
        return pratoRepository.findByDisponivelTrue();
    }

    public Prato buscarPorId(Long id) {
        return pratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prato não encontrado com id: " + id));
    }

    public Prato criar(CriarPratoDTO dto) {
        Prato prato = Prato.builder()
                .nome(dto.name())
                .descricao(dto.description())
                .preco(dto.price())
                .disponivel(true)
                .build();

        return pratoRepository.save(prato);
    }

    public Prato atualizar(Long id, CriarPratoDTO dto) {
        Prato prato = buscarPorId(id);
        prato.setNome(dto.name());
        prato.setDescricao(dto.description());
        prato.setPreco(dto.price());
        return pratoRepository.save(prato);
    }

    public void deletar(Long id) {
        if (!pratoRepository.existsById(id)) {
            throw new RuntimeException("Prato não encontrado com id: " + id);
        }
        pratoRepository.deleteById(id);
    }

    public Prato disponivel (Long id) {
        Prato prato = buscarPorId(id);

        if (prato.getDisponivel()){
            prato.setDisponivel(false);
        }else {
            prato.setDisponivel(true);
        }
        return pratoRepository.save(prato);
    }
}
