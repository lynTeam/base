package com.xingkong.lyn.repository.anjian;

import com.xingkong.lyn.entity.anjian.SimpleChoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SimpleChoiceRepository extends JpaRepository<SimpleChoice, Long> {
    List<SimpleChoice> findAllByUpdateTimeAfter(Date updateTime);
    Page<SimpleChoice> findByUidLike(String uid, Pageable pageable);
}
