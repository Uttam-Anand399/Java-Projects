package com.ay.services;

import com.ay.entity.MultilingualSupport;

import java.util.List;

public interface MultilingualSupportService {
    MultilingualSupport addLanguageSupport(MultilingualSupport support);
    List<MultilingualSupport> getAllLanguages();
}
