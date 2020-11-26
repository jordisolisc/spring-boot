package com.njesoft.scheduler;

import com.njesoft.services.AddressService;
import com.njesoft.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class JobScheduler {

    private static Logger logger = Logger.getLogger(JobScheduler.class);

    private UserService userService;
    private AddressService addressService;

    @Autowired
    public JobScheduler(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

//    @Scheduled(cron = "*/5 * * * * *")
    public void schedulerUsingCronExpression(){
        logger.info(userService.userList());
    }

//    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void schedulerUsingFixedDelayWithInitialDelay(){
        logger.info(userService.findById(4));
    }

//    @Scheduled(fixedDelay = 1000)
    public void schedulerUsingDelay(){
        logger.info(addressService.addressList());
    }

//    @Scheduled(fixedRate = 5000)
    public void schedulerUsingRate(){
        logger.info(addressService.findById(5));

    }
}
