public class Trainer extends Person {
    private String speciality;
        /**
         * Constructor for objects of class Trainer.
         *
         * @param email         The email of Trainer.
         * @param name          The name of this Trainer.
         * @param address       Trainers address.
         * @param gender        Trainers gender.
         * @param speciality    Trainers speciality.
         */
        public Trainer(String email, String name, String address, String gender, String speciality) {
            super(email, name, address, gender);
            this.speciality=speciality;
        }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
        public String display(){
            return super.display() + "Trainer Speciality: " + speciality + "\n";
        }
    }

