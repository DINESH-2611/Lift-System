package liftsystem;

import java.util.ArrayList;
import java.util.List;

public class LiftDatabase {
    private static LiftDatabase database;
    private List<Lift> liftList=new ArrayList<>();
    public static LiftDatabase getInstance(){
        if(database==null){
            database=new LiftDatabase();
        }
        return database;
    }

    public void createLifts(int n) {
        for(int i=1;i<=n;i++){
            liftList.add(new Lift("L"+i));
        }
    }
    public List<Lift> getLifts(){
        return liftList;
    }

    public void setFloor(String name, int floor) {
        for(Lift lift:liftList){
            if(lift.getName().equalsIgnoreCase(name)){
                lift.setFloor(floor);
                break;
            }
        }
    }

    public void setMaintenence(String name) {
        for(Lift lift:liftList){
            if(lift.getName().equalsIgnoreCase(name)){
                lift.setFloor(-1);
                break;
            }
        }
    }

    public void setCapacity(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            liftList.get(i).setTotalCapacity(arr[i]);
        }
    }
}
