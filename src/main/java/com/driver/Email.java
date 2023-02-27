package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals(password)){
            if(isValid(newPassword)){
                this.password = newPassword;
                System.out.println("Password changed successully");
            }else {
                System.out.println("The password is not valid");
            }
        }else {
            System.out.println("The given password does not match current password");
        }
    }

    public boolean isValid(String newPassword){

        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsOneDigit = false;
        boolean containsSpecialCharacter = false;

        if(newPassword.length()<8) return false;

        for (int i = 0;i<newPassword.length();i++){
            char ch = newPassword.charAt(i);
            if(ch>='A' && ch<='Z'){
                containsUpperCase =true;
            }
            else if(ch>='a' && ch<='z'){
                containsLowerCase = true;
            }
            else if(ch>='0'&&ch<='9'){
                containsOneDigit = true;
            }
            else{
                containsSpecialCharacter = true;
            }
        }
        if(containsUpperCase && containsLowerCase && containsOneDigit && containsSpecialCharacter)
            return true;
        return false;
    }
}
