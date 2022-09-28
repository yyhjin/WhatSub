package com.ssafy.spring.comb.service;

import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.comb.repository.CombPostRepository;
import com.ssafy.spring.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CombPostServiceImpl implements CombPostService {

    private final CombPostRepository combPostRepository;

    @Autowired
    public CombPostServiceImpl(CombPostRepository combPostRepository){
        this.combPostRepository = combPostRepository;
    }

    public CombinationPost save(Combination comb, User user, String imgurl, CombPostRequest request) {
        CombinationPost combPost = new CombinationPost();
        combPost.setCombName(request.getCombName());
        combPost.setContent(request.getContent());
        combPost.setImgUrl(imgurl);
        combPost.setCombination(comb);
        combPost.setUser(user);
        return combPostRepository.save(combPost);
    }

    public CombinationPost findByCombinationPostId(int postId) {
        return combPostRepository.findByCombinationPostId(postId);
    }

}
