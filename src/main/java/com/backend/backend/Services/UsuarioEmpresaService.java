package com.backend.backend.Services;

import com.backend.backend.Entities.UsuarioEmpresaEntity;
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
/*
    public UsuarioEmpresaEntity dislikeEmpresa(Integer idUsuario, Integer idEmpresa) {
        UsuarioEmpresaEntity usuarioEmpresaEntity = usuarioEmpresaRepository.findById_usuarioAndId_empresa(idUsuario, idEmpresa);
        if(usuarioEmpresaEntity != null) {
            usuarioEmpresaEntity.setFavorito(false);
            usuarioEmpresaRepository.save(usuarioEmpresaEntity);
        }
        return usuarioEmpresaEntity;
    }

    public UsuarioEmpresaEntity likeEmpresa(Integer idUsuario, Integer idEmpresa) {
        UsuarioEmpresaEntity usuarioEmpresaEntity = usuarioEmpresaRepository.findById_usuarioAndId_empresa(idUsuario, idEmpresa);
        if(usuarioEmpresaEntity != null) {
            usuarioEmpresaEntity.setFavorito(true);
            usuarioEmpresaRepository.save(usuarioEmpresaEntity);
        }
        return usuarioEmpresaEntity;
    }*/
}
