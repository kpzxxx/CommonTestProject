package com.kpztech.practice.dp.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IUserManagerImpl implements IUserManager {
    @Override
    public void addUser(String id, String password) {
        log.info("Invoke addUser method.");
    }
}
