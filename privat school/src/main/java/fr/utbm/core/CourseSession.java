/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * //@author m-alwan
 */
@Entity
@Table(name = "COURSE_SESSION")
public class CourseSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NotNull
    private int id;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date endDate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "COURSE_CODE")
    @NotNull
    private Course course;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "LOCATION_ID" )
    @NotNull
    private Location location;

    public CourseSession() {
    }

    public CourseSession(Date startDate, Date endDate, Course course, Location location) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.location = location;
    }

    public CourseSession(int id, Date startDate, Date endDate, Course course, Location location) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Course getCourse() {
        return course;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.startDate);
        hash = 61 * hash + Objects.hashCode(this.endDate);
        hash = 61 * hash + Objects.hashCode(this.course);
        hash = 61 * hash + Objects.hashCode(this.location);
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
        final CourseSession other = (CourseSession) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", course=" + course + ", location=" + location + '}';
    }

}
