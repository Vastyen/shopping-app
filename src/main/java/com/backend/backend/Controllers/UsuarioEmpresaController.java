package com.backend.backend.Controllers;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.UsuarioEmpresaEntity;
import com.backend.backend.Entities.UsuarioEntity;
import com.backend.backend.Services.UsuarioEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("/empresasFavoritas")
public class UsuarioEmpresaController {

    @Autowired
    UsuarioEmpresaService usuarioEmpresaService;

    @GetMapping("/getAllEmpresasFavoritas")
    public ResponseEntity<Iterable<UsuarioEmpresaEntity>> getAllEmpresasFavoritas() {
        ArrayList<UsuarioEmpresaEntity> usuarioEmpresaEntities = usuarioEmpresaService.getAllEmpresasFavoritas();
        if (usuarioEmpresaEntities == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEmpresaEntities);
    }

    @GetMapping("/getEmpresasFavoritasByIdUsuario/{idUsuario}")
    public ResponseEntity<ArrayList<EmpresaEntity>> getEmpresasFavoritas(@PathVariable("idUsuario") Integer idUsuario) {
        ArrayList<UsuarioEmpresaEntity> usuarioEmpresaEntity = usuarioEmpresaService.getAllEmpresasFavoritas();
        if (usuarioEmpresaEntity == null) {
            return ResponseEntity.notFound().build();
        }
        ArrayList<EmpresaEntity> empresas = new ArrayList<>();
        for (UsuarioEmpresaEntity ue : usuarioEmpresaEntity) {
            if(Objects.equals(idUsuario, ue.getId_usuario().getId_usuario()) && ue.isFavorito()) {
                empresas.add(ue.getId_empresa());
            }
        }

        return ResponseEntity.ok(empresas);
    }
    @GetMapping("/dislikeEmpresa/{idUsuario}/{idEmpresa}")
    public ResponseEntity<UsuarioEmpresaEntity> dislikeEmpresa(@PathVariable("idUsuario") Integer idUsuario, @PathVariable("idEmpresa") Integer idEmpresa) {
        UsuarioEmpresaEntity usuarioEmpresaEntity = usuarioEmpresaService.dislikeEmpresa(idUsuario, idEmpresa);
        if (usuarioEmpresaEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEmpresaEntity);
    }
    @GetMapping("/likeEmpresa/{idUsuario}/{idEmpresa}")
    public ResponseEntity<UsuarioEmpresaEntity> likeEmpresa(@PathVariable("idUsuario") Integer idUsuario, @PathVariable("idEmpresa") Integer idEmpresa) {
        UsuarioEmpresaEntity usuarioEmpresaEntity = usuarioEmpresaService.likeEmpresa(idUsuario, idEmpresa);
        if (usuarioEmpresaEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEmpresaEntity);
    }
}
