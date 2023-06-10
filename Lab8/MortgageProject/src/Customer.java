import java.time.LocalDate;

public class Customer {
    private LocalDate birthdate;
    private double monthlyIncome;
    private double monthlyIncomePartner;
    private String profession;
    private String maritalStatus;


    public Customer(LocalDate birthdate, double monthlyIncome, double monthlyIncomePartner, String profession,
                    String maritalStatus) {
        super();
        this.birthdate = birthdate;
        this.monthlyIncome = monthlyIncome;
        this.monthlyIncomePartner = monthlyIncomePartner;
        this.profession = profession;
        this.maritalStatus = maritalStatus;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public double getMonthlyIncomePartner() {
        return monthlyIncomePartner;
    }

    public String getProfession() {
        return profession;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}
