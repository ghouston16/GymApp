public class StudentMember extends Member {
    private String studentId;
    private String collegeName;


    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }


    /**
     * Constructor for objects of class Student Member.
     *
     * @param email    Member email
     * @param name     Member name
     * @param address  Member address
     * @param gender   Member gender
     * @param height   Member height
     * @param chosenPackage Members chosenPackage
     * @param startWeight   Members startingWeight
     * @param collegeName   Members college
     * @param studentId     Members Student I.D.
     */
    public StudentMember(String email, String name, String address,
                         String gender, double height, double startWeight, String chosenPackage, String studentId, String collegeName) {

        super(email, name, address, gender, height, startWeight, chosenPackage);
        this.studentId= studentId;
        this.collegeName= collegeName;
    }

    public String getStudentId() {
        return studentId;
    }
    public String getCollegeName() {
        return collegeName;
    }

    public void setStudentId( String studentId) {
        this.studentId = studentId;
    }
    @Override
    public String display(){
        return super.display() + ", " + " Student I.D. : " + studentId + ", " + "College: " + collegeName + "\n\t";
    }
}
