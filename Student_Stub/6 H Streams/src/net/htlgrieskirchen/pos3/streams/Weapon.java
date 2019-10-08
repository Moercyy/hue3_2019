package net.htlgrieskirchen.pos3.streams;

import net.htlgrieskirchen.pos3.streams.CombatType;
import net.htlgrieskirchen.pos3.streams.DamageType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Weapon {
    private String name;
    private CombatType weaponType;
    private DamageType damageType;
    private int damage, speed, strength, value;
    List<Weapon> weapons = new ArrayList<>();

    public Weapon(String name, CombatType weaponType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.weaponType = weaponType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }

    public Weapon() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CombatType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(CombatType weaponType) {
        this.weaponType = weaponType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public List<Weapon> readCSV(String filename){
        try {
            weapons =  Files.lines(new File(filename).toPath())
                    .skip(1)
                    .map(s -> s.split(";"))
                    .map(s -> new Weapon(
                            s[0],
                            CombatType.valueOf(s[1]),
                            DamageType.valueOf(s[2]),
                            Integer.parseInt(s[3]),
                            Integer.parseInt(s[4]),
                            Integer.parseInt(s[5]),
                            Integer.parseInt(s[6])
                    )).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        weapons.stream()
                //.sorted(Comparator.comparingInt(Weapon::getDamage))
                .sorted(Comparator.comparing(Weapon::getWeaponType))
                .collect(Collectors.toList());

        return weapons;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weaponType, damageType, damage, speed, strength, value, weapons);
    }

    @Override
    public String toString() {
        return name + "\t" + weaponType + "\t" + damageType + "\t" + damage+ "\t" +speed+ "\t" +strength+ "\t" +value;
    }

}
