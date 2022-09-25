package com.example.springwebstore.Service;

import com.example.springwebstore.DTO.BucketDTO;
import com.example.springwebstore.Data.Bucket;
import com.example.springwebstore.Data.User;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);

    void remoteProducts(Bucket bucket, List<Long> productIds);

    BucketDTO getBucketByUser(String name);
}
