package liftsystem;

import java.util.List;

class LifeSystemModel {
    private LiftSystemView liftSystemView;
    public LifeSystemModel(LiftSystemView liftSystemView) {
        this.liftSystemView=liftSystemView;
    }

    public void createLifts(int n) {
        LiftDatabase.getInstance().createLifts(n);
    }

    public void display() {
        liftSystemView.printList(LiftDatabase.getInstance().getLifts());
    }

    public void assignLift(int currentFloor, int destinationFloor, int passengers) {
        List<Lift> lifts=LiftDatabase.getInstance().getLifts();
        Lift tempLift=null;
        boolean flag=false;
        for(Lift lift:lifts) {
            if (lift.getFloor() == -1) {
                continue;
            }
            if (passengers <= lift.getTotalCapacity()) {
                flag=true;
                if ((currentFloor >= 0 && currentFloor <= 5) && (destinationFloor >= 0 && destinationFloor <= 5)) {
                    flag = true;
                    if (lift.getName().equalsIgnoreCase("l1") || lift.getName().equalsIgnoreCase("l2") || lift.getName().equalsIgnoreCase("l5")) {
                        if (tempLift != null) {
                            int min = Math.abs(currentFloor - lift.getFloor());
                            int minDirected = Math.abs(currentFloor - tempLift.getFloor());
                            if (min == minDirected) {
                                if (currentFloor < lift.getFloor()) {
                                    tempLift = lift;
                                }
                            } else if (min < minDirected) {
                                tempLift = lift;
                            }
                        } else {
                            tempLift = lift;
                        }
                    }
                } else if ((currentFloor == 0 || currentFloor >= 6 && currentFloor <= 10) && (destinationFloor == 0 || destinationFloor >= 6 && destinationFloor <= 10)) {
                    flag = true;
                    if (lift.getName().equalsIgnoreCase("l3") || lift.getName().equalsIgnoreCase("l4") || (destinationFloor != 0 && lift.getName().equalsIgnoreCase("l5"))) {
                        if (tempLift != null) {
                            int min = Math.abs(currentFloor - lift.getFloor());
                            int minDirected = Math.abs(currentFloor - tempLift.getFloor());
                            if (min == minDirected) {
                                if (currentFloor < lift.getFloor()) {
                                    tempLift = lift;
                                }
                            } else if (min < minDirected) {
                                tempLift = lift;
                            }
                        } else {
                            tempLift = lift;
                        }
                    }
                } else if (((currentFloor >= 0 && currentFloor <= 10) && (destinationFloor >= 0 && destinationFloor <= 10))) {
                    if (lift.getName().equalsIgnoreCase("l5")) {
                        tempLift = lift;
                        flag = true;
                    }
                }
            }
        }
        if(!flag){
            liftSystemView.showAlert("\t\t\tPassengers count exceeds Lift capacity");
            return;
        }
        if(tempLift==null){
            liftSystemView.showAlert("\t\t\tNo Lift is available ,Wait for some time");
            return;
        }
        tempLift.setFloor(destinationFloor);
        System.out.println("\t\t\t"+tempLift.getName()+" is allocated");
        liftSystemView.printList(LiftDatabase.getInstance().getLifts());
    }

    public void setFloor(String name, int floor) {
        LiftDatabase.getInstance().setFloor(name,floor);
    }

    public void setMaintenence(String name) {
        LiftDatabase.getInstance().setMaintenence(name);
    }

    public void setCapacity(int[] arr, int n) {
        LiftDatabase.getInstance().setCapacity(arr,n);
    }
}





