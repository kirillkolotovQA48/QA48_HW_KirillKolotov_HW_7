package com.qa48.hw7.utils;

import com.qa48.hw7.models.HW_7_RegistForm;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> RegistrationFormWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/RegistrForm.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                list.add(new Object[]{new HW_7_RegistForm()
                        .setFirstName(split[0])
                        .setLastName(split[1])
                        .setEmail(split[2])
                        .setPassword(split[3])
                        .setConfirmPassword(split[4])});
            }
        }

        return list.iterator();
    }
}
