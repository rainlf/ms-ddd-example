package com.rainlf.ms.shopuser.adapter.web.assembler;

import com.rainlf.ms.shopuser.adapter.web.dto.UserDTO;
import com.rainlf.ms.shopuser.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author : rain
 * @date : 2021/1/28 20:20
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAssembler {

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }
}
