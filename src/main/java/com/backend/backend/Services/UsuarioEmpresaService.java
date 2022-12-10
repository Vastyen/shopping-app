package com.backend.backend.Services;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.UsuarioEmpresaEntity;
import com.backend.backend.Entities.UsuarioEntity;
import com.backend.backend.Repositories.UsuarioEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioEmpresaService {
    @Autowired
    UsuarioEmpresaRepository usuarioEmpresaRepository;

    public ArrayList<UsuarioEmpresaEntity> getAllEmpresasFavoritas() {
        return (ArrayList<UsuarioEmpresaEntity>) usuarioEmpresaRepository.findAll();
    }
    public UsuarioEmpresaEntity createUsuarioEmpresa(UsuarioEmpresaEntity usuarioEmpresaEntity) {
        usuarioEmpresaEntity.setFavorito(true);
        return usuarioEmpresaRepository.save(usuarioEmpresaEntity);
    }

    public UsuarioEmpresaEntity updateLikeEmpresa(UsuarioEntity usuarioEntity, EmpresaEntity empresaEntity, Integer status) {
        boolean favorito = status == 1;
        UsuarioEmpresaEntity usuarioEmpresaEntity =
                usuarioEmpresaRepository.getUsuarioEmpresa(usuarioEntity.getId_usuario(), empresaEntity.getId_empresa());
        if(usuarioEmpresaEntity != null) {
            usuarioEmpresaEntity.setFavorito(favorito);
            usuarioEmpresaRepository.save(usuarioEmpresaEntity);
        }
        else{
            usuarioEmpresaEntity = new UsuarioEmpresaEntity();
            usuarioEmpresaEntity.setId_usuario(usuarioEntity);
            usuarioEmpresaEntity.setId_empresa(empresaEntity);
            usuarioEmpresaEntity.setFavorito(favorito);
            usuarioEmpresaRepository.save(usuarioEmpresaEntity);
        }
        return usuarioEmpresaEntity;
    }
}
