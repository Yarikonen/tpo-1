package org.example.third.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.third.entity.enums.GamblerType;
import org.example.third.entity.enums.HeartType;
import org.example.third.interfaces.Gambler;
import org.example.third.interfaces.Viable;

@AllArgsConstructor
public class Creature implements Viable, Gambler {

    @Getter
    private HeartType heartType;
    private String name;
    @Getter
    @Setter
    private GamblerType gamblerType;

    Creature(String name){
        this.name = name;
    }

    @Override
    public String heartBeat() {
        return String.format("Моё сердце бьеться %1$s", (switch(heartType){
            case BRAVE -> "отважно";
            case ORDINARY -> "сомнительно, но окей";
            case TIMID -> "так как оно чувствует";
        }));
    }

    public void setHeartType(String heartType) {
        try{
            this.heartType = HeartType.valueOf(heartType.toUpperCase());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Неизвестный тип сердца");
        }
    }

    public void setGamblerType(String gamblerType) {
        try{
            this.gamblerType = GamblerType.valueOf(gamblerType.toUpperCase());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Неизвестный тип игрока");
        }
    }

    @Override
    public String gamble() {
        return String.format("Я - %1$s, и я играю %2$s", name, (switch(gamblerType){
            case BRAVE -> "и ставлю всё на зеленое";
            case ORDINARY -> "в блекджек";
            case TIMID -> "в русскую рулетку";
        }));
    }
}
