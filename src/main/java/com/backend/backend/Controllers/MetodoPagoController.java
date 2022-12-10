package com.backend.backend.Controllers;

import com.backend.backend.Entities.MetodoPagoEntity;
import com.backend.backend.Services.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/metodoPago")
public class MetodoPagoController {
    @Autowired
    MetodoPagoService metodoPagoService;

    @GetMapping("/getAllMetodoPago")
    public ResponseEntity<ArrayList<MetodoPagoEntity>> getAllMetodoPago() {
        ArrayList<MetodoPagoEntity> metodoPagoEntities = metodoPagoService.getAllMetodoPago();
        if (metodoPagoEntities == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metodoPagoEntities);
    }
    @GetMapping("/getMetodoPagoById/{id_metodo_pago}")
    public ResponseEntity<MetodoPagoEntity> getMetodoPagoById(@PathVariable("id_metodo_pago") Integer id_metodo_pago) {
        MetodoPagoEntity metodoPagoEntity = metodoPagoService.getMetodoPagoById(id_metodo_pago);
        if (metodoPagoEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metodoPagoEntity);
    }

    @PutMapping("/updateMetodoPagoById/{id_metodo_pago}")
    public ResponseEntity<MetodoPagoEntity> updateMetodoPagoById(@PathVariable("id_metodo_pago") Integer id_metodo_pago, @RequestBody MetodoPagoEntity metodoPagoEntity) {
        MetodoPagoEntity metodoPagoEntity1 = metodoPagoService.getMetodoPagoById(id_metodo_pago);
        if (metodoPagoEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        metodoPagoService.saveMetodoPago(metodoPagoEntity);
        return ResponseEntity.ok(metodoPagoEntity);
    }

    @PostMapping("/createMetodoPago")
    public ResponseEntity<MetodoPagoEntity> createMetodoPago(@RequestBody MetodoPagoEntity metodoPagoEntity) {
        MetodoPagoEntity metodoPagoEntity1 = metodoPagoService.createMetodoPago(metodoPagoEntity);
        if (metodoPagoEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metodoPagoEntity1);
    }

    @DeleteMapping("/deleteMetodoPagoById/{id_metodo_pago}")
    public ResponseEntity<MetodoPagoEntity> deleteMetodoPagoById(@PathVariable("id_metodo_pago") Integer id_metodo_pago) {
        MetodoPagoEntity metodoPagoEntity = metodoPagoService.getMetodoPagoById(id_metodo_pago);
        if (metodoPagoEntity == null) {
            return ResponseEntity.notFound().build();
        }
        metodoPagoService.deleteMetodoPago(metodoPagoEntity);
        return ResponseEntity.ok(metodoPagoEntity);
    }
}
