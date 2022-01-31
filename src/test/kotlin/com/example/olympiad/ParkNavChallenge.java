package com.example.olympiad;

// {1, 120, 121} {11, 121, 121} {21, 122, 121} {31, 122, 121}
// {1, 120, 121} {2, 350, 350} {3, 120, 121.1} {4, 120, 121.1}
// Shuffled relative to the timestamp
//
public class ParkNavChallenge {


    // First logical step - separate the coordinates into buckets
    // How to do clustering
    // Human moves 5km/h -> 83m/m -> 1m/sec
    // Lat and long -> 111km/deg
    // Take into account errors of 10m
    // From this calculate potential change for latitude and longitude
    // Based of this do clustering
    // And each bucket corresponds to a physical person
    // Output all the points from a specific bucket in chronological order
    // This gives you a set of paths
    public static void main(String[] args) {

    }
}
