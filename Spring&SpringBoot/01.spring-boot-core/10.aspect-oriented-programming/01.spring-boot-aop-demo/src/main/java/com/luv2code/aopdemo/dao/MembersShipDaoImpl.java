package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembersShipDaoImpl implements MembersShipDao{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing My DB WORK: ADDING AN ACCOUNT");
    }
}
