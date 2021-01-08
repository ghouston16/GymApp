
public class Person {
    public String name;
    public String email;
    public String address;
    public String gender;

    /**
     * Constructor for objects of class Person.
     *
     * @param email    Member email
     * @param name     Member name
     * @param address  Member address
     * @param gender   Member gender
     *
     */

    public Person(String email, String name, String address, String gender) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    public void setName(String name) {
        if (name.length() > 30) {
            this.name = name.substring(0, 30);
        }
        if ((name.length() <= 30) && (name.length() > 0)) {
            this.name = name;
        }
    }


    public String getName() {
        if (name.length() > 30) {
            name = name.substring(0, 30);
        }
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getGender() {
        if (gender.equals("M") || gender.equals("F")) {
            return gender;
        } else {
            return gender = "Unspecified";
        }
    }


    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }


    /**
     * Display Persons Details
     *
     * Over-ridden in subclasses to provide extra fields
     *
     */

    public String display() {
        String str = "\n\t" +
                "Name: " + name + ", " +
                "Email: " + email + ", " +
                "Gender: " + gender + ", " +
                "Address:" + address + "\n\t";

        return str;
    }
}