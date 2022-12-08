package com.backend.backend.Controllers;

import com.backend.backend.Entities.UbicacionGeograficaEntity;
import com.backend.backend.Services.UbicacionGeograficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UbicacionGeograficaController {
    @Autowired
    UbicacionGeograficaService ubicacionGeograficaService;

    @GetMapping("/getUbicacionGeograficaById/{id_ubicacion_geografica}")
    public ResponseEntity<UbicacionGeograficaEntity> getUbicacionGeograficaById(@PathVariable("id_ubicacion_geografica") Integer id_ubicacion_geografica) {
        UbicacionGeograficaEntity ubicacionGeograficaEntity = ubicacionGeograficaService.getUbicacionGeograficaById(id_ubicacion_geografica);
        if (ubicacionGeograficaEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ubicacionGeograficaEntity);
    }

    @PutMapping("/updateUbicacionGeograficaById/{id_ubicacion_geografica}")
    public ResponseEntity<UbicacionGeograficaEntity> updateUbicacionGeograficaById(@PathVariable("id_ubicacion_geografica") Integer id_ubicacion_geografica, @RequestBody UbicacionGeograficaEntity ubicacionGeograficaEntity) {
        UbicacionGeograficaEntity ubicacionGeograficaEntity1 = ubicacionGeograficaService.getUbicacionGeograficaById(id_ubicacion_geografica);
        if (ubicacionGeograficaEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        ubicacionGeograficaService.saveUbicacionGeografica(ubicacionGeograficaEntity);
        return ResponseEntity.ok(ubicacionGeograficaEntity);
    }

    @PostMapping("/createUbicacionGeografica")
    public ResponseEntity<UbicacionGeograficaEntity> createUbicacionGeografica(@RequestBody UbicacionGeograficaEntity ubicacionGeograficaEntity) {
        UbicacionGeograficaEntity ubicacionGeograficaEntity1 = ubicacionGeograficaService.createUbicacionGeografica(ubicacionGeograficaEntity);
        if (ubicacionGeograficaEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ubicacionGeograficaEntity1);
    }

    @DeleteMapping("/deleteUbicacionGeograficaById/{id_ubicacion_geografica}")
    public ResponseEntity<UbicacionGeograficaEntity> deleteUbicacionGeograficaById(@PathVariable("id_ubicacion_geografica") Integer id_ubicacion_geografica) {
        UbicacionGeograficaEntity ubicacionGeograficaEntity = ubicacionGeograficaService.getUbicacionGeograficaById(id_ubicacion_geografica);
        if (ubicacionGeograficaEntity == null) {
            return ResponseEntity.notFound().build();
        }
        ubicacionGeograficaService.deleteUbicacionGeografica(ubicacionGeograficaEntity);
        return ResponseEntity.ok(ubicacionGeograficaEntity);
    }

    @GetMapping("/getUbicacionGeograficaByRegion/{region}")
    public ResponseEntity<List<UbicacionGeograficaEntity>> getUbicacionGeograficaByRegion(@PathVariable("region") String region) {
        List<UbicacionGeograficaEntity> ubicacionGeograficaEntityList = ubicacionGeograficaService.getUbicacionGeograficaByRegion(region);
        if (ubicacionGeograficaEntityList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ubicacionGeograficaEntityList);
    }

    @GetMapping("/getUbicacionGeograficaByComuna/{comuna}")
    public ResponseEntity<List<UbicacionGeograficaEntity>> getUbicacionGeograficaByComuna(@PathVariable("comuna") String comuna) {
        List<UbicacionGeograficaEntity> ubicacionGeograficaEntityList = ubicacionGeograficaService.getUbicacionGeograficaByProvincia(comuna);
        if (ubicacionGeograficaEntityList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ubicacionGeograficaEntityList);
    }

    @GetMapping("/getUbicacionGeograficaByDireccion/{direccion}")
    public ResponseEntity<List<UbicacionGeograficaEntity>> getUbicacionGeograficaByDireccion(@PathVariable("direccion") String direccion) {
        List<UbicacionGeograficaEntity> ubicacionGeograficaEntityList = ubicacionGeograficaService.getUbicacionGeograficaByDireccion(direccion);
        if (ubicacionGeograficaEntityList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ubicacionGeograficaEntityList);
    }

}
