package zzu.lab305.lib305.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;

    private String userSnum;

    private String userPassword;

    private String userGroup;

    private String userSpec;

    private Boolean userStatus;

    private String userRole;

    private String userBooks;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserSnum() {
        return userSnum;
    }

    public void setUserSnum(String userSnum) {
        this.userSnum = userSnum == null ? null : userSnum.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup == null ? null : userGroup.trim();
    }

    public String getUserSpec() {
        return userSpec;
    }

    public void setUserSpec(String userSpec) {
        this.userSpec = userSpec == null ? null : userSpec.trim();
    }

    public Boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public String getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(String userBooks) {
        this.userBooks = userBooks == null ? null : userBooks.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserSnum() == null ? other.getUserSnum() == null : this.getUserSnum().equals(other.getUserSnum()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getUserGroup() == null ? other.getUserGroup() == null : this.getUserGroup().equals(other.getUserGroup()))
            && (this.getUserSpec() == null ? other.getUserSpec() == null : this.getUserSpec().equals(other.getUserSpec()))
            && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()))
            && (this.getUserRole() == null ? other.getUserRole() == null : this.getUserRole().equals(other.getUserRole()))
            && (this.getUserBooks() == null ? other.getUserBooks() == null : this.getUserBooks().equals(other.getUserBooks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserSnum() == null) ? 0 : getUserSnum().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getUserGroup() == null) ? 0 : getUserGroup().hashCode());
        result = prime * result + ((getUserSpec() == null) ? 0 : getUserSpec().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        result = prime * result + ((getUserRole() == null) ? 0 : getUserRole().hashCode());
        result = prime * result + ((getUserBooks() == null) ? 0 : getUserBooks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userSnum=").append(userSnum);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userGroup=").append(userGroup);
        sb.append(", userSpec=").append(userSpec);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", userRole=").append(userRole);
        sb.append(", userBooks=").append(userBooks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}