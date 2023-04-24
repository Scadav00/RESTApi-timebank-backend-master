package net.btcmp.timebank.exception;

public class PasswordNotEqualException extends RuntimeException {
    public String notEqualPasswords;

    public PasswordNotEqualException(String notEqualPasswords) {this.notEqualPasswords = notEqualPasswords;}
}
