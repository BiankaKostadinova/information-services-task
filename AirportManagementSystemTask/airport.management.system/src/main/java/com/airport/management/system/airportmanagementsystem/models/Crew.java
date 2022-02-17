package com.airport.management.system.airportmanagementsystem.models;


import javax.persistence.*;

@Entity
@Table(name = "crew", schema = "airport_management_system", catalog = "")
public class Crew {

    private int id;
    private String firstName;
    private String lastName;
    private String personnelLicence;
    private String phone;
    private CrewCategory crewCategory;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", length = 120)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", length = 128)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "personnel_license", length = 15)
    public String getPersonnelLicence() {
        return personnelLicence;
    }

    public void setPersonnelLicence(String personnelLicence) {
        this.personnelLicence = personnelLicence;
    }

    @Basic
    @Column(name = "phone", length = 30)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToOne
    @JoinColumn(name = "crew_category_id", referencedColumnName = "id")
    public CrewCategory getCrewCategory() {
        return crewCategory;
    }

    public void setCrewCategory(CrewCategory crewCategory) {
        this.crewCategory = crewCategory;
    }
}
