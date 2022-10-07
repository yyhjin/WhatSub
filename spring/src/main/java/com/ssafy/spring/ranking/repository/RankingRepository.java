package com.ssafy.spring.ranking.repository;

import com.ssafy.spring.ranking.dto.RankingDataDto;
import com.ssafy.spring.ranking.dto.RankingDto;
import com.ssafy.spring.ranking.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking, Integer> {
    @Query(value = "select new com.ssafy.spring.ranking.dto.RankingDto(ranking.rankingId, menu.menuId, menu.menuName, menu.menuDesc, menu.imgUrl, ranking.rankDate, ranking.data) " +
            "from Ranking ranking " +
            "right outer join ranking.menu menu " +
            "where ranking.rankDate>=:rankDate")
    List<RankingDto> findByRankDate(@Param("rankDate") Date rankDate);
//
    @Query(value = "select u.user_id userId, u.user_name userName, u.profile_img profileImg, cnt, o.ranking ranking " +
            "from (" +
            "select oh.user_id, sum(oh.count) cnt, rank() over(order by sum(count) desc) ranking " +
            "from order_history oh " +
            "join orders s on s.order_id=oh.order_id " +
            "where oh.menu_id=?1 between date_add(now(), interval -1 month) and now() " +
            "group by oh.user_id " +
            ") o " +
            "right outer join user u on u.user_id=o.user_id " +
            "where o.ranking <= 3 and o.cnt != 0 " +
            "order by o.cnt desc, u.user_id asc", nativeQuery = true)
    List<RankingDataDto> findRankingData(String menuId);

}
