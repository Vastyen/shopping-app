package com.backend.backend.Controllers;

import com.backend.backend.Entities.PagoEntity;
import com.backend.backend.Services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PagoController {
    @Autowired
    PagoService pagoService;

    @GetMapping("/getPagoById/{id_pago}")
    public ResponseEntity<PagoEntity> getPagoById(@PathVariable("id_pago") Integer id_pago) {
        PagoEntity pagoEntity = pagoService.getPagoById(id_pago);
        if (pagoEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pagoEntity);
    }

    @PutMapping("/updatePagoById/{id_pago}")
    public ResponseEntity<PagoEntity> updatePagoById(@PathVariable("id_pago") Integer id_pago, @RequestBody PagoEntity pagoEntity) {
        PagoEntity pagoEntity1 = pagoService.getPagoById(id_pago);
        if (pagoEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        pagoService.savePago(pagoEntity);
        return ResponseEntity.ok(pagoEntity);
    }

    @PostMapping("/createPago")
    public ResponseEntity<PagoEntity> createPago(@RequestBody PagoEntity pagoEntity) {
        PagoEntity pagoEntity1 = pagoService.createPago(pagoEntity);
        if (pagoEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pagoEntity1);
    }

    @DeleteMapping("/deletePagoById/{id_pago}")
    public ResponseEntity<PagoEntity> deletePagoById(@PathVariable("id_pago") Integer id_pago) {
        PagoEntity pagoEntity = pagoService.getPagoById(id_pago);
        if (pagoEntity == null) {
            return ResponseEntity.notFound().build();
        }
        pagoService.deletePago(pagoEntity);
        return ResponseEntity.ok(pagoEntity);
    }
}
