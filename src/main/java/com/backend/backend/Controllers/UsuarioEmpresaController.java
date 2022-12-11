package com.backend.backend.Controllers;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.UsuarioEmpresaEntity;
import com.backend.backend.Entities.UsuarioEntity;
import com.backend.backend.Services.UsuarioEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("/empresasFavoritas")
public class UsuarioEmpresaController {

    @Autowired
    UsuarioEmpresaService usuarioEmpresaService;

    @GetMapping("/getAllEmpresasFavoritas")
    public ResponseEntity<ArrayList<UsuarioEmpresaEntity>> getAllEmpresasFavoritas() {
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
            if (Objects.equals(idUsuario, ue.getId_usuario().getId_usuario()) && ue.isFavorito()) {
                empresas.add(ue.getId_empresa());
            }
        }

        return ResponseEntity.ok(empresas);
    }
    @PostMapping("/createUsuarioEmpresa")
    public ResponseEntity<UsuarioEmpresaEntity> createUsuarioEmpresa(@RequestBody UsuarioEmpresaEntity usuarioEmpresaEntity) {
        UsuarioEmpresaEntity usuarioEmpresaEntity1 = usuarioEmpresaService.createUsuarioEmpresa(usuarioEmpresaEntity);
        if (usuarioEmpresaEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEmpresaEntity1);
    }

    @PutMapping("/updateLikeEmpresa/{status}")
    public ResponseEntity<UsuarioEmpresaEntity> updateLikeEmpresa(@RequestBody UsuarioEmpresaEntity usuarioEmpresaEntity, @PathVariable("status") Integer status) {
        UsuarioEmpresaEntity usuarioEmpresaEntity1 = usuarioEmpresaService.updateLikeEmpresa(usuarioEmpresaEntity.getId_usuario(), usuarioEmpresaEntity.getId_empresa(), status);
        if (usuarioEmpresaEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEmpresaEntity1);
    }
}

