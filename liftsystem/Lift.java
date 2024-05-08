package liftsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lift {
    private String name;
    private int floor;
    private int totalCapacity;

    public Lift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

}

class LiftApp {
    private List<Lift> lifts = new ArrayList<>();

    public static void main(String[] args) {
        new LiftApp().init();
    }

    private void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of lifts");
        int n = Integer.parseInt(sc.nextLine());
//        for (int i = 0; i < n; i++) {
//            System.out.println("Enter Name of the lift "+(i+1));
//           String name=sc.nextLine();
//            System.out.println("Enter the position of lift "+(i+1));
//            int floor= Integer.parseInt(sc.nextLine());
//            System.out.println("Enter the total capacity of lift "+(i+1));
//            int totalCapacity=Integer.parseInt(sc.nextLine());
//            Lift lift=new Lift();
//            lift.setName(name);
//            lift.setFloor(floor);
//            lift.setTotalCapacity(totalCapacity);
//            lifts.add(lift);
//        }
//        lifts.add(new Lift("L1", 0,5));
//        lifts.add(new Lift("L2", 0,5));
//        lifts.add(new Lift("L3", 9,10));
//        lifts.add(new Lift("L4", 7,4));
//        lifts.add(new Lift("L5", 8,8));
        printList();
        while (true) {
            System.out.println("1.Display position of the lift\n2.Assign lift to the user\n3.Assign to the nearest lift\n5.Assign lift in the same direction\nEnter the choice");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    getFloorDetails(sc);
                    break;
                case 2:
                    maintainLift(sc);
                    break;
                case 3:
                    assignLiftFloor(sc);
                    break;
                case 4:
                    System.out.println("\t\t\tThank You...");
                    break;
                default:
                    System.out.println("\t\t\tInvalid choice,Enter valid choice");
                    break;
            }
            if (choice == 4)
                break;
        }
    }

    private void assignLiftFloor(Scanner sc) {

    }

    private void maintainLift(Scanner sc) {
        System.out.println("Enter the lift name");
        String name = sc.nextLine();
        for (Lift lift : lifts) {
            if (lift.getName().equals(name)) {
                lift.setFloor(-1);
            }
        }
        System.out.println("\t\t\t" + name + " is under maintenence");
    }

    private void getFloorDetails(Scanner sc) {
        System.out.println("Enter current floor");
        int currentFloor = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Destination Floor");
        int destinationFloor = Integer.parseInt(sc.nextLine());
        System.out.println("Enter no of passengers");
        int passengers = Integer.parseInt(sc.nextLine());
        allocateLift(currentFloor, destinationFloor, passengers);
    }

    private void allocateLift(int currentFloor, int destinationFloor, int passengers) {
        List<Lift> nearLift = new ArrayList<>();
        int min = 100;
        String name = "";
        for (Lift lift : lifts) {
            if (lift.getFloor() != -1)
                min = Math.min(min, Math.abs(currentFloor - lift.getFloor()));
        }

        System.out.println(min);
        int minStop = 100;
        Lift lift1 = null;
        for (Lift lift : lifts) {
            if (min + 1 >= Math.abs(currentFloor - lift.getFloor())) {
                int stops = getStops(lift.getName(), lift.getFloor(), destinationFloor);
                if (stops < minStop) {
                    nearLift.add(lift);
//                    lift.setNoOfStops(stops);
                    lift1 = lift;
                    minStop = stops;
                }
            }
        }
        if (lift1 != null) {
            if (lift1.getTotalCapacity() >= passengers) {
                System.out.println("abc");
                System.out.println("\t\t\t" + lift1.getName() + " is assigned");
                for (Lift lift : lifts) {
                    if (lift.getName().equals(name)) {
                        if (lift.getTotalCapacity() >= passengers) {
                            lift.setFloor(destinationFloor);
                            name = "";
                            printList();
                            return;
                        }
                    }
                }
//                System.out.println("\t\t\tPassengers count exceeds "+lift1.getName()+" Total count");
            }
            if (nearLift.size() == 0) {
                System.out.println("\t\t\tNo lift is free now,Please wait for some time");
                return;
            }
            for (Lift lift : nearLift) {
                System.out.println(lift.getName());
            }
            System.out.println(nearLift.size());

            if (currentFloor > destinationFloor) {
                for (Lift lift : nearLift) {
                    if (lift.getFloor() > currentFloor) {
                        name = lift.getName();
                    }
                }
                if (name != "") {
                    System.out.println("\t\t\t" + name + " is assigned");
                    for (Lift lift : lifts) {
                        if (lift.getName().equals(name)) {
                            if (lift.getTotalCapacity() >= passengers) {
                                lift.setFloor(destinationFloor);
                                name = "";
                                printList();
                            }
                        }
                    }
                } else {
                    name = nearLift.get(0).getName();
                    System.out.println("\t\t\t" + name + " is assigned");
                    for (Lift lift : lifts) {
                        if (lift.getName().equals(name)) {
                            lift.setFloor(destinationFloor);
                        }
                    }
                    name = "";
                    printList();
                }
            } else {
                for (Lift lift : nearLift) {
                    if (lift.getFloor() < currentFloor) {
                        name = lift.getName();
                        break;
                    }
                }
                if (name != "") {
                    System.out.println("\t\t\t" + name + " is assigned");
                    for (Lift lift : lifts) {
                        if (lift.getName().equals(name)) {
                            lift.setFloor(destinationFloor);
                        }
                    }
                    name = "";
                    printList();
                }
            }
        }
    }




    private int getStops(String name, int current, int destination){
            if (name.equals("L1") || name.equals("L2")) {
                if (current <= 5) {
                    if (destination <= 5)
                        return Math.abs(current - destination) - 1;
                    else
                        return 5 - current;
                } else {
                    if (destination <= 5)
                        return 5 - current;
                    else
                        return 0;
                }
            } else if (name.equals("L3") || name.equals("L4")) {
                if (current <= 5) {
                    if (destination <= 5)
                        return 0;
                    else
                        return destination - 6;
                } else {
                    if (destination <= 5)
                        return current - 6;
                    else
                        return (current - 6) - 1;
                }
            } else {
                return Math.abs(destination - current) + 1;
            }
        }

    void printList() {
        System.out.print("Lift  :");
        for (Lift lift : lifts)
            System.out.print(lift.getName() + " ");
        System.out.println();
        System.out.print("Floor :");
        for (Lift lift : lifts)
            System.out.print(lift.getFloor() + "  ");
        System.out.println();
    }
}
