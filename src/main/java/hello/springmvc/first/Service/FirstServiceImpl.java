package hello.springmvc.first.Service;

import hello.springmvc.first.DTO.FirstDTO;
import hello.springmvc.first.Exceptions.ErrorCode;
import hello.springmvc.first.Exceptions.NotFoundException;
import hello.springmvc.first.mapper.FirstMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstServiceImpl implements FirstService{
    private final FirstMapper firstMapper;

    @Override
    public List<FirstDTO> selectUserList() {
        return firstMapper.selectUserList();
    }

    @Override
    public FirstDTO selectUserById(Integer userId) {
        FirstDTO findUser =  firstMapper.selectUserById(userId);
        if(findUser == null) throw new NotFoundException(ErrorCode.NOT_FOUND);
        return findUser;
    }

    @Override
    public int insertUser(FirstDTO userDto) {
        return firstMapper.insertUser(userDto);
    }

    @Override
    public int updateUser(FirstDTO userDto) {
        return firstMapper.updateUser(userDto);
    }

    @Override
    public int deleteUserById(Integer userId) {
        return firstMapper.deleteUserById(userId);
    }
}
