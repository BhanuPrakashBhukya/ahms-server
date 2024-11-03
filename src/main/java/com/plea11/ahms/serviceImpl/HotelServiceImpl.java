package com.plea11.ahms.serviceImpl;

import com.plea11.ahms.common.exception.AppServerException;
import com.plea11.ahms.commonutils.PasswordGenerator;
import com.plea11.ahms.dao.HotelDao;
import com.plea11.ahms.models.Country;
import com.plea11.ahms.models.Hotels;
import com.plea11.ahms.models.States;
import com.plea11.ahms.restmodels.HotelRM;
import com.plea11.ahms.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bhukyabhanuprakash
 */

@Service
public class HotelServiceImpl implements HotelService {

    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private EmailService emailService;

    @Override
    public Hotels register(Hotels hotel) throws AppServerException {
        String genPassword = PasswordGenerator.generateRandomPassword();
        logger.info("Generated Password: {}", genPassword);

        String encryptPassword = passwordEncoder.encode(genPassword);
        hotel.setPassword(encryptPassword);
        Hotels hotels = hotelDao.register(hotel);

        SendWelcomeMail(hotel, genPassword);

        return hotels;
    }

    public void SendWelcomeMail(Hotels hotel, String password) throws AppServerException {
        String receiver = hotel.getEmail();
        String subject = "Onboarded to Plea11";
        String content = String.format(
                "Welcome %s,\r\nYour Log In Credentials are:\r\n Unique Id: %s \r\nPassword: %s\r\n Thank You!",
                hotel.getName(), hotel.getId(), password
        );
        emailService.sendSimpleMail(receiver, subject, content);
    }

    @Override
    public List<Hotels> getAllHotels(Hotels hotels, Authentication authentication) throws AppServerException {
        return hotelDao.getAllHotels((Hotels) authentication.getPrincipal());
    }

    @Override
    public Hotels changePassword(Hotels hotels, Authentication authentication) throws AppServerException {
        String encryptPassword = passwordEncoder.encode(hotels.getPassword());
        hotels.setPassword(encryptPassword);
        return hotelDao.changePassword(hotels, (Hotels) authentication.getPrincipal());
    }

    @Override
    public List<Country> getCountries() throws AppServerException {
        return hotelDao.getCountries();
    }

    @Override
    public List<States> getStates() throws AppServerException {
        return hotelDao.getStates();
    }
}
