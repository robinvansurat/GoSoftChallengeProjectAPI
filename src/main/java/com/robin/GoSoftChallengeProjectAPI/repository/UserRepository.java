package com.robin.GoSoftChallengeProjectAPI.repository;

import com.robin.GoSoftChallengeProjectAPI.model.Tutorial;
import com.robin.GoSoftChallengeProjectAPI.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
}