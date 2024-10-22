package com.plea11.ahms.service;

import com.plea11.ahms.common.exception.DAOException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LogInService {

    UserDetails loadUserByIdentifier(String identifier) throws UsernameNotFoundException, DAOException;

}
