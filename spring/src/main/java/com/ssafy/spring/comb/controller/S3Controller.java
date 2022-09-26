package com.ssafy.spring.comb.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.comb.service.S3Service;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/s3")
public class S3Controller {

    private final S3Service s3Service;

    /**
     * Amazon S3에 파일 업로드
     *
     * @return 성공 시 200 Success와 함께 업로드 된 파일의 파일명 리스트 반환
     */
    @ApiOperation(value = "Amazon S3에 파일 업로드", notes = "Amazon S3에 파일 업로드 ")
    @PostMapping("/file")
    public List<String> uploadFile(@ApiParam(value="파일들(여러 파일 업로드 가능)", required = true) @RequestPart List<MultipartFile> multipartFile) {
        return s3Service.uploadFile(multipartFile);
    }

    /**
     * Amazon S3에 업로드 된 파일을 삭제
     *
     * @return 성공 시 200 Success
     */
    @ApiOperation(value = "Amazon S3에 업로드 된 파일을 삭제", notes = "Amazon S3에 업로드된 파일 삭제")
    @DeleteMapping("/file")
    public String deleteFile(@ApiParam(value="파일 하나 삭제", required = true) @RequestParam String fileUrl) {
        String fileName = s3Service.deleteFile(fileUrl);
        return fileName;
    }
}