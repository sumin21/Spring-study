package hello.springmvc.first.Controller;

import hello.springmvc.first.DTO.FirstDTO;
import hello.springmvc.first.DTO.TokenDTO;
import hello.springmvc.first.Service.FirstService;
import lombok.RequiredArgsConstructor;
import org.apache.el.parser.Token;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/first")
public class FirstController {
    private final FirstService firstService;

    @GetMapping()
    public List<FirstDTO> selectUserList(){
        List<FirstDTO> result = firstService.selectUserList();
        return result;
    }

    @GetMapping("/{userId}")
    public FirstDTO selectUserById(@PathVariable("userId") int userId){
        FirstDTO result = firstService.selectUserById(userId);
        return result;
    }

    @PostMapping()
    public FirstDTO insertUser(@RequestBody @Valid FirstDTO userDto){
        firstService.insertUser(userDto);
        return userDto;
    }

    @PostMapping("/login")
    public TokenDTO loginUser(@RequestBody @Valid FirstDTO userDto){
        return firstService.loginUser(userDto);
    }
}
