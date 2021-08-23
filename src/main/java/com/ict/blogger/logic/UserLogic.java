/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.entities.User;
import com.ict.blogger.dto.UserDTO;
import com.ict.blogger.repo.UserRepo;
import mn.ds.util.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tseke
 */
@Service
@Transactional
public class UserLogic {

    @Autowired
    private UserRepo repo;
    @Autowired
    private IdGenerator idG;
    @Autowired
    private Regex regex;
    @Autowired
    private UserCheck check;

    public ResponseDTO userAdd(UserDTO dTO) {

        if (!regex.RegexEmail(dTO)) {
            return ResponseDTO.getInstance(false, "Email Буруу байн");

        } else if (!regex.RegexPhoneNo(dTO)) {
            return ResponseDTO.getInstance(false, "Утасны дугаар буруу байн");

        } else if (!regex.RegexPass(dTO)) {
            return ResponseDTO.getInstance(false, "Том жижиг үсэг, тэмдэг, тоо ашиглана уу");

        } else if (!dTO.getPass().equals(dTO.getPasscheck())) {
            return ResponseDTO.getInstance(false, "Нууц үг ээ шалгануу");

        } else if (check.UserCheck(dTO)) {
            User user = new User();
            user.setUserId(idG.userId());
            BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
            user.setEmail(dTO.getEmail());
            String pass = dTO.getPass();
            user.setPassword(passEncoder.encode(pass));
            user.setPhoneNo(dTO.getPhoneNo());
            user.setRole(1);
            repo.save(user);

            return ResponseDTO.getInstance(true);
        } else {
            return ResponseDTO.getInstance(false, "Email эсвэл Утасны дугаар бүртгэлтэй байн");
        }
    }
}
