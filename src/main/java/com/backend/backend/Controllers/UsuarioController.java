package com.backend.backend.Controllers;

import com.backend.backend.Entities.UsuarioEntity;
import com.backend.backend.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/getUsuarioById/{id_usuario}")
    public ResponseEntity<UsuarioEntity> getUsuarioById(@PathVariable("id_usuario") Integer id_usuario) {
        UsuarioEntity usuarioEntity = usuarioService.getUsuarioById(id_usuario);
        if (usuarioEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEntity);
    }

    @PutMapping("/updateUsuarioById/{id_usuario}")
    public ResponseEntity<UsuarioEntity> updateUsuarioById(@PathVariable("id_usuario") Integer id_usuario, @RequestBody UsuarioEntity usuarioEntity) {
        UsuarioEntity usuarioEntity1 = usuarioService.getUsuarioById(id_usuario);
        if (usuarioEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.saveUsuario(usuarioEntity);
        return ResponseEntity.ok(usuarioEntity);
    }

    @PostMapping("/createUsuario")
    public ResponseEntity<UsuarioEntity> createUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        UsuarioEntity usuarioEntity1 = usuarioService.createUsuario(usuarioEntity);
        if (usuarioEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEntity1);
    }

    @DeleteMapping("/deleteUsuarioById/{id_usuario}")
    public ResponseEntity<UsuarioEntity> deleteUsuarioById(@PathVariable("id_usuario") Integer id_usuario) {
        UsuarioEntity usuarioEntity = usuarioService.getUsuarioById(id_usuario);
        if (usuarioEntity == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteUsuario(usuarioEntity);
        return ResponseEntity.ok(usuarioEntity);
    }
}
