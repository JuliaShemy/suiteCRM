package dto;

public class Contact {
    private String salutation;
    private String firstName;
    private String officePhone;
    private String jobTitle;
    private String accountName;
    private String lastName;
    private String mobile;
    private String department;
    private String fax;
    private String address;
    private String city;
    private String stateRegion;
    private String postalCode;
    private String country;
    private String description;
    private String assigned_to;
    private String leadSource;
    public Contact(String firstName, String officePhone, String jobTitle, String accountName, String lastName,
                   String mobile, String department, String fax, String address, String city,String stateRegion,
                   String postalCode, String country, String description, String assigned_to, String leadSource,
                   String salutation) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.officePhone = officePhone;
        this.jobTitle = jobTitle;
        this.accountName = accountName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.department = department;
        this.fax = fax;
        this.address = address;
        this.city = city;
        this.stateRegion = stateRegion;
        this.postalCode = postalCode;
        this.country = country;
        this.description = description;
        this.assigned_to = assigned_to;
        this.leadSource = leadSource;

    }
    public  String getSalutation(){return salutation;}
    public String getFirstName() {
        return firstName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDepartment() {
        return department;
    }
    public String getFax(){return fax;}
    public String getAddress(){return address;}
    public String getCity(){return city;}
    public String getState_region(){return stateRegion;}
    public String getPostal_code(){return postalCode;}
    public String getCountry(){return country;}
    public String getDescription(){return description;}
    public String getAssigned_to(){return assigned_to;}
    public String getLeadSource(){return leadSource;}
}

