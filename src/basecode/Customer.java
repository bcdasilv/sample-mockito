package basecode;

public class Customer {

    private String fullName;
    private String email;
    private boolean preferEmails = false;

    public Customer (String fullName, String email){
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName(){
        return fullName;
    }

    public boolean prefersEmails() {
        return preferEmails;
    }

    public String getEmail() {
        return email;
    }

    public void wantsEmail(boolean preferEmails){
        this.preferEmails = preferEmails;
    }
}
