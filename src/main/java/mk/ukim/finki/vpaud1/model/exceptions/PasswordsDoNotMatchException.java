package mk.ukim.finki.vpaud1.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{

    public PasswordsDoNotMatchException ()
    {
        super("Passwords Do Not Match Exception");
    }
}
