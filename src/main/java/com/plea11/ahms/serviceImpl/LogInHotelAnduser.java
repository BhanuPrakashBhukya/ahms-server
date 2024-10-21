package com.plea11.ahms.serviceImpl;

import com.plea11.ahms.common.exception.DAOException;
import com.plea11.ahms.dao.LogInDao;
import com.plea11.ahms.models.Hotels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LogInHotelAnduser implements UserDetailsService {

    @Autowired
    private LogInDao logInDao;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        Hotels hotel = null;
        try {
            hotel = logInDao.findHotelByUniqueId(identifier)
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (hotel != null) {
            return hotel; // Assuming Hotels implements UserDetails
        }
        // Then check if the identifier is for a user (email/phone)
//        User user = loginDao.findUserByEmailOrPhone(identifier)
//                .orElse(null);
//
//        if (user != null) {
//            return user; // Assuming User implements UserDetails
//        }

        throw new UsernameNotFoundException("User not found with identifier: " + identifier);
    }
}
