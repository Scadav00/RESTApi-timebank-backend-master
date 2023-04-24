package net.btcmp.timebank.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class NewUserDto {
//    @Id
//    private Long id;

    @NotBlank(message = "User name cannot be empty.")
    private String username;

    @Pattern(regexp = "\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|\n" +
            "2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|\n" +
            "4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$",
            message = "Your phone number has wrong format. Please, check if your phone number starts with prefix.")
    @NotBlank(message = "Phone number cannot be empty.")
    private String phone;

    @NotBlank(message = "Password cannot be empty.")
    private String password;

    @NotBlank(message = "Confirm password cannot be empty.")
    private String confirmPassword;

    public NewUserDto() {
//        empty constructor
    }

    public NewUserDto(String username, String phone, String password, String confirmPassword) {
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
