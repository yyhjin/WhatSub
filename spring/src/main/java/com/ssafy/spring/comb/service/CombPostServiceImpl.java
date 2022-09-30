package com.ssafy.spring.comb.service;

import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.dto.CombPostResponse;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.comb.repository.CombPostRepository;
import com.ssafy.spring.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CombPostServiceImpl implements CombPostService {

    private final CombPostRepository combPostRepository;

    @Autowired
    public CombPostServiceImpl(CombPostRepository combPostRepository){
        this.combPostRepository = combPostRepository;
    }

    @Override
    public CombinationPost save(Combination comb, User user, String imgurl, CombPostRequest request) {
        CombinationPost combPost = new CombinationPost();
        combPost.setCombName(request.getCombName());
        combPost.setContent(request.getContent());
        combPost.setImgUrl(imgurl);
        combPost.setCombination(comb);
        combPost.setUser(user);
        return combPostRepository.save(combPost);
    }

    @Override
    public CombinationPost findByCombinationPostId(int postId) {
        return combPostRepository.findByCombinationPostId(postId);
    }

    @Transactional
    @Override
    public int scoreUpdate(int postId, float scoreAvg) {
        CombinationPost post = combPostRepository.findByCombinationPostId(postId);
        post.scoreUpdate(scoreAvg);
        return postId;
    }

    public List<CombinationPost> findAllByMenuId (String menuId) {
        return combPostRepository.findAllByMenuId(menuId);
    }

    @Override
    public CombinationPost findByCombination_CombinationId(String combinationId) {
        return combPostRepository.findByCombination_CombinationId(combinationId);
    }

    @Override
    public CombinationPost findTopByOrderByLikesCntDescScoreAvgDesc() {
        return combPostRepository.findTopByOrderByLikesCntDescScoreAvgDesc();
    }

    @Override
    public List<CombinationPost> findAllByOrderByScoreAvgDesc() {
        return combPostRepository.findAllByOrderByScoreAvgDesc();
    }

    @Override
    public List<CombinationPost> findAllByOrderByCreatedAtDesc() {
        return combPostRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    @Override
    public int likescntUpdate(CombinationPost post, int likesCnt) {
        post.likescntUpdate(likesCnt);
        return post.getCombinationPostId();
    }

    @Override
    public List<CombinationPost> findAllByUser(User user) {
        return combPostRepository.findAllByUser(user);
    }

    @Override
    public List<CombinationPost> findTop30ByOrderByLikesCntDescScoreAvgDesc() {
        return combPostRepository.findTop30ByOrderByLikesCntDescScoreAvgDesc();
    }


}
