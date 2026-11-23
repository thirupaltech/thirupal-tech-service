package com.thirupaltech.service.repository;

import com.thirupaltech.service.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FestivalRepository extends JpaRepository<Festival, UUID> {
}
