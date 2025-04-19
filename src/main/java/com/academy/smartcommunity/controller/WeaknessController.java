// src/main/java/com/academy/smartcommunity/controller/WeaknessController.java
package com.academy.smartcommunity.controller;

import com.academy.smartcommunity.model.Weakness;
import com.academy.smartcommunity.service.WeaknessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/weaknesses")
public class WeaknessController {

    private final WeaknessService service;

    public WeaknessController(WeaknessService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Weakness>> list(@RequestParam Long studentId) {
        return ResponseEntity.ok(service.getWeaknessesByStudent(studentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weakness> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getWeaknessById(id));
    }

    @PostMapping
    public ResponseEntity<Weakness> create(@RequestBody Weakness weakness) {
        return ResponseEntity.ok(service.createWeakness(weakness));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Weakness> update(@PathVariable Long id,
                                           @RequestBody Weakness weakness) {
        return ResponseEntity.ok(service.updateWeakness(id, weakness));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteWeakness(id);
        return ResponseEntity.noContent().build();
    }
}
