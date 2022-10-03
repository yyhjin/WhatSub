package com.ssafy.spring;

import com.ssafy.spring.user.entity.Collection;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.service.CollectionService;
import com.ssafy.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
@EnableAsync
public class Scheduler {

    @Autowired
    private UserService userService;

    @Autowired
    private CollectionService collectionService;

    @Scheduled(cron = "@monthly")
    @Async
    public void collectionScheduler() {
        /**
         * 월별 랭킹 업데이트
         **/

        
        /**
         * 컬렉션 추가
         **/
        // 임시 랭킹 데이터
        String userName = "test1";
        String menuName = "에그마요";
        int ranking = 1;

        Calendar cal = Calendar.getInstance();
        int year = 2022; int month = Calendar.OCTOBER; int day = 1;
        cal.set(year, month, day);
        Date rankDate = new Date(cal.getTimeInMillis());

        User user = userService.getUserByUserName(userName);

        Collection collection = Collection.builder()
                .user(user)
                .menuName(menuName)
                .ranking(ranking)
                .rankDate(rankDate)
                .build();

        collectionService.save(collection);

        /**
         * 월별 랭킹 정보 처리
         **/
    }

    // Async Schedule Test Code
//    @Scheduled(cron = "*/2 * * * * *")
//    @Async
//    public void twoSecondScheduler() {
//        System.out.print("2초마다 반복 함수!");
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
//    }
//
//    @Scheduled(cron = "*/3 * * * * *")
//    @Async
//    public void threeSecondScheduler() {
//        System.out.print("3초마다 반복 함수!");
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
//    }
}
