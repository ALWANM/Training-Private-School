/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * //@author m-alwan
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NotNull
    private int id;
    @Column(name = "LASTNAME", length = 200)
    @NotNull
    private String lastname;
    @Column(name = "FIRSTNAME", length = 200)
    @NotNull
    private String firstname;
    @Column(name = "ADDRESS", length = 200)
    @NotNull
    private String address;
    @Column(name = "PHONE", length = 200)
    @NotNull
    private String phone;
    @Column(name = "EMAIL", length = 200)
    @NotNull
    private String email;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="COURSE_SESSION_ID")
    @NotNull
    private CourseSession courseSessionId;

    public Client(Client c ) {
        this.id = c.id;
        this.lastname = c.lastname;
        this.firstname = c.firstname;
        this.address = c.address;
        this.phone = c.phone;
        this.email = c.email;
        this.courseSessionId = c.courseSessionId;
        
    }

    public Client() {
    }

    public Client(int id, String lastname, String firstname, String address, String phone, String email, CourseSession courseSessionId) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.courseSessionId = courseSessionId;
    }

    public Client(String lastname, String firstname, String address, String phone, String email, CourseSession courseSessionId) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.courseSessionId = courseSessionId;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public CourseSession getCourseSessionId() {
        return courseSessionId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourseSessionId(CourseSession courseSessionId) {
        this.courseSessionId = courseSessionId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.lastname);
        hash = 13 * hash + Objects.hashCode(this.firstname);
        hash = 13 * hash + Objects.hashCode(this.address);
        hash = 13 * hash + Objects.hashCode(this.phone);
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.courseSessionId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.courseSessionId, other.courseSessionId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", address=" + address + ", phone=" + phone + ", email=" + email + ", courseSessionId=" + courseSessionId + '}';
    }

}
