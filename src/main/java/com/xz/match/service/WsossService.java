package com.xz.match.service;


import com.xz.match.utils.ResponseResult;

public interface WsossService {

    ResponseResult uploadImage(final byte[] imageContent, String imageName, String imageBucket, String fileKeyWithFolder);

    ResponseResult upload(final byte[] imageContent, String imageName, String imageBucket, String imageType, String fileKeyWithFolder);
}
