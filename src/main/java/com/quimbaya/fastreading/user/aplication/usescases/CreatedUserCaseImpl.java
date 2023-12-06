package com.quimbaya.fastreading.user.aplication.usescases;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.quimbaya.fastreading.user.domain.model.Users;
import com.quimbaya.fastreading.user.domain.port.in.CreatedUserUseCase;
import com.quimbaya.fastreading.user.domain.port.out.UserRepositoryPort;


public class CreatedUserCaseImpl implements CreatedUserUseCase{
	private final UserRepositoryPort userRepositoryPort; // Inyección de la dependencia del puerto del repositorio
	private final BCryptPasswordEncoder passwordEncoder; // Inyección de la dependencia del codificador de contraseñas

	// Constructor con las dependencias inyectadas
	public CreatedUserCaseImpl(UserRepositoryPort userRepositoryPort, BCryptPasswordEncoder passwordEncoder) {
		this.userRepositoryPort = userRepositoryPort;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
    public Users createdUser(Users user) {
        String hashedPassword = passwordEncoder.encode(user.getUserPass()); // Codifica la contraseña del usuario
        user.setUserPass(hashedPassword); // Establece la contraseña codificada en el usuario
        return userRepositoryPort.save(user); // Guarda el usuario con la contraseña codificada en el repositorio
    }

}
