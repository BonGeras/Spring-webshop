package com.example.springwebstore.Repository;

import com.example.springwebstore.Data.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
}
