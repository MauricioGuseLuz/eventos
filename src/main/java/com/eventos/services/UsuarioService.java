package com.eventos.services;

import com.eventos.dtos.UsuarioDTO;
import com.eventos.models.Usuario;
import com.eventos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
        usuario.setNome(usuarioDTO.getNome());
        usuario.setData_nascimento(usuarioDTO.getData_nascimento());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setPerfil(usuarioDTO.getPerfil());
        usuario.setVerificado(usuarioDTO.getVerificado());
        return usuario;
    }
    public boolean deletarUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(this::converterUsuarioDTO).collect(Collectors.toList());
    }
    public UsuarioDTO buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(this::converterUsuarioDTO)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));



    }
    private UsuarioDTO converterUsuarioDTO(Usuario usuario) {
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
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = converterUsuarioDTO(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return converterUsuario(usuario);
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return converterUsuario(usuario);
    }

}







