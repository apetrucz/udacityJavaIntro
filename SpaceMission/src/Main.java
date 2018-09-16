import com.sun.deploy.panel.AbstractRadioPropertyGroup;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args) throws Exception{
        Simulation simulation = new Simulation();

        ArrayList<Item> phase1Items = new ArrayList();
        ArrayList<Item> phase2Items = new ArrayList();
        phase1Items = simulation.loadItems(new File("phase-1.txt"));
        phase2Items = simulation.loadItems(new File("phase-2.txt"));
        //conbine items from both phases to one array list
        ArrayList<Item> allItems = new ArrayList<Item>();
        allItems.addAll(phase1Items);
        allItems.addAll(phase2Items);

        ArrayList<Rocket> U1Rockets = new ArrayList();
        ArrayList<Rocket> U2Rockets = new ArrayList();



        U1Rockets = simulation.loadU1(allItems);
        U2Rockets = simulation.loadU2(allItems);


        int budgetU1 = simulation.runSimulation(U1Rockets);
        int budgetU2 = simulation.runSimulation(U2Rockets);
        System.out.println("Budget with U1 Rockets is: " + budgetU1);
        System.out.println("Budget with U2 Rockets is: " + budgetU2);
    }
}
