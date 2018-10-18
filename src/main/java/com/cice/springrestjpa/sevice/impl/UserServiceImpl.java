package com.cice.springrestjpa.sevice.impl;

import com.cice.springrestjpa.sevice.IUsuarioService;
import com.cice.springrestjpa.web.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUsuarioService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @Override
    public UsuarioDTO createUser(UsuarioDTO userDto) {
        UsuarioDTO returnValue = new UsuarioDTO();


        // Generate secure password
        userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        // Record data into a database
        userEntity = userRepository.save(userEntity);


        return returnValue;
    }
}