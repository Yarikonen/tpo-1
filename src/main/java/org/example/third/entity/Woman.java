package org.example.third.entity;

import org.example.third.entity.enums.GamblerType;
import org.example.third.entity.enums.HeartType;
import org.example.third.interfaces.Reflector;
import org.example.third.interfaces.Speaker;

public class Woman extends Creature implements Speaker, Reflector {
    @Override
    public boolean isReal() {
        return super.getHeartType()== HeartType.TIMID && super.getGamblerType()== GamblerType.TIMID;
    }

    public Woman(String name, HeartType heartType, GamblerType gamblerType) {
        super(heartType,name,gamblerType);
    }

    @Override
    public void speak() {
        System.out.println(super.heartBeat());
        System.out.println(super.gamble());
        if (isReal()) {
            System.out.println("Поэтому - я крутая настоящая женщина");
        }
        else {
            System.out.println("Поэтому - я обычная женщина");
        }

    }
}
