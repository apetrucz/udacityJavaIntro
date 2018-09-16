
public class U2 extends Rocket {

    U2(){
        cost = 120;
        rocketWeight = 18000;
        maxWeight = 29000;
        currentWeight += rocketWeight;
        chanceOfLaunchFailure = 4;
        chanceOfLandFailure = 8;
    }
}
