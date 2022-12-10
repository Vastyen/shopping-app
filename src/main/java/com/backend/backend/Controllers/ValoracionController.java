package com.backend.backend.Controllers;

import com.backend.backend.Entities.ValoracionEntity;
import com.backend.backend.Services.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/valoracion")
public class ValoracionController {
    @Autowired
    ValoracionService valoracionService;


    @GetMapping("/getAllValoracion")
    public ResponseEntity<Iterable<ValoracionEntity>> getAllValoracion() {
        ArrayList<ValoracionEntity> valoracionEntities = valoracionService.getAllValoracion();
        if (valoracionEntities == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(valoracionEntities);
    }
    @GetMapping("/getValoracionById/{id_valoracion}")
    public ResponseEntity<ValoracionEntity> getValoracionById(@PathVariable("id_valoracion") Integer id_valoracion) {
        ValoracionEntity valoracionEntity = valoracionService.getValoracionById(id_valoracion);
        if (valoracionEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(valoracionEntity);
    }

    @PutMapping("/updateValoracionById/{id_valoracion}")
    public ResponseEntity<ValoracionEntity> updateValoracionById(@PathVariable("id_valoracion") Integer id_valoracion, @RequestBody ValoracionEntity valoracion) {
        ValoracionEntity valoracionEntity1 = valoracionService.getValoracionById(id_valoracion);
        if (valoracionEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        valoracionEntity1.setEstrellas(valoracion.getEstrellas());
        valoracionEntity1.setComentario(valoracion.getComentario());
        valoracionService.saveValoracion(valoracionEntity1);
        return ResponseEntity.ok(valoracionEntity1);
    }

    @PostMapping("/createValoracion")
    public ResponseEntity<ValoracionEntity> createValoracion(@RequestBody ValoracionEntity valoracionEntity) {
        ValoracionEntity valoracionEntity1 = valoracionService.createValoracion(valoracionEntity);
        if (valoracionEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(valoracionEntity1);
    }

    @DeleteMapping("/deleteValoracionById/{id_valoracion}")
    public ResponseEntity<ValoracionEntity> deleteValoracionById(@PathVariable("id_valoracion") Integer id_valoracion) {
        ValoracionEntity valoracionEntity = valoracionService.getValoracionById(id_valoracion);
        if (valoracionEntity == null) {
            return ResponseEntity.notFound().build();
        }
        valoracionService.deleteValoracion(valoracionEntity);
        return ResponseEntity.ok(valoracionEntity);
    } 
}
