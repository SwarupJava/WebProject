// 
// Decompiled by Procyon v0.5.36
// 

package com.ashokit.sbms.usermgmt.controller;

public class TempPassVerification
{
    private String email;
    private String tempPassword;
    
    public String getEmail() {
        return this.email;
    }
    
    public String getTempPassword() {
        return this.tempPassword;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public void setTempPassword(final String tempPassword) {
        this.tempPassword = tempPassword;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TempPassVerification)) {
            return false;
        }
        final TempPassVerification other = (TempPassVerification)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        Label_0065: {
            if (this$email == null) {
                if (other$email == null) {
                    break Label_0065;
                }
            }
            else if (this$email.equals(other$email)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$tempPassword = this.getTempPassword();
        final Object other$tempPassword = other.getTempPassword();
        if (this$tempPassword == null) {
            if (other$tempPassword == null) {
                return true;
            }
        }
        else if (this$tempPassword.equals(other$tempPassword)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TempPassVerification;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $email = this.getEmail();
        result = result * 59 + (($email == null) ? 43 : $email.hashCode());
        final Object $tempPassword = this.getTempPassword();
        result = result * 59 + (($tempPassword == null) ? 43 : $tempPassword.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TempPassVerification(email=" + this.getEmail() + ", tempPassword=" + this.getTempPassword() + ")";
    }
}
