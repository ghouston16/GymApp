import java.util.HashMap;
import java.util.HashSet;

public class GymUtility {
    static double INCHES = 0.0254001;
    static double FEET = 0.3048;
    static double CENTIMETERS = 0.01;
    static double METERS = 1;
    private double val, meters, converted;

    /**
     *
     * Method calculates Member BMI
     *
     * @param member
     * @param assessment
     * @return
     */
    public static double calculateBMI(Member member, Assessment assessment) {
        double calculatedBMI;
        if (!(member.assessmentHashMap.isEmpty())) {
            double weight = member.assessmentHashMap.get(assessment.date).weight;
            calculatedBMI = (weight / (member.height) * (member.height));
        } else {
            calculatedBMI = 0;
        }
        //  calculatedBMI = Math.round(calculatedBMI);
        System.out.println(calculatedBMI);
        return calculatedBMI;
    }

    /**
     *
     * Method uses calculatedBMI to determine BMI Category
     *
     * @param calculatedBMI
     * @return
     */
    public static String determineBMICategory(double calculatedBMI) {
        String BMICategory = "";
        if (calculatedBMI < 16) {
            BMICategory = "SEVERELY UNDERWEIGHT";
        }
        if ((calculatedBMI >= 16) && (calculatedBMI < 18.5)) {
            BMICategory = "UNDERWEIGHT";
        }
        if ((calculatedBMI >= 18.5) && (calculatedBMI < 25)) {
            BMICategory = "NORMAL";
        }
        if ((calculatedBMI >= 25) && (calculatedBMI > 30)) {
            BMICategory = "OVERWEIGHT ";

        }
        if (calculatedBMI >= 30) {
            BMICategory = "MODERATELY OBESE";
        }
        if (calculatedBMI >= 35) {
            BMICategory = "SEVERELY OBESE";
        }

        return BMICategory;
    }
    /**
     *
     * To metric conversion method
     *
     * @Reference Found online: oracle.com
     *
     * @param val
     * @param fromUnit
     * @return
     */
    public double toMeters(double val, String fromUnit)
    {
        double meters= 0;
        switch(fromUnit){
            case "m":
                meters = (double) (val* GymUtility.METERS);
                break;
            case "cm":
                meters = (double) (val* GymUtility.CENTIMETERS);
                break;
            case "in":
                meters = (double) (val* GymUtility.INCHES);
        } return meters;
    }

    /**
     *
     * From metric conversion method
     *
     * @Reference Found online: oracle.com
     *
     * @param meters
     * @param afromUnit
     * @return
     */
    public double fromMeters(double meters, String afromUnit)
    {
        double converted = 0;
        switch(afromUnit)
        {
            case "in":
                converted = Math.round(meters*39.369923740457715);
                break;
            case "ft":
                converted = Math.round(meters*3.280839895013123);
                break;
            case"cm":
                converted = Math.round(meters*100);
                break;
        }
        return converted;
    }

    /**
     *
     * Member to perform calculations using 'Devine formula'
     * and member object height values to determine member height
     *
     * Switch statement used to navigate formulae
     *
     * @param member
     * @return
     */
    public static double idealWeight(Member member) {

        double height = (member.height*39.37);
        double idealMWeight = 50;
        double idealFWeight = 45.5;
        double idealWeight = 0;
        switch (member.getGender()) {
            case "M":
            case "m":
            case "Male":
            case "male":
                if (height > 60) {
                    double diff = height - 60;
                    idealMWeight = (diff * 2.3) + 50;

                    idealWeight = Math.round(idealMWeight);
                }
                break;
            case "F":
            case "f":
            case "Female":
            case "female":
            case "Gender Unspecified":
                if (height > 60) {
                    double diff = height - 60;
                    idealMWeight = (diff * 2.3) + 45.5;
                    idealWeight = Math.round(idealFWeight);
                }
                break;
        }
        return idealWeight;
    }

    public static void displayIdealWeight(Member member) {
        System.out.print("\n Members Ideal Body Weight in (kgs): " + idealWeight(member));
    }

    public static boolean isIdealBodyWeight(Member member, Assessment assessment) {
        while (member.assessmentHashMap.size() != 0) {
            if (((member.assessmentHashMap.get(assessment.date).weight) == (idealWeight(member)+0.2))||(member.assessmentHashMap.get(assessment.date).weight) == (idealWeight(member)-0.2)) {
                return true;
            }
        }return false;
    }

    /**
     *
     * Method to determine if member is ideal weight and return a String relevant to their weight
     * versus ideal
     *
     * @param member
     * @param assessment
     * @return
     */
    public static String idealWeightIndicator(Member member, Assessment assessment) {
        if (!(member.assessmentHashMap.isEmpty())) {
            String idealWeightIndicator = "";
            String date = "";
            if (member.assessmentHashMap.get(date).weight == idealWeight(member)) {
                idealWeightIndicator = "Achieved";
                isIdealBodyWeight(member, assessment);
            }
            if (member.assessmentHashMap.get(date).weight > idealWeight(member)) {
                idealWeightIndicator = "Above Ideal";
            }
            if (member.assessmentHashMap.get(date).weight < idealWeight(member)) {
                idealWeightIndicator = "Below Ideal";
            }
            return idealWeightIndicator;
        }
        return "Unknown";
    }

}




