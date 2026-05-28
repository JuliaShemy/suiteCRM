package dto;

public class Account {

    private String name;
    private String phone;
    private String fax;
    private String website;
    private String street;
    private String type;
    private String industry;
    private String city;
    private String stateRegion;

    private String postalCode;
    private String country;
    private String description;

    public Account(String name, String phone, String fax, String website, String street, String type, String industry,
                   String city, String stateRegion, String postalCode, String country, String description) {
        this.name = name;
        this.phone = phone;
        this.fax = fax;
        this.website = website;
        this.street = street;
        this.type = type;
        this.industry = industry;
        this.city = city;
        this.stateRegion = stateRegion;
        this.postalCode = postalCode;
        this.country = country;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getWebsite() {
        return website;
    }

    public String getStreet() {
        return street;
    }

    public String getType() {
        return type;
    }

    public String getIndustry() {
        return industry;
    }
    public String getCity(){return city;}
    public String getState_region(){return stateRegion;}
    public String getPostal_code(){return postalCode;}
    public String getCountry(){return country;}
    public String getDescription(){return description;}
}
