import java.util.ArrayList;

public class Patient {
    private String name;
    private String birthDate;
    private String gender;
    private final String id;
    public VisitList visits;
    public PrescriptionList activePrescriptions;


    public Patient(String name, String birthDate, String gender, String id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.visits = new VisitList();
        this.activePrescriptions = new PrescriptionList();
    }

    // todo public void addMedicine();
    public void addVisit(UI ui, String id, String dateOfVisit, String timeOfVisit, String reason) {
        this.visits.addVisit(ui, id,dateOfVisit, timeOfVisit, reason);
    }

    public void addVisit(UI ui, String id, String dateOfVisit, String timeOfVisit) {
        this.visits.addVisit(ui, id,dateOfVisit, timeOfVisit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        String message = "\t";
        message += "Name: " + getName();
        message += "\n\t";
        message += "Gender: " + (gender.equals("M") ? "Male\n\t" : "Female\n\t");
        message += "Date of Birth: " + getBirthDate();
        message += "\n\t";
        message += "ID: " + getId();
        return message;
    }

}
