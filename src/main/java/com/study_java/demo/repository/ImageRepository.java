package com.study_java.demo.repository;

import com.study_java.demo.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Long> {

    List<Image> findByProductId(Long id);
}
