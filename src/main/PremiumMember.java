public class PremiumMember extends Member {

    /**
     * Constructor for objects of class Member.
     *
     * @param email    Member email
     * @param name     Member name
     * @param address  Member address
     * @param gender   Member gender
     * @param height   Member height
     * @param chosenPackage Members chosenPackage
     * @param startWeight   Members startingWeight
     */
    public PremiumMember(String email, String name, String address, String gender, double height, double startWeight, String chosenPackage) {
        super(email, name, address, gender, height, startWeight, chosenPackage);
    }
    @Override
    public String display(){
        return super.display();
    }
}
