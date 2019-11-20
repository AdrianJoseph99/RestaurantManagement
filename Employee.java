abstract class Employee {
    int password;
    String firstName, lastName;

    public Employee(){
        password = 0;
        firstName = "";
        lastName = "";
    }

    public Employee(int password, String firstName, String lastName){
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getPassword() {
        return password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
