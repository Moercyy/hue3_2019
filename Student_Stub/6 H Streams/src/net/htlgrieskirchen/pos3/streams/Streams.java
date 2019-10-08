package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {

    public double average(int[] numbers) {
        numbers = getRandomNumbers();
        return Arrays.stream(numbers).average().orElse(Double.NaN);
    }
    
    public List<String> upperCase(String[] strings) {
        strings = getRandomStrings();
        return Arrays.asList(strings).stream().map(String::toUpperCase).collect(Collectors.toList());
    }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        weapons = getWeaponList();
        Weapon w = weapons.stream()
                .sorted((w1, w2) -> w2.getDamage() - w1.getDamage())
                .findFirst()
                .get();
        return w;

    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        weapons = getWeaponList();
        Weapon w = weapons.stream()
                .sorted(Comparator.comparingInt(Weapon::getStrength))
                .findFirst()
                .get();
        return w;
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        weapons = getWeaponList();
        return weapons.stream()
                .filter(n -> n.getWeaponType().toString().equals("MISSILE"))
                .collect(Collectors.toList());
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        weapons = getWeaponList();
        return weapons.stream()
                .max(Comparator.comparingInt(n -> n.getName().length()))
                .get();
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        weapons = getWeaponList();
        return weapons.stream()
                .map(n -> n.getName())
                .collect(Collectors.toList());
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
        weapons = getWeaponList();
        int[] speeds = weapons.stream()
                .mapToInt(n -> n.getSpeed())
                .toArray();
        return speeds;
    }
    
    public int sumUpValues(List<Weapon> weapons) {
        weapons = getWeaponList();
        int sum = weapons.stream()
                .mapToInt(i -> i.getValue()).sum();
        return sum;

    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        weapons = getWeaponList();
        long sum = weapons.stream()
                .mapToLong(n -> n.hashCode())
                .sum();
        return sum;
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        weapons = getWeaponList();
        return weapons.stream()
                .distinct()
                .collect(Collectors.toList());
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons = getWeaponList();
        weapons.stream()
                .mapToDouble(n -> n.getValue()*1.1);
    }

    public int[] getRandomNumbers(){
        int[] array = new int[1000];
        for (int i = 1; i <= array.length ; i++)
        {
            int random = (int)(Math.random()*100);
            array[i] = random;
        }
        return array;
    }
    public String[] getRandomStrings(){
        String[] strings = new String[10];
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(strings.length);

        for (int i = 0; i < strings.length; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
            strings[i] = sb.toString();
        }
        return strings;
    }
    public List<Weapon> getWeaponList(){
        Weapon weapon = new Weapon();
        return weapon.weapons;
    }

}
