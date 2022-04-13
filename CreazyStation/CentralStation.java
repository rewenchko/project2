package CreazyStation;

public class CentralStation{

    public CentralStation(String name){
        this.name = name;
        storage = new Car[1];
        trains = new Train[1];
    }

    public CentralStation(String name, Train train){
        this.name = name;
        storage = new Car[1];
        trains = new Train[1];
        trains [1] = train;
    }

    public CentralStation(String name, Train[] trains){
        this.name = name;
        storage = new Car[1];
        this.trains = trains;
    }

    private Car[] storage;
    private Train[] trains;
    private String name;

    public void addTrain (Train c) {
        if (trains[0] == null) {
            trains[0] = c;
        } else {
            Train[] newArray = new Train[trains.length + 1];
            for (int i = 0; i < trains.length; i++) {
                newArray[i] = trains[i];
            }
            newArray[trains.length] = c;
            trains = newArray;
        }
    }

    public boolean addCar (Car c){
        if (storage[0] == null){
            storage [0] = c;
            return true;
        } else {
            Car[] newArray = new Car[storage.length+1];
            for (int i = 0; i < storage.length; i++ ){
                newArray[i] = storage[i];
            }
            newArray [storage.length] = c;
            storage = newArray;
            return true;
        }
    }

    public Car removeCar (){
        if (storage.length == 0){
            return null;
        }
        Car car = storage[storage.length-1];
        Car[] newArray = new Car[storage.length-1];
        for (int i = 0; i < storage.length-1; i++ ){
            newArray[i] = storage[i];
        }
        storage = newArray;
        return car;
    }

    public void loadTrains (){
        Car c = removeCar();
        while (c != null){
            for (Train t: trains) {
                while (c != null) {
                    if (t.addCar(c)) {
                        c = removeCar();
                    } else {
                        break;
                    }
                }
            }
            c = removeCar();
        }
        storage = new Car[1];
    }

    public void unloadTrains () {

        for (Train t: trains){
            Car c = t.removeCar();
            while (c!=null){
                addCar(c);
                c = t.removeCar();
            }
        }
    }

    public String toString () {
        String s;
        s = name + ":\n";
        for (Car c: storage){
            s += c.toString() + "\n";
        }
        return s;
    }

    public Car[] getStorage (){return storage; }

    public void setStorage (Car[] sorted){
        storage = sorted;
    }

    public Train[] getTrains ()  { return trains; }

    public String getName() { return name; }

    public void distributeCars (){
        Car[] notDistributable = new Car[1];
        while (storage.length != 0){
            Car c = removeCar();
            for (Train t: getTrains()){
                if (t.getStation().getName() == c.getTarget().getName()){
                    if (t.addCar(c)){
                        break;
                    } else {
                        if (c != null){
                            if (notDistributable[0] == null) {
                                notDistributable[0] = c;
                            } else {
                                Car[] newArray = new Car[notDistributable.length + 1];
                                for (int i = 0; i < notDistributable.length; i++) {
                                    newArray[i] = notDistributable[i];
                                }
                                newArray[notDistributable.length] = c;
                                notDistributable = newArray;
                            }
                        }
                    }
                }
            }
        }
        storage = new Car[1];
    }
}
