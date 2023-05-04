package org.example;

import java.util.Objects;

public class Car {

    private String carNo;

    private Color color;

    public Car(String carNo, Color color) {
        this.carNo = carNo;
        this.color = color;
    }

    public Boolean isOfColor(Color desiredColor){

        return desiredColor == this.color;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carNo, car.carNo) && color == car.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNo, color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNo='" + carNo + '\'' +
                ", color=" + color +
                '}';
    }
}
