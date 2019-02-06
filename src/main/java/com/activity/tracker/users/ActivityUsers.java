package com.activity.tracker.users;

import java.util.Date;
import java.util.Objects;

public class ActivityUsers {
    private String firstName;
    private String lastName;
    private Date birthDate;

    public ActivityUsers(){}

    public ActivityUsers(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "ActivityUsers{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        ActivityUsers activityUsers = (ActivityUsers) o;
        return firstName.equals (activityUsers.firstName) &&
                lastName.equals (activityUsers.lastName) &&
                birthDate.equals (activityUsers.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash (firstName, lastName, birthDate);
    }
}


