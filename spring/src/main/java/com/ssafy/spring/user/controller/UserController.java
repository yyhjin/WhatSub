package com.ssafy.spring.user.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.comb.dto.IngredientDto;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.comb.entity.Ingredient;
import com.ssafy.spring.comb.service.CombPostService;
import com.ssafy.spring.comb.service.IngredientService;
import com.ssafy.spring.exception.NoSuchUserException;
import com.ssafy.spring.user.dto.DibDto;
import com.ssafy.spring.user.dto.UserRequest;
import com.ssafy.spring.user.dto.UserResponse;
import com.ssafy.spring.user.entity.Excluded;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.service.ExcludedService;
import com.ssafy.spring.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@RestController@Api(value = "user-controller", tags={"user-controller"})

@RequestMapping("/user")
//@CrossOrigin(origins = "https://j7a105.p.ssafy.io")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CombPostService combPostService;

    @Autowired
    private ExcludedService excludedService;

    @Autowired
    private IngredientService ingredientService;

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

    @ApiOperation(value = "설문조사 내용 업데이트", notes="회원가입에 성공하면 success, 아니면 fail", httpMethod = "POST")
    @PostMapping("/signup")
    public SuccessResponseResult signUp(@RequestBody UserRequest.SignUpRequest request) throws NoSuchUserException {
        User user = userService.getUserByUserId(request.getUserId());

        if(user == null){
            throw new NoSuchUserException();
        }

        user.updateInfo(request);
//        user = User.builder()
//                .email(request.getEmail())
//                .gender(request.getGender())
//                .birthYear(request.getBirthYear())
//                .userName(request.getUserName())
//                .profileImg(request.getProfileImg())
//                .build();
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

    @ApiOperation(value = "찜목록 조회", notes="찜목록 조회", httpMethod = "POST")
    @PostMapping("/{userName}/dibs")
    public SuccessResponseResult getDibList(@PathVariable String userName) throws NoSuchUserException {
        User user = userService.getUserByUserName(userName);
        if(user == null){
            throw new NoSuchUserException();
        }

        List<DibDto> dibList = userService.getDibsByUserAndStateIsTrue(user).stream()
                .map(DibDto::new)
                .collect(toList());

        return new SuccessResponseResult(dibList);
    }

    @ApiOperation(value = "찜목록과 작성한 꿀조합 조회", notes="찜목록과 작성한 꿀조합 조회", httpMethod = "POST")
    @PostMapping("/{userName}/list")
    public SuccessResponseResult getDibNcombList(@PathVariable String userName) throws NoSuchUserException {
        User user = userService.getUserByUserName(userName);
        if(user == null){
            throw new NoSuchUserException();
        }

        List<DibDto> dibList = userService.getDibsByUserAndStateIsTrue(user).stream()
                .map(DibDto::new)
                .collect(toList());
//        List<CombinationPost> combList = combPostService.findAllByUser(user);
        List<CombinationPost> combList = null;

//        UserResponse.GetDibNcombListResponse response = new UserResponse.GetDibNcombListResponse(dibList, combinationList);
        return new SuccessResponseResult(combList);
    }

    @ApiOperation(value = "subti 등록", notes="subti 결과를 DB에 등록", httpMethod = "POST")
    @PostMapping("/subti")
    public SuccessResponseResult setSubti(@RequestBody UserRequest.SetSubtiRequest request) throws NoSuchUserException {
        int userId = request.getUserId();
        User user = userService.getUserByUserId(userId);
        if(user == null){
            throw new NoSuchUserException();
        }

        String subti = request.getSubti();
        user.setSubti(subti);
        userService.save(user);

        return new SuccessResponseResult();
    }

    @ApiOperation(value = "제외 재료 등록", notes="등록이 완료되면 success, 아니면 fail", httpMethod = "POST")
    @PostMapping("/{userName}/exclude")
    public SuccessResponseResult excludeIngredient(@PathVariable String userName, @RequestBody UserRequest.ExcludeRequest request) throws NoSuchUserException {
        User user = userService.getUserByUserName(userName);
        if(user == null){
            throw new NoSuchUserException();
        }

        List<String> vegetables = request.getVegetables();
        List<String> allergies = request.getAllergies();

        // 알레르기 정보가 포함된 재료들을 가져옴
        List<IngredientDto> ingredientDtoList = ingredientService.findByAllergiesContainsIn(allergies);

        // 알레르기 정보를 포함하여 유저가 못 먹는 재료 id를 추출
        Set<String> excludedIngredientIds = userService.getExcludedIngredientId(vegetables, allergies, ingredientDtoList);
        List<String> excludedIngredientIdsList = new ArrayList<>(excludedIngredientIds);

        List<Ingredient> ingredientList = ingredientService.findByIngredientIdIn(excludedIngredientIdsList);
        List<Excluded> excludedList = new ArrayList<>();

        for(Ingredient ingredient : ingredientList){
            // 유저가 못먹는 재료를 삽입
            Excluded excluded = Excluded.builder()
                            .user(user)
                            .ingredient(ingredient)
                            .build();
            // save < saveAll의 성능 차이
//            excludedService.save(excluded);
            excludedList.add(excluded);
        }

        excludedService.saveAll(excludedList);

        return new SuccessResponseResult();
    }
}
