package com.backend.backend.Services;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.UsuarioEntity;
import com.backend.backend.Repositories.EmpresaRepository;
import com.backend.backend.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EmpresaRepository empresaRepository;
    public UsuarioEntity getUsuarioById(Integer id_usuario) {
        return usuarioRepository.findById(id_usuario).orElse(null);
    }

    public void saveUsuario(UsuarioEntity usuarioEntity) {
        usuarioRepository.save(usuarioEntity);
    }

    public UsuarioEntity createUsuario(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public void deleteUsuario(UsuarioEntity usuarioEntity) {
        usuarioRepository.delete(usuarioEntity);
    }
    public ArrayList<UsuarioEntity> getAllUsuarios() {
        return (ArrayList<UsuarioEntity>) usuarioRepository.findAll();
    }

}
