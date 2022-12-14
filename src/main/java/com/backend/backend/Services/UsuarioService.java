package com.backend.backend.Services;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.UsuarioEmpresaEntity;
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

    public UsuarioEntity findByCorreoAndContrasena(String correo,String contrasena) {
        return usuarioRepository.findByCorreoAndContrasena(correo, contrasena);
    }
    public UsuarioEntity updateUsuario(UsuarioEntity usuarioEntity) {
        UsuarioEntity usuarioEntity1 = usuarioRepository.findById(usuarioEntity.getId_usuario()).orElse(null);
        if (usuarioEntity1 == null) {
            return null;
        }
        usuarioEntity1.setNombre_usuario(usuarioEntity.getNombre_usuario());
        usuarioEntity1.setApellido_usuario(usuarioEntity.getApellido_usuario());
        usuarioEntity1.setFecha_nacimiento(usuarioEntity.getFecha_nacimiento());
        usuarioEntity1.setCorreo(usuarioEntity.getCorreo());
        usuarioEntity1.setContrasena(usuarioEntity.getContrasena());
        usuarioEntity1.setId_ubicacion(usuarioEntity.getId_ubicacion());
        usuarioEntity1.setId_carrito_compras(usuarioEntity.getId_carrito_compras());
        usuarioEntity1.setRol(usuarioEntity.getRol());
        usuarioEntity1.setId_valoracion(usuarioEntity.getId_valoracion());
        return usuarioRepository.save(usuarioEntity1);
    }

}
