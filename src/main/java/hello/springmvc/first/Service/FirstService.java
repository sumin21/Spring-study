package hello.springmvc.first.Service;

import hello.springmvc.first.DTO.FirstDTO;
import hello.springmvc.first.DTO.TokenDTO;

import java.util.List;
import java.util.Optional;

public interface FirstService {
    public List<FirstDTO> selectUserList();
    public FirstDTO selectUserById(Integer userId);
    public FirstDTO selectUserByName(String userName);
    public int insertUser(FirstDTO userDto);
    public TokenDTO loginUser(FirstDTO userDto);
    public int updateUser(FirstDTO userDto);
    public int deleteUserById(Integer userId);
}
