package com.ay.services;

import com.ay.entity.HelplineSupport;

import java.util.List;

public interface HelplineSupportService {
    HelplineSupport addQuery(HelplineSupport query);
    List<HelplineSupport> getAllQueries();
    HelplineSupport updateStatus(Long id, String status);
    void deleteQuery(Long id);
}
