package hello.springmvc.first.Service;

import hello.springmvc.first.DTO.FirstDTO;

import java.util.List;

public interface FirstService {
    public List<FirstDTO> selectUserList();
    public FirstDTO selectUserById(Integer userId);
    public int insertUser(FirstDTO userDto);
    public int updateUser(FirstDTO userDto);
    public int deleteUserById(Integer userId);
}