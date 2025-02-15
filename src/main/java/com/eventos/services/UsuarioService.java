package com.eventos.services;

import com.eventos.dtos.UsuarioDTO;
import com.eventos.models.Usuario;
import com.eventos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

   public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
       Usuario usuario = converterUsuarioDTO(usuarioDTO);
       usuario = usuarioRepository.save(usuario);
       return converterUsuario(usuario);
   }

    public UsuarioDTO converterUsuario(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setData_nascimento(usuario.getData_nascimento());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setSenha(usuario.getSenha());
        usuarioDTO.setPerfil(usuario.getPerfil());
        usuarioDTO.setVerificado(usuario.getVerificado());
        return usuarioDTO;
    }

   public Usuario converterUsuarioDTO(UsuarioDTO usuarioDTO) {
       Usuario usuario = new Usuario();
       usuario.setId(usuarioDTO.getId());
       usuario.setNome(usuarioDTO.getNome());
       usuario.setData_nascimento(usuarioDTO.getData_nascimento());
       usuario.setCpf(usuarioDTO.getCpf());
       usuario.setEmail(usuarioDTO.getEmail());
       usuario.setSenha(usuarioDTO.getSenha());
       usuario.setPerfil(usuarioDTO.getPerfil());
       usuario.setVerificado(usuarioDTO.getVerificado());
       return usuario;
   }
}


