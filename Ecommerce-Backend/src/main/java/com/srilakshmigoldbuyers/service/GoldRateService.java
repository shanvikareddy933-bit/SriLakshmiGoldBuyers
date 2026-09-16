package com.srilakshmigoldbuyers.service;


import org.springframework.stereotype.Service;

@Service
public class GoldRateService {

    // Gold prices per gram
    private double price24K = 0.0;
    private double price22K = 0.0;
    private double price18K = 0.0;

    // Get 24K gold price
    public double getPrice24K() {
        return price24K;
    }

    // Set 24K gold price
    public void setPrice24K(double price24K) {
        this.price24K = price24K;
    }

    // Get 22K gold price
    public double getPrice22K() {
        return price22K;
    }

    // Set 22K gold price
    public void setPrice22K(double price22K) {
        this.price22K = price22K;
    }

    // Get 18K gold price
    public double getPrice18K() {
        return price18K;
    }

    // Set 18K gold price
    public void setPrice18K(double price18K) {
        this.price18K = price18K;
    }

    // Calculate gold value
    public double calculateGoldValue(
            String goldType,
            double weight) {

        double price;

        switch (goldType.toUpperCase()) {

            case "24K":
                price = price24K;
                break;

            case "22K":
                price = price22K;
                break;

            case "18K":
                price = price18K;
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid gold type: " + goldType
                );
        }

        return price * weight;
    }
}

