public interface SpaceShip {


    boolean launch();
    //returns true or false based on success of launch

    boolean land();
    //returns true or false based on success of landing

    boolean canCarry(Item item);
    //true if rocket can carry item
    //and false if it exceeds the weight limit

    void carry(Item item);
    //udpates the current weight of the rocket


}
