package utils;

import org.testng.annotations.DataProvider;
import java.io.*;
import java.util.*;

public class DataProviders {

    //Login Data Provider
    @DataProvider(name = "Login", parallel = false)
    public static Iterator<Object[]> getLoginData() throws IOException {
        String filePath = "src/main/resources/Testdata/Login.csv";
        List<Object[]> testData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // skip header line
                }

                String[] data = line.trim().split("\\s*,\\s*");

                if (data.length < 2) {
                    System.out.println("Skipping invalid or incomplete login row: " + line);
                    continue;
                }

                testData.add(new Object[]{data[0], data[1] });
            }
        }

        return testData.iterator();
    }

    // Signup Data Provider
    @DataProvider(name = "Signup")
    public static Iterator<Object[]> getSignupData() throws IOException {
        String filePath = "src/main/resources/Testdata/Signup.csv";
        List<Object[]> testData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // skip header line
                }

                String[] data = line.trim().split("\\s*,\\s*");

                if (data.length < 27) {
                    System.out.println("Skipping invalid or incomplete line: " + line);
                    continue;
                }

                testData.add(new Object[]{
                        data[0], data[1], data[2], data[3], data[4], data[5],
                        data[6], data[7], data[8], data[9], data[10], data[11],
                        data[12], data[13], data[14], data[15], data[16], data[17],
                        data[18], data[19], data[20], data[21], data[22], data[23],
                        data[24], data[25], data[26]
                });
            }
        }

        return testData.iterator();
    }

    // Bank Transfer Data Provider
    @DataProvider(name = "BankTransfer")
    public static Iterator<Object[]> getBankTransferData() throws IOException {
        String filePath = "src/main/resources/Testdata/BankTransfer.csv";
        List<Object[]> testData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.trim().split("\\s*,\\s*");
                if (data.length < 3) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                // Add both YouSend and TheyReceive
                testData.add(new Object[]{ data[0], data[1], data[2] });
            }
        }
        return testData.iterator();
    }

    // FX Booking Data Provider
    @DataProvider(name = "FxBookingTap")
    public static Iterator<Object[]> getFxBookingData() throws IOException {
        String filePath = "src/main/resources/Testdata/FxBooking.csv";
        List<Object[]> testData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.trim().split("\\s*,\\s*");
                if (data.length < 1) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                testData.add(new Object[]{ data[0] });
            }
        }
        return testData.iterator();
    }
}
