package ohtu.authentication;

import ohtu.domain.User;
import ohtu.data_access.UserDao;

import ohtu.util.CreationStatus;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }
        
    	// salasana ja salasanan confirmation ovat samat
    	if (!password.equals(passwordConfirmation)) {
    		status.addError("password and password confirmation do not match");
    	}
        
    	// käyttäjätunnuksen on oltava vähintään 3 merkin pituinen merkkijono
    	if (username.length()<3) {
    		status.addError("username should have at least 3 characters");
    	}

    	// käyttäjätunnuksen on oltava merkeistä a-z koostuva
    	if (!username.matches("^[a-z]+$")) {
    		status.addError("username cannot contain other characters than a-z lower case");
    	}
    	    	
        // salasanan on oltava pituudeltaan vähintään 8 merkkiä
    	if (password.length()<8) {
    		status.addError("password should have at least 8 characters");
    	}
    	
    	// salasana ei saa koostua pelkästään kirjaimista
    	if (password.matches("^[a-zA-Z]+$")) {
    		status.addError("password has to contain at least one number or special character");
    	}

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }

}
