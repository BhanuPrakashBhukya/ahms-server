package com.plea11.ahms.dao;

import com.plea11.ahms.common.exception.DAOException;
import com.plea11.ahms.models.Hotels;

import java.util.Optional;

public interface LogInDao {

    Optional<Hotels> findHotelByUniqueId(String uniqueId) throws DAOException;

}
