package factories;

import models.Vehicle;
import models.Car;
import models.MiniTruck;
public class VehicleFacotry {

    public static Vehicle creatVehicle(int number, int size) {
        if(size == 2) {
            return new Car(number);
        } else if(size == 3){
            return new MiniTruck(number);
        } else {
            throw new IllegalArgumentException("Car slot for this size is not available");
        }
    }

}
