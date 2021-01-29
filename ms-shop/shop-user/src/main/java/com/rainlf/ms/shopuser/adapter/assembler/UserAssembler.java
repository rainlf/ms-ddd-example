package com.rainlf.ms.shopuser.adapter.assembler;

import com.rainlf.ms.shopuser.adapter.dto.UserDTO;
import com.rainlf.ms.shopuser.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : rain
 * @date : 2021/1/28 20:20
 */
@Component
public class UserAssembler {

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }
}
