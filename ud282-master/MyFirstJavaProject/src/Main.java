public class Main {
    public static void main(String [] args){

        ContactsManager myContactManager = new ContactsManager();

        Contact ania = new Contact();
        ania.name = "Ania";
        ania.phoneNumber = "2014437920";
        myContactManager.addContact(ania);

        Contact adam = new Contact();
        adam.name = "Adam";
        adam.phoneNumber = "9334056788";
        myContactManager.addContact(adam);

        Contact dulce = new Contact();
        dulce.name = "Dulce";
        dulce.phoneNumber = "7896453023";
        myContactManager.addContact(dulce);

        Contact foundContact = myContactManager.searchContact("Dulce");
        System.out.println(foundContact.phoneNumber);

    }
}
