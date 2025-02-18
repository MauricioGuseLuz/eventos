package com.eventos.controller;

import com.eventos.dtos.UsuarioDTO;
import com.eventos.models.Usuario;
import com.eventos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getUsuarios(){
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}") //retorna um usuario
    public ResponseEntity<UsuarioDTO> getUsuaioId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.buscarUsuarioPorId(id);
        if(usuario != null) {
            return ResponseEntity.ok(usuario);
            }else {
                return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = usuarioService.cadastrarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        boolean deletado = usuarioService.deletarUsuario(id);
        if(deletado) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioDTO);
        if(usuarioAtualizado == null) {
            return ResponseEntity.ok(usuarioAtualizado);
        }else {
                return ResponseEntity.notFound().build();
            }
        }
}
