package hello.springmvc.first.Controller;

import hello.springmvc.first.DTO.FirstDTO;
import hello.springmvc.first.DTO.TokenDTO;
import hello.springmvc.first.Service.FirstService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.el.parser.Token;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"FIRST API 정보를 제공하는 Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/first")
public class FirstController {
    private final FirstService firstService;

    @ApiOperation(value = "모든 유저 정보를 반환하는 메소드")
    @GetMapping()
    public List<FirstDTO> selectUserList(){
        List<FirstDTO> result = firstService.selectUserList();
        return result;
    }

    @ApiOperation(value = "해당 유저 정보를 반환하는 메소드")
    @ApiImplicitParam(name = "userId", value = "조회할 유저 ID", required = true, dataType = "int")
    @GetMapping("/{userId}")
    public FirstDTO selectUserById(@PathVariable("userId") int userId){
        FirstDTO result = firstService.selectUserById(userId);
        return result;
    }

    @ApiOperation(value = "유저를 추가하는 메소드")
    @PostMapping()
    public FirstDTO insertUser(@RequestBody @Valid FirstDTO userDto){
        firstService.insertUser(userDto);
        return userDto;
    }

    @ApiOperation(value = "로그인 후 토큰을 반환하는 메소드")
    @PostMapping("/login")
    public TokenDTO loginUser(@RequestBody @Valid FirstDTO userDto){
        return firstService.loginUser(userDto);
    }
}
