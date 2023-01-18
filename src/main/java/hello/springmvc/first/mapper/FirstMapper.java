package hello.springmvc.first.mapper;

import hello.springmvc.first.DTO.FirstDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * - 해당 파일은 xml 파일과 1:1 매핑되는 인터페이스 입니다. (환경파일 내에서 지정함)
 * - 해당 Mapper 폴더는 @Repository 어노테이션을 필수적으로 사용합니다.
 * [ 참고 ]
 * - xml 파일이 아닌 해당 파일 내에서 처리하려면 @Mapper 어노테이션을 사용하길 권장합니다.
 */

@Repository
@Mapper
public interface FirstMapper {
    List<FirstDTO> selectUserList();
    FirstDTO selectUserById(Integer userId);
    FirstDTO selectUserByName(String userName);
    int insertUser(FirstDTO userDto);
    int updateUser(FirstDTO userDto);
    int deleteUserById(Integer userId);
}
