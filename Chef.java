public class Chef extends Employee {

    public Chef(){
        super();
    }

    public Chef(int password, String firstN, String lastN){
        super(password, firstN, lastN);
        //this.tablesPerServer = tablesPerServer;
    }


    @Override
    public int getPassword() {
        return super.getPassword();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }


    @Override
    public void setPassword(int password) {
        super.setPassword(password);
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }
}
