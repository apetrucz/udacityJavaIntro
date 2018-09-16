import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {



    public ArrayList loadItems(File file) throws Exception{
        Scanner fileScanner = new Scanner(file);
        ArrayList<Item> loadedItems = new ArrayList<>();
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            int equal = line.indexOf('=');
            loadedItems.add(new Item(line.substring(0,equal), Integer.parseInt(line.substring(equal+1))));
        }
        return loadedItems;
    }

    public ArrayList loadU1(ArrayList<Item> items){
        ArrayList<U1> U1Rockets = new ArrayList<>();
        U1Rockets.add(new U1());
        int currentRocket = 0;
        int size = items.size();
        for(int i=0; i<size; i++){
            if(U1Rockets.get(currentRocket).canCarry(items.get(i))){
                U1Rockets.get(currentRocket).carry(items.get(i));
            }
            else{
                U1Rockets.add(new U1());
                currentRocket ++;
            }
        }

        return U1Rockets;
    }

    public ArrayList loadU2(ArrayList<Item> items){
        ArrayList<U2> U2Rockets = new ArrayList<>();
        U2Rockets.add(new U2());
        int currentRocket = 0;
        int size = items.size();
        for(int i=0; i<size; i++){
            if(U2Rockets.get(currentRocket).canCarry(items.get(i))){
                U2Rockets.get(currentRocket).carry(items.get(i));
            }
            else{
                U2Rockets.add(new U2());
                currentRocket ++;
            }
        }

        return U2Rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets){
        int totalBudget = 0;
        int currentRocket = 0;
        int size = rockets.size();
        int i = 0;
        while(i<size){
            totalBudget += rockets.get(i).cost;
            if(!(rockets.get(i).launch() && rockets.get(i).land())){
                i--;
            }
            i++;
        }
        return totalBudget;
    }

}
