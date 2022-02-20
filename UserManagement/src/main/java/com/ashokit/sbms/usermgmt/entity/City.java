// 
// Decompiled by Procyon v0.5.36
// 

package com.ashokit.sbms.usermgmt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "CITY_MASTER")
public class City
{
    @Id
    @Column(name = "City_Id", nullable = false, length = 10, unique = true)
    private Long id;
    @Column(name = "City_Name", nullable = false, length = 50, unique = true)
    private String cityName;
    @Column(name = "State_Id", nullable = false, length = 10)
    private Long stateId;
    
    public Long getId() {
        return this.id;
    }
    
    public String getCityName() {
        return this.cityName;
    }
    
    public Long getStateId() {
        return this.stateId;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }
    
    public void setStateId(final Long stateId) {
        this.stateId = stateId;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof City)) {
            return false;
        }
        final City other = (City)o;
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
        final Object this$stateId = this.getStateId();
        final Object other$stateId = other.getStateId();
        Label_0102: {
            if (this$stateId == null) {
                if (other$stateId == null) {
                    break Label_0102;
                }
            }
            else if (this$stateId.equals(other$stateId)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$cityName = this.getCityName();
        final Object other$cityName = other.getCityName();
        if (this$cityName == null) {
            if (other$cityName == null) {
                return true;
            }
        }
        else if (this$cityName.equals(other$cityName)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof City;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        final Object $stateId = this.getStateId();
        result = result * 59 + (($stateId == null) ? 43 : $stateId.hashCode());
        final Object $cityName = this.getCityName();
        result = result * 59 + (($cityName == null) ? 43 : $cityName.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "City(id=" + this.getId() + ", cityName=" + this.getCityName() + ", stateId=" + this.getStateId() + ")";
    }
    
    public City(final Long id, final String cityName, final Long stateId) {
        this.id = id;
        this.cityName = cityName;
        this.stateId = stateId;
    }
    
    public City() {
    }
}
