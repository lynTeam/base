package com.xingkong.lyn.repository.anjian;

import com.xingkong.lyn.entity.anjian.MultipleChoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MultipleChoiceRepository extends JpaRepository<MultipleChoice, Long> {
    List<MultipleChoice> findAllByUpdateTimeAfter(Date updateTime);
    Page<MultipleChoice> findByUidLike(String uid, Pageable pageable);
}
