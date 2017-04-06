package dto;

import model.Entity;

import java.time.LocalDate;


public class UserDTO extends Entity<Integer> {
        private String login;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private String sex;
        private int innerTell;
//        private LocalDate birthday;
        private RoleDTO role;

        public UserDTO() {
        }


        public UserDTO(String login, String password, String firstName, String lastName, String email, String sex, int innerTell, RoleDTO role) {
        this.login = login;
        this.role = role;
        this.innerTell = innerTell;
        this.sex = sex;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public RoleDTO getRole() {
        return this.role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getInnerTell() {
        return innerTell;
    }

    public void setInnerTell(int innerTell) {
        this.innerTell = innerTell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        if (!super.equals(o)) return false;

        UserDTO userDTO = (UserDTO) o;

        if (innerTell != userDTO.innerTell) return false;
        if (login != null ? !login.equals(userDTO.login) : userDTO.login != null) return false;
        if (password != null ? !password.equals(userDTO.password) : userDTO.password != null) return false;
        if (firstName != null ? !firstName.equals(userDTO.firstName) : userDTO.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userDTO.lastName) : userDTO.lastName != null) return false;
        if (email != null ? !email.equals(userDTO.email) : userDTO.email != null) return false;
        if (sex != null ? !sex.equals(userDTO.sex) : userDTO.sex != null) return false;
        return role != null ? role.equals(userDTO.role) : userDTO.role == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + innerTell;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", innerTell=" + innerTell +
                ", role=" + role +
                '}';
    }
}


