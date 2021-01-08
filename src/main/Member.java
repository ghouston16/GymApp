/* THIS CODE IS INCOMPLETE */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;

public class Member extends Person {
    public double height;
    public double startWeight;
    private String chosenPackage;
    public HashMap<String, Assessment> assessmentHashMap;
//    private SortedSet<String> sortedAssessmentDates; TODO

    /**
     * Constructor for objects of class Member.
     * @param email    Member email
     * @param name     Member name
     * @param address  Member address
     * @param gender   Member gender
     * @param height   Member height
     * @param chosenPackage Members chosenPackage
     * @param startWeight   Members startingWeight
     */
    public Member(String email, String name, String address,
                  String gender, double height, double startWeight, String chosenPackage) {
        super(email, name, address, gender);
        setHeight(height);
        setStartWeight(startWeight);
        setChosenPackage(chosenPackage);
        assessmentHashMap = new HashMap<>();
    }

    public Member(String email, String name, String address, String gender,
                  double height, double startWeight, HashMap chosenPackage, HashMap assessmentHashMap)
    {
        super(email, name, address, gender);
        setHeight(height);
        setStartWeight(startWeight);
        this.assessmentHashMap = assessmentHashMap;
    }

    public double getHeight(){
            return height;
    }

    public void setHeight(double height) {
        if ((height >= 1) && (height <= 3)) {
            this.height = height;
        }
        if (height > 3) {
            System.out.print(" Height not valid");
            height = 3;
        } else if (height < 1) {
            this.height = 1;
        }
    }

    public double getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(double startWeight) {
        if ((startWeight >= 35) && (startWeight <= 250)) {
            this.startWeight=startWeight;
        }
        if (startWeight < 35) {
            this.startWeight = 35;
        }
        if  (startWeight>=250){
            this.startWeight = 250;
        }

    }
    public String getChosenPackage() {
        return chosenPackage;
    }

    public void setChosenPackage(String chosenPackage) {
        this.chosenPackage = chosenPackage;

    }

    @Override
    public String display() {
        return super.display() +
                "Height: " + height  + ", " +
                "StartWeight: " + startWeight + ", " +
                "ChosenPackage: " + chosenPackage;
    }
}

