package com.tw.utils;

import com.google.inject.AbstractModule;
import com.tw.repository.memoryCacheRepository.ScoreMemoryCacheRepository;
import com.tw.repository.memoryCacheRepository.StudentMemoryCacheRepository;
import com.tw.domain.transcripts.ScoreRepository;
import com.tw.domain.students.StudentRepository;

public class IocModule extends AbstractModule {
    @Override
    protected void configure(){
        bind(StudentRepository.class).to(StudentMemoryCacheRepository.class);
        bind(ScoreRepository.class).to(ScoreMemoryCacheRepository.class);
    }
}
