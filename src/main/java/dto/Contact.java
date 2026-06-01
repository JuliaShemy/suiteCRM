package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
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
}

