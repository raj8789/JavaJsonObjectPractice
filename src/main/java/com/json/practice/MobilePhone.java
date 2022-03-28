package com.json.practice;

public class MobilePhone {

    private String brand;
    private String name;
    private int ram;
    private int rom;

    @Override
    public String toString() {
        return "MobilePhone{" +
                "brand :'" + brand + '\'' +
                ", name :'" + name + '\'' +
                ", ram :" + ram +
                ", rom :" + rom +
                '}';
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
