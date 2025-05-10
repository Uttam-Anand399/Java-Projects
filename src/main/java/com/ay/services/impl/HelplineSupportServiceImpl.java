package com.ay.services.impl;

import com.ay.entity.HelplineSupport;
import com.ay.repository.HelplineSupportRepo;
import com.ay.services.HelplineSupportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelplineSupportServiceImpl implements HelplineSupportService {

    private final HelplineSupportRepo helplineRepo;

    public HelplineSupportServiceImpl(HelplineSupportRepo helplineRepo) {
        this.helplineRepo = helplineRepo;
    }

    @Override
    public HelplineSupport addQuery(HelplineSupport query) {
        return helplineRepo.save(query);
    }

    @Override
    public List<HelplineSupport> getAllQueries() {
        return helplineRepo.findAll();
    }

    @Override
    public HelplineSupport updateStatus(Long id, String status) {
        HelplineSupport query = helplineRepo.findById(id).orElseThrow();
        query.setStatus(status);
        return helplineRepo.save(query);
    }

    @Override
    public void deleteQuery(Long id) {
        helplineRepo.deleteById(id);
    }
}
