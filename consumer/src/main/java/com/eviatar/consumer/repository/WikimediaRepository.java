package com.eviatar.consumer.repository;

import com.eviatar.consumer.model.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaData, Long> {


}
