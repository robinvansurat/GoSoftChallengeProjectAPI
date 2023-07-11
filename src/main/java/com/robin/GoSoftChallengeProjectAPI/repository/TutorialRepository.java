package com.robin.GoSoftChallengeProjectAPI.repository;

public interface TutorialRepository {
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);
}
