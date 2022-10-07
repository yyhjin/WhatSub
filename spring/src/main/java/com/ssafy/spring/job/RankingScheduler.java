package com.ssafy.spring.job;

import com.google.gson.Gson;
import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.comb.repository.MenuRepository;
import com.ssafy.spring.ranking.dto.RankingData;
import com.ssafy.spring.ranking.entity.Ranking;
import com.ssafy.spring.ranking.repository.RankingRepository;
import com.ssafy.spring.user.entity.Collection;
import com.ssafy.spring.user.repository.UserRepository;
import com.ssafy.spring.user.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RankingScheduler {

    @Autowired
    private RankingRepository rankingRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CollectionService collectionService;

    // 매달 1일 새벽 다섯시
    @Scheduled(cron = "@monthly")
//    @Scheduled(cron = "*/30 * * * * *")
    @Async
    public void rankingScheduler() {

        Calendar cal = Calendar.getInstance(); // 현재 시간
        int year, month, day;
        if(cal.get(Calendar.MONTH) == Calendar.JANUARY){
            year = cal.get(Calendar.YEAR) - 1;
            month = Calendar.DECEMBER;
        }
        else{
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);
        }
        day = 1;
        cal.set(year, month, day, 9, 0, 0);
        Date rankDate = new Date(cal.getTimeInMillis());


        List<Menu> menuList = menuRepository.findAll();
        menuList.forEach(menu -> {
            List<RankingData> rankingData = rankingRepository.findRankingData(menu.getMenuId()).stream().map(ranking ->
                    RankingData.builder().userId(ranking.getUserId()).userName(ranking.getUserName()).cnt(ranking.getCnt()).ranking(ranking.getRanking()).profileImg(ranking.getProfileImg()).build())
                    .collect(Collectors.toList());
            rankingRepository.save(Ranking.builder()
                    .data(new Gson().toJson(rankingData))
                    .menu(menu)
                    .rankDate(rankDate).build());

            rankingData.forEach(ranking -> {
                Collection collection = Collection.builder()
                        .user(userRepository.getReferenceById(ranking.getUserId()))
                        .menuName(menu.getMenuName())
                        .ranking(ranking.getRanking())
                        .rankDate(rankDate)
                        .build();
                collectionService.save(collection);
            });
        });
    }

    // 매달 1일 새벽 다섯시
//    @Scheduled(cron = "0 0 5 1 * * ")
//    @Scheduled(cron = "0 35 * * * *")
//    @Async
//    public void rankingScheduler() {
//
//        Calendar cal = Calendar.getInstance(); // 현재 시간
//        int year, month, day;
//        if(cal.get(Calendar.MONTH) == Calendar.JANUARY){
//            year = cal.get(Calendar.YEAR) - 1;
//            month = Calendar.DECEMBER;
//        }
//        else{
//            year = cal.get(Calendar.YEAR);
//            month = cal.get(Calendar.MONTH);
//        }
//        day = 1;
//        cal.set(year, month, day);
//        Date rankDate = new Date(cal.getTimeInMillis());
//
//        List<Menu> menuList = menuRepository.findAll();
//        menuList.forEach(menu -> {
//            List<RankingData> rankingData = rankingRepository.findRankingData(menu.getMenuId()).stream().map(ranking ->
//                            RankingData.builder().userId(ranking.getUserId()).userName(ranking.getUserName()).cnt(ranking.getCnt()).ranking(ranking.getRanking()).build())
//                    .collect(Collectors.toList());
//            rankingData.forEach(ranking -> rankingRepository.save(Ranking
//                    .builder()
//                    .user(userRepository.getReferenceById(ranking.getUserId()))
//                    .menu(menu)
//                    .cnt(ranking.getCnt())
//                    .no(ranking.getRanking())
//                    .rankDate(rankDate)
//                    .build()));
//
//            for (int i = 0; i < 3; i++) {
//                RankingData ranking = rankingData.get(i);
//                if (ranking.getCnt() == 0) break;
//                Collection collection = Collection.builder()
//                        .user(userRepository.getReferenceById(ranking.getUserId()))
//                        .menuName(menu.getMenuName())
//                        .ranking(ranking.getRanking())
//                        .rankDate(rankDate)
//                        .build();
//                collectionService.save(collection);
//            }
//            System.out.println(menu.getMenuName());
//        });
//    }

}
