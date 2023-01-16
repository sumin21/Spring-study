package hello.springmvc.first.Controller;

import hello.springmvc.first.DTO.FirstDTO;
import hello.springmvc.first.Service.FirstService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
