package com.ashokit.sbms.usermgmt.entity;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "USERS_TBL")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Id")
    private Long id;
    @Column(name = "First_Name", nullable = false, length = 50, unique = false)
    private String firstName;
    @Column(name = "Last_Name", nullable = false, length = 50, unique = false)
    private String lastName;
    @Column(name = "Email", nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "Phone_Number", nullable = false, length = 10, unique = false)
    private String phoneNumber;
    @Column(name = "DOB", nullable = false, length = 10, unique = false)
    private String Date;
    @Column(name = "Gender", nullable = false, unique = false)
    private String gender;
    @Column(name = "Password", nullable = false, unique = false, length = 100)
    private String password;
    @Column(name = "Country", nullable = false, length = 50)
    private String country;
    @Column(name = "State", nullable = false, length = 50)
    private String state;
    @Column(name = "City", nullable = false, length = 50)
    private String city;
    @Column(name = "Status", nullable = false)
    private String status;
    @Column(name = "Date_Created")
    @CreationTimestamp
    private Date createdDate;
    @Column(name = "Date_Updated")
    @UpdateTimestamp
    private Date lastUpdated;
    
    public Long getId() {
        return this.id;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public String getDate() {
        return this.Date;
    }
    
    public String getGender() {
        return this.gender;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public String getState() {
        return this.state;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public Date getLastUpdated() {
        return this.lastUpdated;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setDate(final String Date) {
        this.Date = Date;
    }
    
    public void setGender(final String gender) {
        this.gender = gender;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setCountry(final String country) {
        this.country = country;
    }
    
    public void setState(final String state) {
        this.state = state;
    }
    
    public void setCity(final String city) {
        this.city = city;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public void setLastUpdated(final Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        final User other = (User)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        Label_0065: {
            if (this$id == null) {
                if (other$id == null) {
                    break Label_0065;
                }
            }
            else if (this$id.equals(other$id)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        Label_0102: {
            if (this$firstName == null) {
                if (other$firstName == null) {
                    break Label_0102;
                }
            }
            else if (this$firstName.equals(other$firstName)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        Label_0139: {
            if (this$lastName == null) {
                if (other$lastName == null) {
                    break Label_0139;
                }
            }
            else if (this$lastName.equals(other$lastName)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        Label_0176: {
            if (this$email == null) {
                if (other$email == null) {
                    break Label_0176;
                }
            }
            else if (this$email.equals(other$email)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        Label_0213: {
            if (this$phoneNumber == null) {
                if (other$phoneNumber == null) {
                    break Label_0213;
                }
            }
            else if (this$phoneNumber.equals(other$phoneNumber)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$Date = this.getDate();
        final Object other$Date = other.getDate();
        Label_0250: {
            if (this$Date == null) {
                if (other$Date == null) {
                    break Label_0250;
                }
            }
            else if (this$Date.equals(other$Date)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        Label_0287: {
            if (this$gender == null) {
                if (other$gender == null) {
                    break Label_0287;
                }
            }
            else if (this$gender.equals(other$gender)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        Label_0324: {
            if (this$password == null) {
                if (other$password == null) {
                    break Label_0324;
                }
            }
            else if (this$password.equals(other$password)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$country = this.getCountry();
        final Object other$country = other.getCountry();
        Label_0361: {
            if (this$country == null) {
                if (other$country == null) {
                    break Label_0361;
                }
            }
            else if (this$country.equals(other$country)) {
                break Label_0361;
            }
            return false;
        }
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        Label_0398: {
            if (this$state == null) {
                if (other$state == null) {
                    break Label_0398;
                }
            }
            else if (this$state.equals(other$state)) {
                break Label_0398;
            }
            return false;
        }
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        Label_0435: {
            if (this$city == null) {
                if (other$city == null) {
                    break Label_0435;
                }
            }
            else if (this$city.equals(other$city)) {
                break Label_0435;
            }
            return false;
        }
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        Label_0472: {
            if (this$status == null) {
                if (other$status == null) {
                    break Label_0472;
                }
            }
            else if (this$status.equals(other$status)) {
                break Label_0472;
            }
            return false;
        }
        final Object this$createdDate = this.getCreatedDate();
        final Object other$createdDate = other.getCreatedDate();
        Label_0509: {
            if (this$createdDate == null) {
                if (other$createdDate == null) {
                    break Label_0509;
                }
            }
            else if (this$createdDate.equals(other$createdDate)) {
                break Label_0509;
            }
            return false;
        }
        final Object this$lastUpdated = this.getLastUpdated();
        final Object other$lastUpdated = other.getLastUpdated();
        if (this$lastUpdated == null) {
            if (other$lastUpdated == null) {
                return true;
            }
        }
        else if (this$lastUpdated.equals(other$lastUpdated)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * 59 + (($firstName == null) ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * 59 + (($lastName == null) ? 43 : $lastName.hashCode());
        final Object $email = this.getEmail();
        result = result * 59 + (($email == null) ? 43 : $email.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * 59 + (($phoneNumber == null) ? 43 : $phoneNumber.hashCode());
        final Object $Date = this.getDate();
        result = result * 59 + (($Date == null) ? 43 : $Date.hashCode());
        final Object $gender = this.getGender();
        result = result * 59 + (($gender == null) ? 43 : $gender.hashCode());
        final Object $password = this.getPassword();
        result = result * 59 + (($password == null) ? 43 : $password.hashCode());
        final Object $country = this.getCountry();
        result = result * 59 + (($country == null) ? 43 : $country.hashCode());
        final Object $state = this.getState();
        result = result * 59 + (($state == null) ? 43 : $state.hashCode());
        final Object $city = this.getCity();
        result = result * 59 + (($city == null) ? 43 : $city.hashCode());
        final Object $status = this.getStatus();
        result = result * 59 + (($status == null) ? 43 : $status.hashCode());
        final Object $createdDate = this.getCreatedDate();
        result = result * 59 + (($createdDate == null) ? 43 : $createdDate.hashCode());
        final Object $lastUpdated = this.getLastUpdated();
        result = result * 59 + (($lastUpdated == null) ? 43 : $lastUpdated.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "User(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", phoneNumber=" + this.getPhoneNumber() + ", Date=" + this.getDate() + ", gender=" + this.getGender() + ", password=" + this.getPassword() + ", country=" + this.getCountry() + ", state=" + this.getState() + ", city=" + this.getCity() + ", status=" + this.getStatus() + ", createdDate=" + this.getCreatedDate() + ", lastUpdated=" + this.getLastUpdated() + ")";
    }
    
    public User() {
    }
    
    public User(final Long id, final String firstName, final String lastName, final String email, final String phoneNumber, final String Date, final String gender, final String password, final String country, final String state, final String city, final String status, final Date createdDate, final Date lastUpdated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.Date = Date;
        this.gender = gender;
        this.password = password;
        this.country = country;
        this.state = state;
        this.city = city;
        this.status = status;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }
}
