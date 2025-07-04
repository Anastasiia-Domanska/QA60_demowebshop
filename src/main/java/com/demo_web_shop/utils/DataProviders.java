package com.demo_web_shop.utils;

import com.demo_web_shop.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    static int i = (int)((System.currentTimeMillis()/ 1000)%3600);

    @DataProvider
    public Iterator<Object[]> createNewAccount() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Olya", "Ol", "123"+i+"@gmail.com", "Aa12345!", "Aa12345!"});
        list.add(new Object[]{"Yulya", "Yu", "234"+i+"@gmail.com", "Aa123456!@", "Aa123456!@"});
        list.add(new Object[]{"Mary", "Ma", "345"+i+"@gmail.com", "Aa12345!#$", "Aa12345!#$"});
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> createNewUserWithScv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/new_user.csv")));

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new User()
                    .setFirstName(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])
                    .setConfirmPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
