package hello.springmvc.first.Controller;

import hello.springmvc.first.DTO.FirstDTO;
import hello.springmvc.first.Service.FirstService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final FirstService firstService;

    @GetMapping()
    public List<FirstDTO> selectUserList(){
        List<FirstDTO> result = firstService.selectUserList();
        return result;
    }
}
