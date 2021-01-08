import java.util.HashMap;
import java.util.Scanner;

public class MenuController {
    private GymAPI gymAPI;
    private Scanner sc = new Scanner(System.in);
    //Makes MenuController the Driver for Application
    public static void main(String[] args) throws Exception {
        MenuController mc = new MenuController();
        mc.runLogReg();
    }

    /**
     *
     * Constructor for MenuController Class
     *
     * Creates instance of GymAPI
     *
     * Loads exsiting data from XML on Start-Up
     *
     * @throws Exception
     */
    public MenuController() throws Exception {
        gymAPI = new GymAPI();
        gymAPI.load();
    }

    private String loginregister() {
        System.out.println("\n\t");
        System.out.println(" Welcome to GymApi: ");
        System.out.println("----------------");
        System.out.println("l) To Login please press (l) + Enter key");
        System.out.println("----------------");
        System.out.println("r)To Register as a New Member please press (r) + Enter key ");
        System.out.println("----------------");
        System.out.println("z)To Exit press (z) + Enter key ");
        System.out.println("----------------");
        System.out.print("==>>");
        String logreg = sc.nextLine();
        return logreg;
    }

    private String regOption() {
        System.out.println("\n\t");
        System.out.println(" Registration Menu: ");
        System.out.println("----------------");
        System.out.println("m) To Register as New Member press (m) followed by Enter key");
        System.out.println("----------------");
        System.out.println("t) To Register as New Trainer press (t) followed by Enter key");
        System.out.println("----------------");
        System.out.println("z)To Return to login press (z) + Enter key ");
        System.out.println("----------------");
        System.out.print("==>>");
        String regOption = sc.nextLine();
        return regOption;
    }

    /**
     *
     * Registration Sub-Menu
     *
     * String driven switch statement to decide what kind of registration
     *
     * @throws Exception
     */
    private void runRegMenu() throws Exception {
        sc.nextLine();
        String regOption = regOption();
        while (!(regOption.equals("z"))) {
            switch (regOption) {
                case "m":
                    runAddMemberMenu();
                    gymAPI.save();
                    break;
                case "t":
                    gymAPI.addTrainer();
                    runTrainerMenu();
                    break;
                case "z":
                    runLogReg();
                    break;
                default:
                    System.out.println("Invalid option entered: " + regOption);
                    loginregister();
                    break;
            }
            System.out.println("\nPress any key to continue...");
            sc.nextLine();
            sc.nextLine();  //this second read is required - bug in Scanner class; a String read is ignored straight after reading an int.
            gymAPI.save();
            runLogReg();
            //display the registration sub menu again
        }
    }
    /**
     *
     * Login or Registration Menu
     *
     * Scanner takes in String from user to decide option
     * String driven switch statement to decide Login/Register.
     * "l" leads to calls gymLogin(). Which requires valid email to login.
     * "r" registration sub-menu
     *
     * Redirects recursively to same menu
     *
     * @throws Exception
     */
    private void runLogReg() throws Exception {
        gymAPI.load();
        String logreg = loginregister();
        while (!(logreg.equals("z"))) {
            switch (logreg) {
                case "l":
                    gymLogin();
                    break;
                case "r":
                    runRegMenu();
                    break;
                case "z":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option entered: " + logreg);
                    runLogReg();
                    break;
            }
        }
        //pause the program so that the user can read what we just printed to the terminal window
        System.out.println("\nPress any key to continue...");
        sc.nextLine();
        sc.nextLine();  //this second read is required - bug in Scanner class;
        //display the main menu again
        gymAPI.save(); //save registered members
        runLogReg();
    }

    /**
     *
     * Method to search Members & Trainers ArrayList for registered Person
     *
     * Scanner takes in String from user - their email
     * When a match is found Person is directed to correct MEmber/Trainer Sub-Menu based on where match is found
     * No match results in invalid login and redirects to Login/Registration Menu
     *
     * @throws Exception
     *
     */
    @SuppressWarnings("unchecked")
    private void gymLogin() throws Exception {
        System.out.println("Enter your Email Address: ");
        String search = sc.nextLine();
        if (search.length() != 0) {
            if (gymAPI.searchMembersByEmail(search) != null) {
                sc.nextLine();
                runMemberMenu();
            }
            if (gymAPI.searchTrainersByEmail(search) != null) {
                runTrainerMenu();
            }
        } else
            System.out.println("Invalid Login!!");
        runLogReg();
    }

