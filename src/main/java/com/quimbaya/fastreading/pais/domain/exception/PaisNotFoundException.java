package com.quimbaya.fastreading.pais.domain.exception;

import com.quimbaya.fastreading.pais.utils.PaisConstanst;

public class PaisNotFoundException extends RuntimeException {
	
    
    public PaisNotFoundException(Long roleId) {
        super(PaisConstanst.PaisException + roleId + PaisConstanst.PaisNotFound);
    }
}