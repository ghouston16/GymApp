public class Assessment
{

    public double weight;
    public double waist;
    public double thigh;
    public double chest;
    public String date;

    public String trainer;
    public String comment;

    public Assessment(double v, double weight, double waist, String comment) {
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {

        this.weight = weight;
    }
    protected String getTrainer() {
        return trainer;
    }

    protected void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public double getWaist() {
        return waist;
    }

    protected void setWaist(double waist) {
        this.waist = waist;
    }

    protected double getThigh() {
        return thigh;
    }

    public void setThigh(double thigh) {
        this.thigh = thigh;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Assessment(String date, double weight, double waist, double thigh){
        this.date=date;
        this.weight=weight;
        this.waist=waist;
        this.thigh=thigh;
    }

    public Assessment(String date, double weight, double waist, double thigh, String
            comment, String trainer)
    {
        this.date=date;
        this.weight=weight;
        this.waist=waist;
        this.thigh=thigh;
        this.comment = comment;
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return  " " + "Weight:  " + weight + ", " +"Waist:  " + waist + ", " + "Thigh:  " + thigh + ", " +
                "Chest:  " + chest + ", " + "Trainer:  " + trainer + "\n\t" +
                "Comment:  " + comment + "\n\t";
    }
}
