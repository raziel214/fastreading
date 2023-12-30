package com.quimbaya.fastreading.ciudad.domain.exception;

import com.quimbaya.fastreading.ciudad.domain.utils.CiudadConstants;

public class CiudadNotFoundException extends RuntimeException  {

	public CiudadNotFoundException(Long ciudadId) {
        super(CiudadConstants.CiudadNotFound + ciudadId + CiudadConstants.CiudadException);
    }
}
