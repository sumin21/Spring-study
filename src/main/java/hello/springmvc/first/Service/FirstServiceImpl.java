package hello.springmvc.first.Service;

import hello.springmvc.first.DTO.FirstDTO;
import hello.springmvc.first.DTO.TokenDTO;
import hello.springmvc.first.Exceptions.ErrorCode;
import hello.springmvc.first.Exceptions.NotFoundException;
import hello.springmvc.first.JWT.JwtTokenProvider;
import hello.springmvc.first.mapper.FirstMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FirstServiceImpl implements FirstService{
    private final FirstMapper firstMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public List<FirstDTO> selectUserList() {
        return firstMapper.selectUserList();
    }

    @Override
    public FirstDTO selectUserById(Integer userId) {
        FirstDTO findUser =  Optional.ofNullable(firstMapper.selectUserById(userId)).orElseThrow(() -> new NotFoundException());
        return findUser;
    }

    @Override
    public FirstDTO selectUserByName(String userName) {
        FirstDTO findUser =  Optional.ofNullable(firstMapper.selectUserByName(userName)).orElseThrow(() -> new NotFoundException());
        return findUser;
    }

    @Override
    public int insertUser(FirstDTO userDto) {
        return firstMapper.insertUser(userDto);
    }

    @Override
    public TokenDTO loginUser(FirstDTO userDto) {
        FirstDTO findUser =  Optional.ofNullable(firstMapper.selectUserById(userDto.getId())).orElseThrow(() -> new NotFoundException());
        // userId로 JWT 생성
        String accessToken = jwtTokenProvider.createAccessToken(findUser.getId());
        TokenDTO tokenDTO = new TokenDTO(accessToken);
        return tokenDTO;
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
