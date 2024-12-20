 // Класс Phone

class Phone {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String creditCardNumber;
    private double debit;
    private double credit;
    private int localCallTime; // Время городских разговоров
    private int interCityCallTime; // Время междугородных разговоров

    // Конструкторы
    public Phone(int id, String lastName, String firstName, String middleName, String address,
                 String creditCardNumber, double debit, double credit, int localCallTime, int interCityCallTime) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.localCallTime = localCallTime;
        this.interCityCallTime = interCityCallTime;
    }

    public Phone() {
        this(0, "", "", "", "", "", 0.0, 0.0, 0, 0);
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getLocalCallTime() {
        return localCallTime;
    }

    public void setLocalCallTime(int localCallTime) {
        this.localCallTime = localCallTime;
    }

    public int getInterCityCallTime() {
        return interCityCallTime;
    }

    public void setInterCityCallTime(int interCityCallTime) {
        this.interCityCallTime = interCityCallTime;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", localCallTime=" + localCallTime +
                ", interCityCallTime=" + interCityCallTime +
                '}';
    }
}
