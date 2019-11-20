public class Manager extends Employee {

    private int masterPW;

    public Manager(){
        super();
        masterPW = 0;
    }

    public Manager(int password, String firstN, String lastN, int masterPW){
        super(password, firstN, lastN);
        this.masterPW = masterPW;
    }

    public int getMasterPW() {
        return masterPW;
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

    public void setMasterPW(int masterPW) {
        this.masterPW = masterPW;
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
