package com.srilakshmigoldbuyers.model;

public class Appointment {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String date;
    private String time;
    private String message;

    // Default constructor
    public Appointment() {
    }

    // Constructor
    public Appointment(
            String name,
            String phone,
            String email,
            String date,
            String time,
            String message) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.date = date;
        this.time = time;
        this.message = message;
    }

    // Get ID
    public Long getId() {
        return id;
    }

    // Set ID
    public void setId(Long id) {
        this.id = id;
    }

    // Get Name
    public String getName() {
        return name;
    }

    // Set Name
    public void setName(String name) {
        this.name = name;
    }

    // Get Phone
    public String getPhone() {
        return phone;
    }

    // Set Phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Get Email
    public String getEmail() {
        return email;
    }

    // Set Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Get Date
    public String getDate() {
        return date;
    }

    // Set Date
    public void setDate(String date) {
        this.date = date;
    }

    // Get Time
    public String getTime() {
        return time;
    }

    // Set Time
    public void setTime(String time) {
        this.time = time;
    }

    // Get Message
    public String getMessage() {
        return message;
    }

    // Set Message
    public void setMessage(String message) {
        this.message = message;
    }
}