    private int trainerMenu() {
        System.out.println("\n\t");
        System.out.println(" Trainer Menu ");
        System.out.println("----------------");
        System.out.println("1) Add Member Menu");
        System.out.println("----------------");
        System.out.println("2) Assessment Menu");
        System.out.println("----------------");
        System.out.println("3) List all Members");
        System.out.println("----------------");
        System.out.println("4) Analytics Menu");
        System.out.println("----------------");
        System.out.println("5) Search Member by Name");
        System.out.println("----------------");
        System.out.println("5) Search Member by E-Mail");
        System.out.println("----------------");
        System.out.println("0) Save & Return to Main Menu");
        System.out.print("==>>");
        int trainerOption = sc.nextInt();
        return trainerOption;
    }

    private int memberMenu() {
        System.out.println("\n\t");
        System.out.println(" Member Menu ");
        System.out.println("----------------");
        System.out.println("1) View Your Profile");
        System.out.println("----------------");
        System.out.println("2) Edit Your Profile");
        System.out.println("----------------");
        System.out.println("3) Statistical Data: ");
        System.out.println("----------------");
        System.out.println("0) Save and Exit Application");
        System.out.print("==>>");
        int memberOption = sc.nextInt();
        return memberOption;
    }

    private int addMEmberMenu() {
        System.out.println("\n\t");
        System.out.println(" Add Member Menu ");
        System.out.println("----------------");
        System.out.println("1) Add a Member");
        System.out.println("----------------");
        System.out.println("2) Add a Premium Member");
        System.out.println("----------------");
        System.out.println("4) Add a Student Member");
        System.out.println("----------------");
        System.out.println("0) Save and Exit");
        System.out.print("==>>");
        int addMemberOption = sc.nextInt();
        return addMemberOption;
    }
    private int analyticsMenu() {
        System.out.println("\n\t");
        System.out.println(" Analytics Menu ");
        System.out.println("----------------");
        System.out.println("1) View Member BMI Data");
        System.out.println("----------------");
        System.out.println("2) View Member Weight Stats");
        System.out.println("----------------");
        System.out.println("0) Save and Exit");
        System.out.print("==>>");
        int analyticsOption = sc.nextInt();
        return analyticsOption;
    }
    private int memberAnalyticsMenu() {
        System.out.println("\n\t");
        System.out.println(" Analytics Menu ");
        System.out.println("----------------");
        System.out.println("1) View BMI Data");
        System.out.println("----------------");
        System.out.println("2) View Weight Stats");
        System.out.println("----------------");
        System.out.println("0) Save and Exit");
        System.out.print("==>>");
        int memberAnalyticsOption = sc.nextInt();
        return memberAnalyticsOption;
    }

    private int assessmentMenu() {
        System.out.println("\n\t");
        System.out.println(" Assessment Menu ");
        System.out.println("----------------");
        System.out.println("1) View Member Profile");
        System.out.println("----------------");
        System.out.println("2) Add Member Assessment");
        System.out.println("----------------");
        System.out.println("3) Update Trainer Comments");
        System.out.println("----------------");
        System.out.println("4) Return to Trainer Menu");
        //  System.out.println("6) Member Progress ");
        //   System.out.println("----------------");
        System.out.println("0) Save and Exit Application");
        System.out.print("==>>");
        int option = sc.nextInt();
        return option;
    }
    /**
     *
     * Assessment Sub-Menu for Trainers
     *
     * Scanner takes in int from user to decide option
     * int driven switch statement to decide.
     *
     * "1" View Members Profile + Assessment history
     *
     * "2" Adding and assessment to a Members profile
     *
     * "3" Allows Trainer to update the comment on any given assessment
     *
     * 4 Returns to trainer menu
     *
     * @throws Exception due to load & save
     *
     */
    @SuppressWarnings("unchecked")
    private void runAssessmentMenu() throws Exception {
        int option = assessmentMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    gymAPI.displayProfile();
                    break;
                case 2:
                    gymAPI.addAssessment();
                    gymAPI.save();
                    break;
                case 3:
                    gymAPI.updateComment();
                    gymAPI.save();
                    break;
                case 4:
                   runTrainerMenu();
                   trainerMenu();
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            sc.nextLine();
            sc.nextLine();  //this second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

            //display the main menu again
            option = assessmentMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        gymAPI.save();
        System.exit(0);
    }

