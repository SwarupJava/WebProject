package com.ashokit.sbms.usermgmt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "COUNTRY_MASTER")
public class Country
{
    @Id
    @Column(name = "Country_Id", nullable = false, unique = true, length = 10)
    private Long id;
    @Column(name = "Country_Code", nullable = false, unique = true, length = 10)
    private String countryCode;
    @Column(name = "Country_Name", nullable = false, unique = true, length = 50)
    private String countryName;
    
    public Long getId() {
        return this.id;
    }
    
    public String getCountryCode() {
        return this.countryCode;
    }
    
    public String getCountryName() {
        return this.countryName;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }
    
    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }
        final Country other = (Country)o;
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
        final Object this$countryCode = this.getCountryCode();
        final Object other$countryCode = other.getCountryCode();
        Label_0102: {
            if (this$countryCode == null) {
                if (other$countryCode == null) {
                    break Label_0102;
                }
            }
            else if (this$countryCode.equals(other$countryCode)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$countryName = this.getCountryName();
        final Object other$countryName = other.getCountryName();
        if (this$countryName == null) {
            if (other$countryName == null) {
                return true;
            }
        }
        else if (this$countryName.equals(other$countryName)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof Country;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        final Object $countryCode = this.getCountryCode();
        result = result * 59 + (($countryCode == null) ? 43 : $countryCode.hashCode());
        final Object $countryName = this.getCountryName();
        result = result * 59 + (($countryName == null) ? 43 : $countryName.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "Country(id=" + this.getId() + ", countryCode=" + this.getCountryCode() + ", countryName=" + this.getCountryName() + ")";
    }
    
    public Country(final Long id, final String countryCode, final String countryName) {
        this.id = id;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }
    
    public Country() {
    }
}
