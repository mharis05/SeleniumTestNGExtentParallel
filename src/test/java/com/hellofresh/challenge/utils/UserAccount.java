package com.hellofresh.challenge.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UserAccount {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer birthday;
    private Integer birthMonth;
    private Integer birthYear;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postcode;
    private String other;
    private String phone;
    private String mobilePhone;
    private String alias;

    private Faker faker = new Faker();

    public UserAccount() {

        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = firstName + lastName + "@gmail.com";
        this.password = "qwerty";
        this.birthday = generateRandomBirthDay().get(Calendar.DAY_OF_MONTH);
        this.birthMonth = generateRandomBirthDay().get(Calendar.MONTH);
        this.birthYear = generateRandomBirthDay().get(Calendar.YEAR);
        this.company = faker.company().name();
        this.address1 = faker.address().streetAddress();
        this.address2 = faker.address().secondaryAddress();
        this.city = faker.address().city();
        this.state = faker.address().state();
        this.postcode = faker.address().zipCode().substring(0,5);
        this.other = faker.lorem().sentence();
        this.phone = "+1" + faker.number().digits(10);
        this.mobilePhone = faker.numerify(faker.phoneNumber().cellPhone());
        this.alias = faker.name().username();

    }

    private Calendar generateRandomBirthDay() {
        Calendar calendar = new GregorianCalendar(1990, 1, 1);
        Date minDate = calendar.getTime();
        calendar.set(2019, 1, 1);
        Date maxDate = calendar.getTime();
        calendar.setTime(faker.date().between(minDate, maxDate));
        return calendar;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public Integer getBirthday() {
        return birthday;
    }


    public Integer getBirthMonth() {
        return birthMonth;
    }


    public Integer getBirthYear() {
        return birthYear;
    }


    public String getCompany() {
        return company;
    }


    public String getAddress1() {
        return address1;
    }


    public String getAddress2() {
        return address2;
    }


    public String getCity() {
        return city;
    }


    public String getState() {
        return state;
    }


    public String getPostcode() {
        return postcode;
    }


    public String getOther() {
        return other;
    }


    public String getPhone() {
        return phone;
    }


    public String getMobilePhone() {
        return mobilePhone;
    }


    public String getAlias() {
        return alias;
    }


}
