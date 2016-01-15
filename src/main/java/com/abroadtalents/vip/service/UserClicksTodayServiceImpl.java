package com.abroadtalents.vip.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abroadtalents.vip.domain.UserClicksToday;
import com.abroadtalents.vip.repository.UserClicksTodayRepository;

@Service
public class UserClicksTodayServiceImpl implements UserClicksTodayService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserClicksTodayServiceImpl.class);
    private final UserClicksTodayRepository userClicksTodayRepository;
    
    @Inject
    public UserClicksTodayServiceImpl(final UserClicksTodayRepository userClicksTodayRepository) {
        this.userClicksTodayRepository = userClicksTodayRepository;
    }
    
    @Override
    @Transactional
    public void updataUserClicks(String username) {
    	UserClicksToday existing =  userClicksTodayRepository.findOne(username);
    	if (existing == null) {
    		// create the entry
    		UserClicksToday entry = new UserClicksToday(username, 1);
    		userClicksTodayRepository.save(entry);
    	} else {
    		userClicksTodayRepository.updateClicks(username);
    		LOGGER.debug("Updating {}", existing);
    	}
    }
    
    @Override
    @Transactional
    public int getUserClicks(String username) {
    	UserClicksToday existing =  userClicksTodayRepository.findOne(username);
    	if (existing == null) {
    		// new user who hasn't clicked any thing today
    		return 0;
    	} else {
    		LOGGER.debug("Get {}", existing);
    		return existing.getClicks();
    	}
    }

}
