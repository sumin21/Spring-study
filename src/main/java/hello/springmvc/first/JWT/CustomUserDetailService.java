package hello.springmvc.first.JWT;

import hello.springmvc.first.DTO.FirstDTO;
import hello.springmvc.first.Exceptions.NotFoundException;
import hello.springmvc.first.mapper.FirstMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final FirstMapper firstMapper;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        FirstDTO findUser = Optional.ofNullable(firstMapper.selectUserById(Integer.valueOf(userId))).orElseThrow(() -> new NotFoundException());
        return UserPrincipal.create(findUser);
    }
}
