package com.ssafy.spring.user.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.exception.NoSuchUserException;
import com.ssafy.spring.user.dto.UserRequest;
import com.ssafy.spring.user.dto.UserResponse;
import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@Api(value = "user-controller", tags={"user-controller"})

@RequestMapping("/user")
//@CrossOrigin(origins = "https://j7a105.p.ssafy.io")
public class UserController {

    @Autowired
    private UserService userService;

    // 더미 데이터 생성 api
    @ApiOperation(value = "더미 데이터 생성", notes="임시 유저 데이터 5000개 삽입", httpMethod = "GET")
    @GetMapping("/dummy")
    public SuccessResponseResult dummy(){
        String[] SUBTI_LIST = new String[]{"LSAH", "LSAM", "LSEH", "LSEM",
                                           "LCAH", "LCAM", "LCEH", "LCEM",
                                           "ISAH", "ISAM", "ISEH", "ISEM",
                                           "ICAH", "ICAM", "ICEH", "ICEM"};
        String[] GENDER_LIST = new String[]{"0", "1"};
        Boolean[] DIET_LIST = new Boolean[]{true, false};

        for(int i = 1;i <= 5000;i++){
            String email = "ssafy" + i + "@naver.com";
            String gender = GENDER_LIST[(int)((Math.random()*10000)%2)];
            int birthYear = (int)((Math.random()*10000)%70 + 1942); //10~80살 사이 랜덤하게 생성(2012~1942)
            String userName = "ssafy" + i;
            String profileImage = "default";

            Boolean isDiet = DIET_LIST[(int)((Math.random()*10000)%2)];;
            int subtiIndex = (int)((Math.random()*10000)%16); // 0~16사이의 난수 생성
            String subti = SUBTI_LIST[subtiIndex];

            User user = User.builder()
                    .email(email)
                    .gender(gender)
                    .birthYear(birthYear)
                    .userName(userName)
                    .profileImg(profileImage)
                    .subti(subti)
                    .isDiet(isDiet)
                    .build();

            userService.save(user);
        }

        return new SuccessResponseResult();
    }

    @ApiOperation(value = "일반 회원가입", notes="회원가입에 성공하면 success, 아니면 fail", httpMethod = "POST")
    @PostMapping("/signup")
    public SuccessResponseResult signUp(@RequestBody UserRequest.SignUpRequest request){
        User user = User.builder()
                .email(request.getEmail())
                .gender(request.getGender())
                .birthYear(request.getBirthYear())
                .userName(request.getUserName())
                .profileImg(request.getProfileImg())
                .build();

        // 회원가입 로직
        userService.save(user);
        String userName = user.getUserName();
        return new SuccessResponseResult(userName);
    }
    

//    @ApiOperation(value = "일반 로그인", notes="로그인에 성공하면 username 반환", httpMethod = "POST")
//    @PostMapping("/login")
//    public SuccessResponseResult login(@RequestBody UserRequest.LoginRequest request){
//
//        // 로그인 로직
//
//        return new SuccessResponseResult();
//    }

    @ApiOperation(value = "유저 정보 조회", notes="userName을 통해 유저 정보 조회(남자: 0, 여자: 1)", httpMethod = "GET")
    @GetMapping("/{userName}")
    public SuccessResponseResult getUser(@PathVariable String userName) throws NoSuchUserException {
        User user = userService.getUserByUserName(userName);
        // 존재하지 않는 유저 예외 처리
        if(user == null){
            throw new NoSuchUserException();
        }

        UserResponse.GetUserResponse response = UserResponse.GetUserResponse.builder()
                .email(user.getEmail())
                .gender(user.getGender())
                .birthYear(user.getBirthYear())
                .userName(user.getUserName())
                .profileImg(user.getProfileImg())
                .subti(user.getSubti())
                .isDiet(user.isDiet())
                .build();

        return new SuccessResponseResult(response);
    }


    @ApiOperation(value = "중복 닉네임 검사", notes="이미 등록된 이름이면 false, 아니면 true", httpMethod = "GET")
    @GetMapping("/check/{userName}")
    public SuccessResponseResult checkUserName(@PathVariable String userName){
        boolean isDuplicate = userService.existsByUserName(userName);
        return new SuccessResponseResult(isDuplicate);
    }

    @ApiOperation(value = "찜목록과 작성한 꿀조합 조회", notes="찜목록과 작성한 꿀조합 조회", httpMethod = "POST")
    @PostMapping("/{userName}/list")
    public SuccessResponseResult getDibNcombList(@PathVariable String userName){
        User user = userService.getUserByUserName(userName);
        List<Dib> dibList = userService.getDibsByUserAndStateIsTrue(user);
        List<Combination> combinationList = null; // 임시 꿀조합 리스트

        UserResponse.GetDibNcombListResponse response = new UserResponse.GetDibNcombListResponse(dibList, combinationList);
        return new SuccessResponseResult(response);
    }

    @ApiOperation(value = "subti 등록", notes="subti 결과를 DB에 등록", httpMethod = "POST")
    @PostMapping("subti")
    public SuccessResponseResult setSubti(@RequestBody UserRequest.SetSubtiRequest request) {
        int userId = request.getUserId();
//        User user = UserService.getUserByUserId(userId);
//
//        String subti = request.getSubti();
//        user.setSubti(subti);
//        UserService.save(user);
        return new SuccessResponseResult();
    }

    @ApiOperation(value = "제외 재료 등록", notes="등록이 완료되면 success, 아니면 fail", httpMethod = "POST")
    @PostMapping("/{userName}/exclude")
    public SuccessResponseResult excludeIngredient(@RequestBody UserRequest.ExcludeRequest request){
        List<Integer> vegetables = request.getVegetables();
        List<Integer> allergies = request.getAllergies();

        // 알레르기 및 제외 재료 로직

        return new SuccessResponseResult();
    }
}
