package com.ssafy.spring.ranking.service;

import com.ssafy.spring.ranking.dto.RankingDto;
import com.ssafy.spring.ranking.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    @Override
    public List<RankingDto> getMonthlyRanking() {

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
        cal.set(year, month, day, 0, 0, 0);
        Date rankDate = new Date(cal.getTimeInMillis());
        return rankingRepository.findByRankDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(rankDate), new ParsePosition(0)));
    }
}
