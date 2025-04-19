// src/main/java/com/academy/smartcommunity/service/WeaknessService.java
package com.academy.smartcommunity.service;

import java.util.List;

import com.academy.smartcommunity.model.Weakness;

public interface WeaknessService {
    List<Weakness> getWeaknessesByStudent(Long studentId);
    Weakness getWeaknessById(Long id);
    Weakness createWeakness(Weakness weakness);
    Weakness updateWeakness(Long id, Weakness weakness);
    void deleteWeakness(Long id);
}
