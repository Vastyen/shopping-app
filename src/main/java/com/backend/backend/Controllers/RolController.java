package com.backend.backend.Controllers;

import com.backend.backend.Entities.RolEntity;
import com.backend.backend.Services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping("/getRolById/{id_rol}")
    public ResponseEntity<RolEntity> getRolById(@PathVariable("id_rol") Integer id_rol) {
        RolEntity rolEntity = rolService.getRolById(id_rol);
        if (rolEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rolEntity);
    }

    @PutMapping("/updateRolById/{id_rol}")
    public ResponseEntity<RolEntity> updateRolById(@PathVariable("id_rol") Integer id_rol, @RequestBody RolEntity rolEntity) {
        RolEntity rolEntity1 = rolService.getRolById(id_rol);
        if (rolEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        rolService.saveRol(rolEntity);
        return ResponseEntity.ok(rolEntity);
    }

    @PostMapping("/createRol")
    public ResponseEntity<RolEntity> createRol(@RequestBody RolEntity rolEntity) {
        RolEntity rolEntity1 = rolService.createRol(rolEntity);
        if (rolEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rolEntity1);
    }

    @DeleteMapping("/deleteRolById/{id_rol}")
    public ResponseEntity<RolEntity> deleteRolById(@PathVariable("id_rol") Integer id_rol) {
        RolEntity rolEntity = rolService.getRolById(id_rol);
        if (rolEntity == null) {
            return ResponseEntity.notFound().build();
        }
        rolService.deleteRol(rolEntity);
        return ResponseEntity.ok(rolEntity);
    }
}
