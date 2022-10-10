public class Prescription {
    private String medicine;
    private int timeInterval;
    private final String patientId;
    private String dosage;
    private boolean isActive;

    private static final String ACTIVE = "Active";
    private static final String INACTIVE = "Inactive";

    public Prescription(String patientId, String medicine, String dosage, int timeInterval) {
        this.patientId = patientId;
        this.medicine = medicine;
        this.dosage = dosage;
        this.timeInterval = timeInterval;
        this.isActive = true;
    }

    public Prescription(String patientId, String medicine, String dosage, int timeInterval, boolean isActive) {
        this.patientId = patientId;
        this.medicine = medicine;
        this.dosage = dosage;
        this.timeInterval = timeInterval;
        this.isActive = isActive;
    }

    public String getPatientId() {
        return patientId;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public void setActive() {
        isActive = true;
    }

    public void setInactive() {
        isActive = false;
    }

    private String getStatusString() {
        return isActive ? ACTIVE : INACTIVE;
    }

    @Override
    public String toString() {
        return "ID: " + patientId + System.lineSeparator()
                + "Medicine: " + medicine + System.lineSeparator()
                + "Dosage: " + dosage + System.lineSeparator()
                + "Time Interval: once every " + timeInterval + " hours" + System.lineSeparator()
                + "Status: " + getStatusString();
    }
}
