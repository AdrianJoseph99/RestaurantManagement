public class Server extends Employee {

    private int tablesPerServer;

    public Server(){
        super();
        tablesPerServer = 0;
    }

    public Server(int password, String firstN, String lastN, int tablesPerServer){
        super(password, firstN, lastN);
        this.tablesPerServer = tablesPerServer;
    }

    public int getTablesPerServer() {
        return tablesPerServer;
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

    public void setTablesPerServer(int tablesPerServer) {
        this.tablesPerServer = tablesPerServer;
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
