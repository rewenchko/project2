package CreazyStation;

public class CrazyStation {
    public static void main (String[] args){

        // Setup
        Station hamburg = new Station ("Hamburg");
        Station berlin = new Station ("Berlin");
        Station cologne = new Station ("Cologne");
        Station munich = new Station ("Munich");

        CentralStation frankfurt = new CentralStation("Frankfurt");

        Train munich_frankfurt = new Train(munich, frankfurt);
        Train hamburg_frankfurt = new Train(hamburg, frankfurt);
        Train berlin_frankfurt = new Train(berlin, frankfurt);
        Train cologne_frankfurt = new Train(cologne, frankfurt);

        hamburg.addTrain(hamburg_frankfurt);
        munich.addTrain(munich_frankfurt);
        cologne.addTrain(cologne_frankfurt);
        berlin.addTrain(berlin_frankfurt);
        frankfurt.addTrain(hamburg_frankfurt);
        frankfurt.addTrain(munich_frankfurt);
        frankfurt.addTrain(cologne_frankfurt);
        frankfurt.addTrain(berlin_frankfurt);


        Car c1 = new Car(1, hamburg, cologne);
        Car c2 = new Car(2, hamburg, cologne);
        Car c3 = new Car(3, hamburg, munich);
        Car c4 = new Car(4, hamburg, munich);
        Car c5 = new Car(5, munich, cologne);
        Car c6 = new Car(6, berlin, munich);
        Car c7 = new Car(7, berlin, hamburg);
        Car c8 = new Car(8, cologne, munich);
        Car c9 = new Car(9, munich, cologne);
        Car c10 = new Car(10, munich, berlin);
        Car c11 = new Car(11, cologne, berlin);
        Car c12 = new Car(12, berlin, munich);
        Car c13 = new Car(13, berlin, hamburg);
        Car c14 = new Car(14, berlin, munich);


        hamburg.addCar(c1);
        hamburg.addCar(c2);
        hamburg.addCar(c3);
        hamburg.addCar(c4);
        munich.addCar(c5);
        berlin.addCar(c6);
        berlin.addCar(c7);
        cologne.addCar(c8);
        munich.addCar(c9);
        munich.addCar(c10);
        cologne.addCar(c11);
        berlin.addCar(c12);
        berlin.addCar(c13);
        berlin.addCar(c14);

        System.out.println("__________________Situation at the beginning of the day__________________");
        System.out.println(hamburg.toString());
        System.out.println(berlin.toString());
        System.out.println(munich.toString());
        System.out.println(cologne.toString());

        // Cars get attached to the available trains on those routes
        hamburg.loadTrains();
        cologne.loadTrains();
        munich.loadTrains();
        berlin.loadTrains();

        // Cars get transported from Stations to CentralStation Frankfurt
        frankfurt.unloadTrains();
        System.out.println("__________________Cars transported to the Central Station__________________");
        System.out.println(frankfurt.toString());
        frankfurt.distributeCars();

        // Trains drive with the new attached cars back to the stations
        hamburg.unloadTrains();
        berlin.unloadTrains();
        munich.unloadTrains();
        cologne.unloadTrains();

        // Lets check if all possible cars are at the right station

        System.out.println("__________________transported Cars__________________");
        System.out.println(hamburg.toString());
        System.out.println(berlin.toString());
        System.out.println(munich.toString());
        System.out.println(cologne.toString());

    }
}
