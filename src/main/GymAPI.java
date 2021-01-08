import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class GymAPI {
    private String name;
    private String email = "";
    private String address = "";
    private String search = "";
    private double height = 0;
    private String gender = " Gender Unspecified ";
    private double startingWeight = 50;
    private String chosenPackage = "";
    private String studentId = "";
    private boolean goodInput = false;
    private boolean goodName = false;
    private boolean goodAddress = false;
    private boolean goodGender = false;
    private boolean goodHeight = false;
    private boolean goodWeight = false;
    private boolean goodPackage = false;
    private boolean goodCollege = false;
    private boolean goodId = false;
    public ArrayList<Member> members;
    public ArrayList<Trainer> trainers;
    private Scanner sc = new Scanner(System.in);
    private Person person = new Person("", "", "", "");
/*    static double INCHES = 0.0254001;
    static double FEET = 0.3048;
    static double CENTIMETERS = 0.01;
    static double METERS = 1;
    private double val, meters, converted;
*/


    public GymAPI() {
        this.members = new ArrayList<Member>();
        this.trainers = new ArrayList<Trainer>();
    }


    public ArrayList<Member> getMembers() {
        {
        }
        return members;
    }


    public void addMember(Member member) {
        members.add(member);
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    /**
     *
     * Utility method to take in details for fields common to Member Class and Sub-classes
     *
     * Scanner takes in email (name, addresss, etc) and performs validation if valid value is passed to relevant
     * field in the member object when called within addMember(Member member) or addMEmber() methods
     *
     * Scanner takes in input and this replaces the existing current field value in the members arraylist
     *
     */
    public void memberDetails() {
        do {
            try {
                sc.nextLine();
                System.out.print("Enter the Member E-Mail:  ");
                email = sc.nextLine();
                if ((email.length() != 0) && (email.length() < 60)) {
                    for (Member member: members) {
                        if (member.getEmail().equals(email)) {
                            goodInput = false;
                            sc.nextLine();
                            System.out.println("Email already in use please try again or login to proceed... ");
                        } else
                            goodInput = true;
                    }
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(" Please enter an e-mail address (60 Chars. Max )");
            }
        } while (!goodInput);
        do {
            try {
                System.out.print("Enter the Member Name:  ");
                name = sc.nextLine();
                if ((name.length() != 0) && (name.length() <= 30)) {
                    goodName = true;
                }
                if (name.length() > 30) {
                    name = name.substring(0, 30);
                    name = sc.nextLine();
                    goodName = true;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.print("Enter the Member Name:  ");
            }
        } while (!goodName);
        do {
            try {
                System.out.print("Enter the Member Address:  ");
                address = sc.nextLine();
                if (address.length() != 0) {
                    goodAddress = true;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Please enter Member address");
            }
        }
        while (!goodAddress);
        System.out.print("Please enter the Member Gender (M/F): ");
        gender = sc.nextLine();
        switch (gender) {
            case "M":
            case "m":
            case "F":
            case "f":
                goodGender = true;
                break;
            default:
                gender = "Gender Unspecified ";
                goodGender = true;
        }
        do {
            try {
                System.out.print("Please enter the Members Height: ");
                height = sc.nextFloat();
                if ((height >= 1) && (height <= 3)) {
                    goodHeight = true;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Please enter height (between. 1-3 metres):  ");
            }
        } while (!goodHeight);
        do {
            try {
                System.out.print("Please enter the Members Starting Weight: ");
                startingWeight = sc.nextFloat();
                if ((startingWeight >= 35) && startingWeight <= 250) {
                    goodWeight = true;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(" Please enter a valid Weight in kgs: ");
            }
        } while (!goodWeight);
        do {
            try {
                sc.nextLine();
                System.out.print("Please enter the Membership Package: ");
                chosenPackage = sc.nextLine();
                if ((chosenPackage.length() != 0) && (chosenPackage.length() <= 30)) {
                    goodPackage = true;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Please Specify Membership Package: ");
            }
        } while (!goodPackage);
    }

    /**
     *
     * Group of methods edit fields related to themselves in the members arraylist
     *
     * Scanner takes in email of user this is checked to 'verify' user & retrieve the Member
     *
     * Scanner takes in input and this replaces the existing current field value in the members arraylist
     *
     *
     */
    public void updateEmail() {
        sc.nextLine();
        System.out.println("Enter Email Address: ");
        String search = sc.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (search.length() != 0) {
                if (members.get(i).getEmail().equals(search)) {
                    Member member = members.get(i);
                    System.out.println("Enter new Email: ");
                    String newEmail = sc.nextLine();
                    sc.nextLine();
                    member.setEmail(newEmail);
                    System.out.println("Members email has been updated to: " + newEmail);
                }
            }
        }
    }
    //Allow update of Member Address
    public void updateAddress() {
        sc.nextLine();
        System.out.println("Enter Email Address: ");
        String search = sc.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (search.length() != 0) {
                if (members.get(i).getAddress().equals(search)) {
                    Member member = members.get(i);
                    System.out.println("Enter new Address: ");
                    String newAddress = sc.nextLine();
                    sc.nextLine();
                    member.setAddress(newAddress);
                    System.out.println("Members Address has been updated to: " + newAddress);
                }
            }
        }
    }
    //Allow update of Member Name
    public void updateName() {
        sc.nextLine();
        System.out.println("Enter your Email Address: ");
        String search = sc.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (search.length() != 0) {
                if (members.get(i).getEmail().equals(search)) {
                    Member member = members.get(i);
                    System.out.println("Enter your new Name: ");
                    String newName = sc.nextLine();
                    member.setName(newName);
                    System.out.println("Members name has been updated to: " + newName);
                }
            }
        }
    }
    // Method to Update Members Gender
    public void updateGender() {
        sc.nextLine();
        System.out.println("Enter Member Email Address: ");
        String search = sc.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (search.length() != 0) {
                if (members.get(i).getEmail().equals(search)) {
                    Member member = members.get(i);
                    System.out.println("Please update Gender (M/F/Unspecified): ");
                    String newGender = sc.nextLine();
                    sc.nextLine();
                    member.setGender(newGender);
                    System.out.println("Members gender is now designated: " +
                            newGender);
                }
            }
        }
    }
    //Method to update height in case of error
    public void updateHeight() {
        sc.nextLine();
        System.out.println("Enter Email Address: ");
        String search = sc.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (search.length() != 0) {
                if (members.get(i).getEmail().equals(search)) {
                    Member member = members.get(i);
                    System.out.println("Please update Height (m): ");
                    double newHeight = sc.nextFloat();
                    sc.nextLine();
                    member.setHeight(newHeight);
                    System.out.println("Members height has been updated to: " +
                            newHeight);
                }
            }
        }
    }
    public void setChosenPackage(){
        System.out.print("\nPlease enter your Package choice (Package 1, 2, 3, WIT): ");
        String packageChoice = sc.nextLine();

    }
    //Method to update height in case of error
    public void updateChosenPackage() {
        sc.nextLine();
        System.out.println("Enter your Address: ");
        String search = sc.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (search.length() != 0) {
                if (members.get(i).getEmail().equals(search)) {
                    Member member = members.get(i);
                    System.out.println("Please update Chosen Package: ");
                    String newPackage = sc.nextLine();
                    sc.nextLine();
                    member.setChosenPackage(newPackage);
                    System.out.println("Members Package has been updated to: " +
                            newPackage);
                }
            }
        }
    }
    /**
     *
     * Method to Allow Trainers only to edit the comments on a given any given
     * user related assessments the members Assesment HashHap
     *
     * System prints list of members to console
     * Scanner take in index of member checks if valid and if so returns member profile
     * System prompts user to input date(key) of assessment to be updated.
     *
     * Scanner takes in input and this replaces the existing current field value in the assessment object
     *
     *
     */

    public void updateComment(){
        trainerCheck();
        System.out.print("Enter the Id No. of the Member you wish to update: ");
        int memberId = sc.nextInt();
        sc.nextLine(); // scanner bug
        sc.nextLine();
        Member member = members.get(memberId);
        if (isValidMemberIndex(memberId)) {
            System.out.println(member.display());
            System.out.println(member.assessmentHashMap.toString());
        }
        if (member.assessmentHashMap.size()!=0) {
            System.out.print("\nPlease enter the date of the assessment to be updated(YY/MM/DD): ");
            String date = sc.nextLine();
            if (member.assessmentHashMap.containsKey(date)){
                member.assessmentHashMap.get(date);
                System.out.print("\nPlease enter your new comment for this Assessment: ");
                String newComment = sc.nextLine();
                member.assessmentHashMap.get(date).setComment(newComment);
            }
        } else
            System.out.println("\nCurrently no assessments to update...");

    }

    /**
     *
     * Method to take in values for fields Member Class and Sub-classes
     *
     * Calls memberDetails() values passed to fields in addMember() and store in ArrayList<Member>
     *
     *
     */
    //method to take in member information from user
    public void addMember() {
        memberDetails();
        addMember(new Member(email, name, address, gender, height, startingWeight, chosenPackage));
    }
    /**
     *
     * Method to take in values for fields Member Class and Sub-classes
     *
     * Calls memberDetails() values passed to fields in addMember() and store in ArrayList<Member>
     *
     * Scanner takes in user input values to fill fields relevant to subclass.
     *
     */
    public void addStudentMember() {
        //dummy read of String to clear the buffer - bug in Scanner class.
        sc.nextLine();
        memberDetails();
        do {
            try {
                System.out.print("Please enter the Members Student I.D. : ");
                studentId = sc.nextLine();
                if ((studentId.length() <= 16) && (studentId.length() != 0)) {
                    studentId = this.studentId;
                    goodId = true;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Please enter an I.D. (Max. 16-digits: ");
            }
        } while (!goodId);
        String collegeName = "";
        do {
            try {
                System.out.print("Please enter the Members College Name: ");
                collegeName = sc.nextLine();
                switch (collegeName) {
                    case "WIT":
                    case "W.I.T":
                    case "wit":
                    case "w.i.t":
                        goodCollege = true;
                    default:
                        collegeName = " W.I.T ";
                }
            } catch (Exception e) {
                sc.nextLine();
            }
        } while (!goodCollege);

        addMember(new StudentMember(email, name, address, gender, height, startingWeight, chosenPackage, studentId, collegeName));
    }
    /**
     *
     * Method to take in values for fields Member Class and Sub-classes
     *
     * Calls memberDetails() values passed to fields in addMember() and store in ArrayList<Member>
     *
     * Scanner takes in user input values to fill fields relevant to subclass.
     *
     */
    public void addPremiumMember() {
        sc.nextLine();
        memberDetails();

        addMember(new PremiumMember(email, name, address, gender, height, startingWeight, chosenPackage));
    }
    /**
     *
     * Method to take in values from user for fields to create Trainer object and add to arraylist
     *
     * Scanner takes in email (name, addresss, etc) and performs validation if valid value is passed to relevant
     * field in the member object
     *
     * Object stored in ArrayList<Trainer>
     *
     */
    public void addTrainer() {
        do {
            try {
                sc.nextLine();
                System.out.print("Enter the Trainer E-Mail:  ");
                email = sc.nextLine();
                if ((email.length() != 0) && (email.length() < 60)) {
                    goodInput = true;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(" Please enter an e-mail address (60 Chars. Max )");
            }
        } while (!goodInput);
        do {
            try {
                sc.nextLine();
                System.out.print("Enter the Trainer Name:  ");
                name = sc.nextLine();
                if ((name.length() != 0) && (name.length() <= 30)) {
                    goodName = true;
                }
                if (name.length() > 30) {
                    name = name.substring(0, 30);
                    name = sc.nextLine();
                    goodName = true;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.print("Enter the Trainer Name:  ");
            }
        } while (!goodName);
        do {
            try {
                System.out.print("Enter the Trainer Address:  ");
                address = sc.nextLine();
                if (address.length() != 0) {
                    goodAddress = true;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Please enter Trainer address");
            }
        }
        while (!goodAddress);
        System.out.print("Please enter the Trainer Gender (M/F): ");
        gender = sc.nextLine();
        switch (gender) {
            case "M":
            case "m":
            case "F":
            case "f":
                goodGender = true;
                break;
            default:
                gender = "Gender Unspecified ";
                goodGender = true;
        }
        System.out.print("Please enter the Trainer's Speciality: ");
        String speciality = sc.nextLine();
        sc.nextLine();
        System.out.println("\nPress any key to continue...");
        sc.nextLine();
        sc.nextLine();

        addTrainer(new Trainer(email, name, address, gender, speciality));
    }

    /**
     *
     * Method to take in values from user for fields to create Assessment object and add to Assessment HashMap
     *
     * System prints out a list of current members and prompts user to enter the id no of user
     *
     * ID is used to locate member object in arraylist.
     *
     * Scanner takes in all values needed to create an assessment object
     *
     * Object stored in Assessement HashMap associated with member object
     *
     */
    public void addAssessment() {
        trainerCheck();
        System.out.print("Enter the id no. of the member: ");
        int memberId = sc.nextInt();
        sc.nextLine(); // scanner bug
        System.out.print("\nPlease enter the date of the assessment (YY/MM/DD): ");
        String date = sc.nextLine();
        System.out.print("Enter the recorded weight (kg): ");
        double weight = sc.nextFloat();
        System.out.print("Enter the thigh measurement (cm): ");
        double thigh = sc.nextFloat();
        System.out.print("Enter the waist measurement (cm): ");
        double waist = sc.nextFloat();
        System.out.print("Enter your comment: ");
        sc.nextLine(); // scanner bug
        String comment = sc.nextLine();
        System.out.print("Enter your name: ");
        sc.nextLine(); // scanner bug
        String trainer = sc.nextLine();
        System.out.println("\nAssessment has been added to the member's account.\n");
        Assessment assessment = new Assessment(date, weight, thigh, waist, comment, trainer);
        members.get(memberId).assessmentHashMap.put(date, assessment);
        try {
            save();
        } catch (Exception e) {
            System.err.println("Error saving file: " +e);
        }
    }

    /**
     *
     * Method uses scanner input and console printing to determine which user Trainer wishes to view
     *
     * Member display() method is called on object
     * Assessment display method is called on assessment hashmap
     *
     * Members details and Assessment history are displayed
     *
     *
     */
    public void displayProfile() { //change this to searchByEmail "for security" and display profile for member & use this method in trainerMenu
        trainerCheck();
        System.out.print("Enter the ID of the Member Profile you want to view: ");
        int memberId = sc.nextInt();
        sc.nextLine();
        Member member = members.get(memberId);
        String memberDetails = members.get(memberId).display();
        System.out.print("Are you looking for a new Member (y/n): ");
        String choice = sc.nextLine();
        //switch to deal with non-existant assessmentHashMap for new accounts
        switch (choice) {
            case "n":
                if (!(member.assessmentHashMap.isEmpty())) {
                    String assessments = member.assessmentHashMap.toString();
                    System.out.println(memberDetails + "\n\t" + "\n\t" + "Assessment History:  " + "\n\t" + assessments);
                }
                break;
            case "y":
                System.out.println(memberDetails + "\n\t");
                System.out.println("\nCurrently no assessments to display...");
        }
    }
    public void viewProfile() { //change this to searchByEmail "for security" and display profile for member & use this method in trainerMenu
        sc.nextLine();
        System.out.println("\n For verification purposes please enter your email: ");
        String search = sc.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (search.length() != 0) {
                if (members.get(i).getEmail().equals(search)) {
                    Member member = members.get(i);
                    String memberDetails = members.get(i).display();
                    System.out.print("Are you a new member (y/n): ");
                    String choice = sc.nextLine();
                    switch (choice) {
                        case "n":
                            if (!(member.assessmentHashMap.isEmpty())) {
                                String assessments = member.assessmentHashMap.toString();
                                System.out.println(memberDetails + "\n\t" + "\n\t" + "Assessment History:  " + "\n\t" + assessments);
                            }
                            break;
                        case "y":
                            System.out.println(memberDetails);
                            System.out.println("\nCurrently no assessments to display...");
                    }
                }
            }
        }
    }
    /**
     * Method to calculate number of members
     *
     * @return No. Members
     */
    public int numberOfMembers() {
        int numberOfMembers = members.size();

        return numberOfMembers;
    }
    /**
     * Method to calculate number of Trainers
     *
     * @return No. Trainers
     */
    public int numberOfTrainers() {
        int numberOfTrainers = trainers.size();
        return numberOfTrainers;
    }

    /**
     *
     * Method checks if index of member object in arraylist
     * @param index
     * @return true/false
     */
    public boolean isValidMemberIndex(int index) {
        if ((index >= 0) && (index < members.size())) {
            return true;
        } else return false;

    }

    public boolean isValidTrainerIndex(int index) {
        if ((index >= 0) && (index < trainers.size())) {
            return true;
        } else return false;

    }

    public void listMembers() {
        if (!members.isEmpty()) {
            System.out.println(showMembers());
        } else System.out.println("Currently no Members to display...");
    }

    public void listTrainers() {
        if (!trainers.isEmpty()){ System.out.println(showTrainers());
        }
        else System.out.println("Currently no Trainers to display...");
    }

    public String showMembers() {
        String str = "";
        for (Member member : members) {
            str += member.display() + "\n";
        }
        return str;
    }

    public String showTrainers() {
        String str = "";
        // display all persons
        for (Trainer trainer : trainers) {
            str += trainer.display() + "\n";
        }
        return str;
    }

    public ArrayList<String> searchTrainersByName() {
        System.out.println("\nPlease enter the Name: ");
        String search = sc.nextLine();
        ArrayList<String> matches = new ArrayList<String>();
        for (int i = 0; i < trainers.size(); i++) {
            if ((trainers.get(i).name.contains(search))||(trainers.get(i).name.equals(search))) {
                matches.add(trainers.get(i).display());
                System.out.println("Trainers: " + matches);
            }
        } return matches;
    }
    public ArrayList<String> searchTrainersByName(String name) {

        ArrayList<String> matches = new ArrayList<String>();
        for (int i = 0; i < trainers.size(); i++) {
            if ((trainers.get(i).getName().contains(name))||(trainers.get(i).getName().equals(name))) {
                matches.add(trainers.get(i).getName());
            }
        } return matches;
    }
    public ArrayList<String> searchMembersByName() {
        System.out.println("\nPlease enter the Name: ");
        String search = sc.nextLine();
        ArrayList<String> matches = new ArrayList<String>();
        for (int i = 0; i < members.size(); i++) {
            if ((members.get(i).getName().contains(search))|| (members.get(i).getName().equals(search))) {
                matches.add(members.get(i).getName());
                System.out.println("Member Details: " + matches);
            }
        } return matches;
    }
    public ArrayList<String> searchMembersByName(String searchName) {
        ArrayList<String> matches = new ArrayList<String>();
        for (int i = 0; i < members.size(); i++) {
            if ((members.get(i).getName().contains(searchName))|| (members.get(i).getName().equals(searchName))) {
                matches.add(members.get(i).getName());
            }
        } return matches;
    }

    /**
     *
     * Overloaded Methods to find a member object in the member arraylist and return the object if a match is is found
     *
     * @param search Scanner takes in user input string value to be search term
     * @return  Object if found
     */
    public Trainer searchTrainersByEmail(String search) {
        for (int i = 0; i < trainers.size(); i++) {
            if ((trainers.get(i).getEmail().contains(search))||(trainers.get(i).getEmail()).equals(search)) {
                return trainers.get(i);
            }
        }
        return null;
    }
    public Trainer searchTrainersByEmail() {
        sc.nextLine();
        System.out.println("Please enter E-mail: ");
        String search = sc.nextLine();
        for (int i = 0; i < trainers.size(); i++) {
            if ((trainers.get(i).getEmail().contains(search))||(trainers.get(i).getEmail()).equals(search)) {
                System.out.println(trainers.get(i).display());
                return trainers.get(i);
            }
        }
        return null;
    }
    public Member searchMembersByEmail(String search) {
        for (int i = 0; i < members.size(); i++) {
            if ((members.get(i).getEmail().contains(search))||(members.get(i).getEmail()).equals(search)) {
                return members.get(i);
            }
        }
        return null;
    }

    public Member searchMembersByEmail() {
        sc.nextLine();
        System.out.println("Please enter the Trainer's E-mail: ");
        String search = sc.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if ((members.get(i).getEmail().contains(search)) || (members.get(i).getEmail()).equals(search)) {
                members.get(i).display();
                System.out.println(members.get(i).display());
                return members.get(i);
            }
        }
        return null;
    }
    //method to list members and ask trainer to select
    public void trainerCheck(){
        double calculatedBMI=0;
        System.out.println("\nCurrent members:\n");
        String listOfMembers = "";
        for (int i = 0; i < members.size(); i++) {
            listOfMembers = listOfMembers + "Id no.  " + i + ": " + members.get(i).getName() + "\n";
        }
        System.out.println(listOfMembers);
    }

    /**
     *
     * Method to take in String from user to verify identity
     * Displays member object and assessmentHashMap
     * Asks user to enter key for HashMAp (date)
     *
     * BMI for member at time - calculated using member height and weight value from assessment object
     * BMI Category is determined by a call to GymUtility class.
     *
     * System prints requested data to console
     *
     */
    public void bmiData() { //Do for member too
        double calculatedBMI = 0;
        sc.nextLine();
        System.out.println("\n For verification purposes please enter your email: ");
        String search = sc.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (search.length() != 0) {
                if (members.get(i).getEmail().equals(search)) {
                    Member member = members.get(i);
                    if (isValidMemberIndex(i)) {
                        System.out.println("\nMember Profile: " + "\n" + member.display());
                        System.out.println("\nAssessment History: " + "\n" + member.assessmentHashMap.toString());
                    }
                    if (member.assessmentHashMap.size() != 0) {
                        System.out.print("\nPlease enter the date of the assessment to be used for calculation(YY/MM/DD): ");
                        String date = sc.nextLine();
                        if (member.assessmentHashMap.containsKey(date)) {
                            member.assessmentHashMap.get(date);
                            if (!(member.assessmentHashMap.isEmpty())) {
                                double weight = member.assessmentHashMap.get(date).weight;
                                calculatedBMI = ((weight) / ((member.height) * (member.height)));
                            } else {
                                calculatedBMI = 0;
                            }
                        }
                    }
                    DecimalFormat df = new DecimalFormat("#.##");
                    String formatted = df.format(calculatedBMI);
                    System.out.println("\nRelevant Member BMI Reading: " + formatted);
                    System.out.println("\nCurrent BMI Status: " + GymUtility.determineBMICategory(calculatedBMI));
                }
            }
        }
    }
        public void calculateBMI () { //Do for member too
            double calculatedBMI = 0;
            trainerCheck();
            System.out.print("Enter the Id No. of the Member you require: ");
            int memberId = sc.nextInt();
            sc.nextLine(); // scanner bug
            sc.nextLine();
            if (isValidMemberIndex(memberId)) {
                Member member = members.get(memberId);
                if (isValidMemberIndex(memberId)) {
                    System.out.println(member.display());
                    System.out.println("\n Assessment History: " + "\n" + member.assessmentHashMap.toString());
                }
                if (member.assessmentHashMap.size() != 0) {
                    System.out.print("\nPlease enter the date of the assessment to be used for calculation(YY/MM/DD): ");
                    String date = sc.nextLine();
                    if (member.assessmentHashMap.containsKey(date)) {
                        member.assessmentHashMap.get(date);
                        if (!(member.assessmentHashMap.isEmpty())) {
                            double weight = member.assessmentHashMap.get(date).weight;
                            calculatedBMI = ((weight) / ((member.height) * (member.height)));
                        } else {
                            calculatedBMI = 0;
                        }
                    }
                }
            } else System.out.println("Invalid ID");
            DecimalFormat df = new DecimalFormat("#.##");
            String formatted = df.format(calculatedBMI);
            System.out.println("\nRelevant Member BMI Reading: " + formatted);
            System.out.println("\nBMI Category: " + GymUtility.determineBMICategory(calculatedBMI));
        }

    /**
     *
     * Method to calculate Ideal Weight based on 'Devine Formula'
     *
     * Also retrieves members current weight and checks if it is ideal or not
     * this data is then formatted and printed to console along with Ideal Weight Indicator
     *
     */
    public void idealWeight() {
        trainerCheck();
        System.out.print("Enter the Id No. of the Member you require: ");
        int memberId = sc.nextInt();
        sc.nextLine(); // scanner bug
        sc.nextLine();
        Member member = members.get(memberId);
        if (isValidMemberIndex(memberId)) {
            System.out.println(member.display());
            System.out.println("\n Assessment History: " + "\n" + member.assessmentHashMap.toString());
            idealStats(member);
        }
    }
    public void idealStats(Member member){
        double idealMWeight = 50;
        double idealFWeight = 45.5;
        double idealWeight = 0;
        double height = 60;
        if (member.assessmentHashMap.size() != 0) {
            System.out.print("\nPlease enter the date of the assessment to be used for calculation(YY/MM/DD): ");
            String date = sc.nextLine();
            if (member.assessmentHashMap.containsKey(date)) {
                Assessment assessment = member.assessmentHashMap.get(date);
                if (!(member.assessmentHashMap.isEmpty())) {
                    switch (member.gender) {
                        case "M":
                        case "m":
                        case "Male":
                        case "male":
                            height = (member.height * 39.37);
                            double diff = height - 60;
                            idealMWeight = (diff * 2.3) + 50;
                            idealWeight = idealMWeight;
                            break;
                        case "F":
                        case "f":
                        case "Female":
                        case "female":
                        case "Gender Unspecified":
                            height = (member.height * 39.37);
                            diff = height - 60;
                            idealFWeight = (diff * 2.3) + 45.5;
                            idealWeight = idealFWeight;
                            break;
                    }
                    String idealWeightIndicator = "";
                    double weight =  member.assessmentHashMap.get(date).weight;
                    if (weight == idealWeight) {
                        idealWeightIndicator = "Achieved";
                    }
                    if (weight > idealWeight) {
                        idealWeightIndicator = "Above Ideal";
                    }
                    if (weight < idealWeight) {
                        idealWeightIndicator = "Below Ideal";
                    }
                    DecimalFormat df = new DecimalFormat("#.##");
                    String formatted = df.format(idealWeight);
                    System.out.println("\nCurrent Weight: " + weight);
                    System.out.println("\nMember Ideal Weight: " + idealWeight);
                    System.out.println("\nIdeal Weight Indicator: " + idealWeightIndicator);
                }
            }
        }
    }
    //Essentially an overloaded idealStats() with member verification instead
    public void memberWeightStats() {
        sc.nextLine();
        System.out.println("\n For verification purposes please enter your email: ");
        String search = sc.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (search.length() != 0) {
                if (members.get(i).getEmail().equals(search)) {
                    Member member = members.get(i);
                        idealStats(member);
                    }

                }
            }
        }
            /**
             *
             * Loads saved data from XML
             *
             * @throws Exception
             */
            @SuppressWarnings("unchecked")
            public void load() throws Exception
            {
                XStream xstream = new XStream(new DomDriver());

                // ------------------ PREVENT SECURITY WARNINGS-----------------------------
                // The Product class is what we are reading in.
                // Modify to include others if needed by modifying the next line,
                // add additional classes inside the braces, comma separated

                Class<?>[] classes = new Class[] { Member.class, PremiumMember.class, StudentMember.class, Trainer.class, Assessment.class };


                XStream.setupDefaultSecurity(xstream);
                xstream.allowTypes(classes);
                // -------------------------------------------------------------------------

                ObjectInputStream is = xstream.createObjectInputStream(new FileReader("persons.xml"));
                members = (ArrayList<Member>) is.readObject();
                trainers = (ArrayList<Trainer> )is.readObject();
                is.close();
            }
            /**
             *
             * Save data to XML
             *
             * @throws Exception
             */
            @SuppressWarnings("unchecked")
            public void save() throws Exception
            {
                XStream xstream = new XStream(new DomDriver());

                // ------------------ PREVENT SECURITY WARNINGS-----------------------------
                // The Product class is what we are reading in.
                // Modify to include others if needed by modifying the next line,
                // add additional classes inside the braces, comma separated

                Class<?>[] classes = new Class[] { Member.class, PremiumMember.class, StudentMember.class, Trainer.class, Assessment.class };

                XStream.setupDefaultSecurity(xstream);
                xstream.allowTypes(classes);
                // -------------------------------------------------------------------------

                ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("persons.xml"));
                out.writeObject(members);
                out.writeObject(trainers);
                out.close();
            }
        }
