public class Rocket implements SpaceShip {
    int cost;
    int rocketWeight;
    int currentWeight;
    int maxWeight;
    double chanceOfLaunchFailure;
    double chanceOfLandFailure;


    public boolean launch(){
        double random = Math.random()*100+1;
        double chanceOfLaunchFailure = this.chanceOfLaunchFailure * (double)currentWeight / ((double)maxWeight);
        if(random <= chanceOfLaunchFailure){
            return false;
        }
        return true;
    }

    public boolean land(){
        double random = (int)(Math.random()*100+1);
        double chanceOfLandFailure = this.chanceOfLandFailure * (double)currentWeight / ((double)maxWeight);
        if(random <= chanceOfLandFailure){
            return false;
        }
        return true;
    }

    public final boolean canCarry(Item item){

        if(currentWeight + item.weight > maxWeight){
            return false;
        }
        return true;
    }

    public final void carry(Item item){

        currentWeight += item.weight;
    }

}