    /**
     *
     * Assessment Sub-Menu for Trainers
     *
     * Scanner takes in int from user to decide option
     * int driven switch statement to decide.
     *
     * "1" View Members Profile + Assessment history
     *
     * "2" Adding and assessment to a Members profile
     *
     * "3" Allows Trainer to update the comment on any given assessment
     *
     * 4 Returns to trainer menu
     *
     * @throws Exception due to load & save
     *
     */
    @SuppressWarnings("unchecked")
    private void runTrainerMenu() throws Exception {
        gymAPI.load();
        int trainerOption = trainerMenu();
        while (trainerOption != 0) {
            switch (trainerOption) {
                case 1:
                    runAddMemberMenu();
                    break;
                case 2:
                    runAssessmentMenu();
                    break;
                case 3:
                    gymAPI.listMembers();
                    break;
                case 4:
                    runAnalyticsMenu();
                    break;
                case 5: gymAPI.searchMembersByName();
                break;
                case 6:
                    gymAPI.searchMembersByEmail();
                    break;
                default:
                    System.out.println("Invalid option entered: " + trainerOption);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            sc.nextLine();
            sc.nextLine();

            //display the main menu again
            trainerOption = trainerMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting application GoodBye....");
        gymAPI.save();
        System.exit(0);
    }
    /**
     *
     * Analytics Sub-Menu for Trainers
     *
     * Scanner takes in int from user to decide option
     * int driven switch statement to decide.
     *
     * "1" BMI DATA
     *
     * "2" IDEAL WEIGHT DATA
     *
     * 3 Returns to trainer menu
     *
     * @throws Exception due to load & save
     *
     */
    @SuppressWarnings("unchecked")
    private void runAnalyticsMenu() throws Exception {
        gymAPI.load();
        int analysisOption = analyticsMenu();
        while (analysisOption != 0) {
            switch (analysisOption) {
                case 1:
                    gymAPI.calculateBMI(); //TODO CHANGE Back
                    break;
                case 2:
                    gymAPI.idealWeight();
                    break;
                default:
                    System.out.println("Invalid option entered: " + analysisOption);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            sc.nextLine();
            sc.nextLine();

            //display the main menu again
            analysisOption = analyticsMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting application GoodBye....");
        gymAPI.save();
        runTrainerMenu();
    }
    /**
     *
     * Analytics Sub-Menu for Members
     *
     * Scanner takes in int from user to decide option
     * int driven switch statement to decide.
     *
     * "1" BMI DATA
     *
     * "2" IDEAL WEIGHT DATA
     *
     * 3 Returns to trainer menu
     *
     * @throws Exception due to load & save
     *
     */
    @SuppressWarnings("unchecked")
    private void runMemberAnalyticsMenu() throws Exception {
        gymAPI.load();
        int memberAnalysisOption = memberAnalyticsMenu();
        while (memberAnalysisOption != 0) {
            switch (memberAnalysisOption) {
                case 1:
                    gymAPI.bmiData();
                    break;
                case 2:
                    gymAPI.memberWeightStats();
                    break;
                default:
                    System.out.println("Invalid option entered: " + memberAnalysisOption);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            sc.nextLine();
            sc.nextLine();

            //display the main menu again
            memberAnalysisOption = memberAnalyticsMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting application GoodBye....");
        gymAPI.save();
        runTrainerMenu();
    }
    /**
     *
     * Add Member
     *
     * Scanner takes in int from user to decide option
     * int driven switch statement to decide.
     *
     * Choose what type of member to register
     *
     * @throws Exception due to load & save
     *
     */
    private void runAddMemberMenu() throws Exception {
        int addMemberOption = addMEmberMenu();
        while (addMemberOption != 0) {
            switch (addMemberOption) {
                case 1:
                    gymAPI.addMember();
                    gymAPI.save();
                    runMemberMenu();
                    break;
                case 2:
                    gymAPI.addPremiumMember();
                    gymAPI.save();
                    runMemberMenu();
                    break;
                case 3:
                    gymAPI.addStudentMember();
                    gymAPI.save();
                    runMemberMenu();
                    break;
                default:
                    runLogReg();
                    break;
            }  gymAPI.save();
            System.out.println("\nPress any key to continue...");
            sc.nextLine();
            sc.nextLine();
            runTrainerMenu();
            gymAPI.save();
        }
    }

    private int profileMenu() {
        System.out.println("\n\t");
        System.out.println(" Profile Manager ");
        System.out.println("----------------");
        System.out.println("1) Edit You Email: ");
        System.out.println("----------------");
        System.out.println("2) Edit Your Name: ");
        System.out.println("----------------");
        System.out.println("3) Update Your Address");
        System.out.println("----------------");
        System.out.println("4) Update Your Gender");
        System.out.println("----------------");
        System.out.println("5) Update Your Height");
        System.out.println("----------------");
        System.out.println("6) Update Your Chosen Package");
        System.out.println("----------------");
        System.out.println("0) Save and Exit Application");
        System.out.print("==>>");
        int memberOption = sc.nextInt();
        return memberOption;
    }
    /**
     *
     * Main Menu for Members
     *
     * Scanner takes in int from user to decide option
     * int driven switch statement to decide.
     *
     * "1" View Members Profile + Assessment history
     *
     * "2" Edit users details - ie fields in the relevant member object
     *
     *
     * @throws Exception due to load & save
     *
     */
    @SuppressWarnings("unchecked")
    private void runMemberMenu() throws Exception {
        gymAPI.load();
        int memberOption = memberMenu();
        while (memberOption != 0) {
            switch (memberOption) {
                case 1:
                    gymAPI.viewProfile();
                    break;
                case 2:
                    runProfileControl();
                    break;
                case 3: runMemberAnalyticsMenu();
                break;
                case 4: gymAPI.searchTrainersByEmail();
                break;
                case 5: gymAPI.searchTrainersByName();
                break;
                case 6: gymAPI.listTrainers();
                break;
                default:
                    System.out.println("Invalid option entered: " + memberOption);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            sc.nextLine();
            sc.nextLine();  //this second read is required - bug in Scanner class; a String read is ignored straight after reading an int.
            gymAPI.save();
            //display the main menu again
            memberOption = memberMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting Application Goodbye....");
        gymAPI.save();
        sc.nextLine();
        System.exit(0);
    }
    /**
     *
     * Member Sub-Menu for Profile Control
     *
     *
     * Scanner takes in int from user to decide option
     * int driven switch statement to decide.
     *
     *
     *
     * @throws Exception due to load & save
     *
     */

    private void runProfileControl() throws Exception {
        int profileOption = profileMenu();
        while (profileOption != 0) {
            switch (profileOption) {
                case 1:
                    gymAPI.updateEmail();
                    break;
                case 2:
                    gymAPI.updateName();
                    break;
                case 3:
                    gymAPI.updateAddress();
                    break;
                case 4:
                    gymAPI.updateGender();
                    break;
                case 5:
                    gymAPI.updateHeight();
                    break;
                case 6:
                    gymAPI.updateChosenPackage();
                    break;
                default:
                    System.out.println("Invaild option entered " + profileOption);
            }
            System.out.println("\nPress any key to continue...");
            sc.nextLine();
            sc.nextLine();
            gymAPI.save();

            //display the main menu again
            profileOption = memberMenu();
        }
    }
}