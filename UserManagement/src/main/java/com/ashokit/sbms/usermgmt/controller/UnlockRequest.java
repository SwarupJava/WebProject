// 
// Decompiled by Procyon v0.5.36
// 

package com.ashokit.sbms.usermgmt.controller;

public class UnlockRequest
{
    private String email;
    private String tempPassword;
    private String newPassword;
    
    public String getEmail() {
        return this.email;
    }
    
    public String getTempPassword() {
        return this.tempPassword;
    }
    
    public String getNewPassword() {
        return this.newPassword;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public void setTempPassword(final String tempPassword) {
        this.tempPassword = tempPassword;
    }
    
    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UnlockRequest)) {
            return false;
        }
        final UnlockRequest other = (UnlockRequest)o;
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
        Label_0102: {
            if (this$tempPassword == null) {
                if (other$tempPassword == null) {
                    break Label_0102;
                }
            }
            else if (this$tempPassword.equals(other$tempPassword)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$newPassword = this.getNewPassword();
        final Object other$newPassword = other.getNewPassword();
        if (this$newPassword == null) {
            if (other$newPassword == null) {
                return true;
            }
        }
        else if (this$newPassword.equals(other$newPassword)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof UnlockRequest;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $email = this.getEmail();
        result = result * 59 + (($email == null) ? 43 : $email.hashCode());
        final Object $tempPassword = this.getTempPassword();
        result = result * 59 + (($tempPassword == null) ? 43 : $tempPassword.hashCode());
        final Object $newPassword = this.getNewPassword();
        result = result * 59 + (($newPassword == null) ? 43 : $newPassword.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "UnlockRequest(email=" + this.getEmail() + ", tempPassword=" + this.getTempPassword() + ", newPassword=" + this.getNewPassword() + ")";
    }
}
