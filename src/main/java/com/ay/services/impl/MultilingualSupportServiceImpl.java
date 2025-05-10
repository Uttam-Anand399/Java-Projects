package com.ay.services.impl;

import com.ay.entity.MultilingualSupport;
import com.ay.repository.MultilingualSupportRepository;
import com.ay.services.MultilingualSupportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultilingualSupportServiceImpl implements MultilingualSupportService {

    private final MultilingualSupportRepository repository;

    public MultilingualSupportServiceImpl(MultilingualSupportRepository repository) {
        this.repository = repository;
    }

    @Override
    public MultilingualSupport addLanguageSupport(MultilingualSupport support) {
        return repository.save(support);
    }

    @Override
    public List<MultilingualSupport> getAllLanguages() {
        return repository.findAll();
    }
}
