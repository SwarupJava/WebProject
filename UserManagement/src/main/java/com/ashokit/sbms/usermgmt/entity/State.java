package com.ashokit.sbms.usermgmt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "STATE_MASTER")
public class State
{
	@Id
    @Column(name = "State_Id", nullable = false, length = 10, unique = true)
    private Long id;
	
	@Column(name = "Country_Id", nullable = false, length = 10)
    private Long countryId;
	
    @Column(name = "State_Name", nullable = false, length = 50, unique = true)
    private String stateName;
    
    public Long getId() {
        return this.id;
    }
    
    public Long getCountryId() {
        return this.countryId;
    }
    
    public String getStateName() {
        return this.stateName;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public void setCountryId(final Long countryId) {
        this.countryId = countryId;
    }
    
    public void setStateName(final String stateName) {
        this.stateName = stateName;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof State)) {
            return false;
        }
        final State other = (State)o;
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
        final Object this$countryId = this.getCountryId();
        final Object other$countryId = other.getCountryId();
        Label_0102: {
            if (this$countryId == null) {
                if (other$countryId == null) {
                    break Label_0102;
                }
            }
            else if (this$countryId.equals(other$countryId)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$stateName = this.getStateName();
        final Object other$stateName = other.getStateName();
        if (this$stateName == null) {
            if (other$stateName == null) {
                return true;
            }
        }
        else if (this$stateName.equals(other$stateName)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof State;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        final Object $countryId = this.getCountryId();
        result = result * 59 + (($countryId == null) ? 43 : $countryId.hashCode());
        final Object $stateName = this.getStateName();
        result = result * 59 + (($stateName == null) ? 43 : $stateName.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "State(id=" + this.getId() + ", countryId=" + this.getCountryId() + ", stateName=" + this.getStateName() + ")";
    }
    
    public State(final Long id, final Long countryId, final String stateName) {
        this.id = id;
        this.countryId = countryId;
        this.stateName = stateName;
    }
    
    public State() {
    }
}
