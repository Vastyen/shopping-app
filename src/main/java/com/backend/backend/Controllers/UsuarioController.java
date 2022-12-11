package com.backend.backend.Controllers;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.UsuarioEmpresaEntity;
import com.backend.backend.Entities.UsuarioEntity;
import com.backend.backend.Services.UsuarioEmpresaService;
import com.backend.backend.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioEmpresaService usuarioEmpresaService;

    @GetMapping("/getAllUsuarios")
    public ResponseEntity<Iterable<UsuarioEntity>> getAllUsuarios() {
        ArrayList<UsuarioEntity> usuarioEntities = usuarioService.getAllUsuarios();
        if (usuarioEntities == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEntities);
    }
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
        usuarioEntity1.setNombre_usuario(usuarioEntity.getNombre_usuario());
        usuarioEntity1.setApellido_usuario(usuarioEntity.getApellido_usuario());
        usuarioEntity1.setCorreo_usuario(usuarioEntity.getCorreo_usuario());
        usuarioEntity1.setContrasena(usuarioEntity.getContrasena());
        usuarioEntity1.setFecha_nacimiento(usuarioEntity.getFecha_nacimiento());
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

    @GetMapping("/getEmpresasFavoritasByUsuario/{id_usuario}")
    public String getEmpresasFavoritas(@PathVariable("id_usuario") Integer id_usuario) {
        return "redirect:/empresasFavoritas/getEmpresasFavoritasByIdUsuario/" + id_usuario;
    }

    @GetMapping("/getCarritoComprasByUsuario/{id_usuario}")
    public String getCarritoCompras(@PathVariable("id_usuario") Integer id_usuario) {
        return "redirect:/carritoCompras/getProductosByIdUsuario/" + id_usuario;
    }
}
