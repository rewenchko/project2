package CreazyStation;


public class Train {
    private Station station;
    private CentralStation central;
    private Car[] cars;

    public Train(){};

    public Train(Station station, CentralStation central){
        this.central = central;
        this.station = station;
        this.cars = new Car[1];
    }

    public Station getStation (){
        return station;
    }

    public CentralStation getCentral () {
        return central;
    }

    public boolean addCar (Car c){
        if (cars == null){
            cars = new Car[1];
            cars [0] = c;
            return true;
        } else if (cars.length == 1 && cars[0] == null){
            cars [0] = c;
            return true;
        } else {
            Car[] newArray = new Car[cars.length+1];
            for (int i = 0; i < cars.length; i++ ){
                newArray[i] = cars[i];
            }
            newArray [cars.length] = c;
            cars = newArray;
            return true;
        }
    }

    public Car removeCar (){
        if (cars.length == 0){
            return null;
        }
        Car car = cars[cars.length-1];
        Car[] newArray = new Car[cars.length-1];
        for (int i = 0; i < cars.length-1; i++ ){
            newArray[i] = cars[i];
        }
        cars = newArray;
        return car;
    }
}
