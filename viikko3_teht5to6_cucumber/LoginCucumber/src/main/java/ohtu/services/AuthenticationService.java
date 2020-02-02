package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

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

    public boolean createUser(String username, String password) {
    	
        if (userDao.findByName(username) != null) {
            return false;
        }

        // validity check of username and password
        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password

    	// k‰ytt‰j‰tunnuksen on oltava v‰hint‰‰n 3 merkin pituinen merkkijono
    	if (username.length()<3) {
    		return true;
    	}

    	// k‰ytt‰j‰tunnuksen on oltava merkeist‰ a-z koostuva
    	if (!username.matches("^[a-z]+$")) {
    		return true;
    	}
    	    	
        // salasanan on oltava pituudeltaan v‰hint‰‰n 8 merkki‰
    	if (password.length()<8) {
    		return true;
    	}
    	
    	// salasana ei saa koostua pelk‰st‰‰n kirjaimista
    	if (password.matches("^[a-zA-Z]+$")) {
    		return true;
    	}
    	
    	
        return false;
    }
}
