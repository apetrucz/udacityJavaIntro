public class U1 extends Rocket {


    U1(){
        cost = 100;
        rocketWeight = 10000;
        maxWeight = 18000;
        currentWeight += rocketWeight;
        chanceOfLaunchFailure = 5;
        chanceOfLandFailure = 1;
    }
}
