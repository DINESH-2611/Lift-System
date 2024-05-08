package liftsystem;

import java.util.List;
import java.util.Scanner;

public class LiftSystemView {
    private LifeSystemModel lifeSystemModel;
    public LiftSystemView(){
        this.lifeSystemModel=new LifeSystemModel(this);
    }
    void init() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of lifts");
        int n=Integer.parseInt(sc.nextLine());
        lifeSystemModel.createLifts(n);
        setCapacity(sc,n);
        lifeSystemModel.display();
        while (true) {
            System.out.println("""
                Enter the choice
               1.Display the Lifts
               2.Use Lift\s
               3.Manual Assign floor\s
               4.Put Lift Under maintenence\s
               5.Exit""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    lifeSystemModel.display();
                    break;
                case 2:
                    getFloors(sc);
                    break;
                case 3:
                    setFloor(sc);
                    break;
                case 4:
                    setMaintenence(sc);
                    break;
                case 5:
                    showAlert("\t\t\tThank You");
                    break;
                default:
                    System.out.println("\t\t\tInvalid choice,Enter valid choice");
                    break;
            }
            if (choice == 5)
                break;
        }
    }

    private void setCapacity(Scanner sc, int n) {
        int[] arr=new int[n];
      for (int i=0;i<n;i++){
          System.out.println("Enter the capacity of lift L"+(i+1));
          arr[i]=Integer.parseInt(sc.nextLine());
      }
        lifeSystemModel.setCapacity(arr,n);
    }

    private void setMaintenence(Scanner sc) {
        System.out.println("Enter the lift name");
        String name=sc.nextLine();
        lifeSystemModel.setMaintenence(name);
    }

    private void setFloor(Scanner sc) {
        System.out.println("Enter the lift name");
        String name=sc.nextLine();
        System.out.println("Enter the floor ");
        int floor=Integer.parseInt(sc.nextLine());
        lifeSystemModel.setFloor(name,floor);
    }

    private void getFloors(Scanner sc) {
        System.out.println("Enter current floor");
        int currentFloor=Integer.parseInt(sc.nextLine());
        System.out.println("Enter destination floor");
        int destinationFloor=Integer.parseInt(sc.nextLine());
        System.out.println("Enter no of persons");
        int passengers=Integer.parseInt(sc.nextLine());
        lifeSystemModel.assignLift(currentFloor,destinationFloor,passengers);
    }

    void printList(List<Lift> liftList) {
        System.out.print("Lift  :");
        for (Lift lift : liftList)
            System.out.print(lift.getName() + " ");
        System.out.println();
        System.out.print("Floor :");
        for (Lift lift : liftList)
            System.out.print(lift.getFloor() + "  ");
        System.out.println();
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }
}
