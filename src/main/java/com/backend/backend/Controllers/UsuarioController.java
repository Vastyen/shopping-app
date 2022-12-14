package com.backend.backend.Controllers;

import com.backend.backend.Entities.UsuarioEntity;
import com.backend.backend.Services.UsuarioEmpresaService;
import com.backend.backend.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.Period;
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

    @PutMapping("/updateUsuario")
    public ResponseEntity<UsuarioEntity> updateUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        UsuarioEntity usuarioEntity1 = usuarioService.updateUsuario(usuarioEntity);
        if (usuarioEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEntity1);
    }

    @PostMapping("/RegistroUsuario")
    public ResponseEntity<UsuarioEntity> createUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        UsuarioEntity usuarioEntity1 = usuarioService.createUsuario(usuarioEntity);
        if (usuarioEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEntity1);
    }

    @GetMapping("/login/{correo}/{contrasena}")
    public ResponseEntity<String> findByCorreo(@PathVariable("correo") String correo, @PathVariable("contrasena") String contrasena) {

        UsuarioEntity user = usuarioService.findByCorreoAndContrasena(correo, contrasena);

        if (user == null) {
            return ResponseEntity.ok("USUARIO O CONTRASEÑA INCORRECTAS / EL USUARIO NO EXISTE");

        }
        return ResponseEntity.ok("USUARIO LOGUEADO EXITOSAMENTE");
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

    @GetMapping("/showEmpresasByIdUsuario/{id_usuario}")
    public String showEmpresasByIdUsuario(@PathVariable("id_usuario") Integer id_usuario) {
        UsuarioEntity usuarioEntity = usuarioService.getUsuarioById(id_usuario);
        if (usuarioEntity == null) {
            return null;
        }
        LocalDate ahora = LocalDate.now();
        Period edad = Period.between(usuarioEntity.getFecha_nacimiento(), ahora);
        if(edad.getYears() < 18) {
            return "redirect:/empresa/getEmpresasMenor18";
        }
        else{
            return "redirect:/empresa/getAllEmpresas";
        }
    }
    @GetMapping("/addProductoToMyCart/{id_usuario}/{id_producto}/{cantidad}")
    public String addProductoToMyCart(@PathVariable("id_usuario") Integer id_usuario, @PathVariable("id_producto") Integer id_producto, @PathVariable("cantidad") Integer cantidad) {
        UsuarioEntity usuarioEntity = usuarioService.getUsuarioById(id_usuario);
        if (usuarioEntity == null) {
            return null;
        }
        return "redirect:/carritoCompras/addProductoToMyCart/" + id_usuario + "/" + id_producto + "/" + cantidad;
    }
}
