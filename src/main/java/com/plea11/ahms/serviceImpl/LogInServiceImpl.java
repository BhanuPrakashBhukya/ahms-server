package com.plea11.ahms.serviceImpl;

import com.plea11.ahms.common.exception.AppServerException;
import com.plea11.ahms.common.exception.DAOException;
import com.plea11.ahms.dao.LogInDao;
import com.plea11.ahms.models.Hotels;
import com.plea11.ahms.models.LogIn;
import com.plea11.ahms.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author bhukyabhanuprakash
 */

@Service
public class LogInServiceImpl implements LogInService {

    @Autowired
    private LogInDao logInDao;

    @Override
    public UserDetails loadUserByIdentifier(String identifier) throws UsernameNotFoundException, DAOException {
        // Try to load hotel first by uniqueId
        Optional<Hotels> hotelOpt = logInDao.findHotelByUniqueId(identifier);
        if (hotelOpt.isPresent()) {
            Hotels hotel = hotelOpt.get();
            return new org.springframework.security.core.userdetails.User(
                    Long.toString(hotel.getId()),
                    hotel.getPassword(),
                    hotel.getAuthorities() // Assuming you handle roles/authorities
            );
        }
        // Then try to load user by email or phone number
//        Optional<User> userOpt = logInDao.findUserByEmailOrPhone(identifier);
//        if (userOpt.isPresent()) {
//            User user = userOpt.get();
//            return new org.springframework.security.core.userdetails.User(
//                    user.getEmail(), // Assuming user uses email or phone number to log in
//                    user.getPassword(),
//                    user.getAuthorities()
//            );
//        }
        // Throw exception if neither hotel nor user found
        throw new UsernameNotFoundException("No hotel or user found with identifier: " + identifier);
    }
}
