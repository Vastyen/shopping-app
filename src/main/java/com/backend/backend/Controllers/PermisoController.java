package com.backend.backend.Controllers;

import com.backend.backend.Entities.PermisoEntity;
import com.backend.backend.Services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class PermisoController {
    @Autowired
    PermisoService permisoService;

    @GetMapping("/getPermisoById/{id_permiso}")
    public ResponseEntity<PermisoEntity> getPermisoById(@PathVariable("id_permiso") Integer id_permiso) {
        PermisoEntity permisoEntity = permisoService.getPermisoById(id_permiso);
        if (permisoEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permisoEntity);
    }

    @PutMapping("/updatePermisoById/{id_permiso}")
    public ResponseEntity<PermisoEntity> updatePermisoById(@PathVariable("id_permiso") Integer id_permiso, @RequestBody PermisoEntity permisoEntity) {
        PermisoEntity permisoEntity1 = permisoService.getPermisoById(id_permiso);
        if (permisoEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        permisoService.savePermiso(permisoEntity);
        return ResponseEntity.ok(permisoEntity);
    }

    @PostMapping("/createPermiso")
    public ResponseEntity<PermisoEntity> createPermiso(@RequestBody PermisoEntity permisoEntity) {
        PermisoEntity permisoEntity1 = permisoService.createPermiso(permisoEntity);
        if (permisoEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permisoEntity1);
    }

    @DeleteMapping("/deletePermisoById/{id_permiso}")
    public ResponseEntity<PermisoEntity> deletePermisoById(@PathVariable("id_permiso") Integer id_permiso) {
        PermisoEntity permisoEntity = permisoService.getPermisoById(id_permiso);
        if (permisoEntity == null) {
            return ResponseEntity.notFound().build();
        }
        permisoService.deletePermiso(permisoEntity);
        return ResponseEntity.ok(permisoEntity);
    }
}
