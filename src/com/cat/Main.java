package com.cat;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Homework_number_4");
        Scanner w = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Task_1");
        int countOfArrayElements;
        System.out.println("Enter quantity of array elements");
        countOfArrayElements = w.nextInt();
        System.out.println("Quantity of array elements is " + countOfArrayElements);
        int[] array = new int[countOfArrayElements];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100);
        }
        System.out.println("Your array is " + Arrays.toString(array));
        int start = 0;
        int end = array.length - 1;
        quickSort(array, start, end);
        System.out.println("Sorted array is " + Arrays.toString(array));
        int number;
        System.out.println("Enter number for finding in the array");
        number = w.nextInt();
        binarySearch(array, number);
        System.out.println("Task_2");
        int firstRobotLinePosition;
        int firstRobotColumnPosition;
        System.out.println("Enter first robot start line position");
        firstRobotLinePosition = w.nextInt();
        System.out.println("Enter first robot start column position");
        firstRobotColumnPosition = w.nextInt();
        String robotAction;
        System.out.println("Enter robot action: R is go right, L is go left, U is go up, D is go down");
        robotAction = s.nextLine();
        robot(firstRobotLinePosition, firstRobotColumnPosition, robotAction);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (array.length == 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int middleElement = start + (end - start) / 2;
        int mainElement = array[middleElement];
        int i = start;
        int j = end;
        int arrayElement;
        while (i <= j) {
            while (array[i] < mainElement) {
                i++;
            }
            while (array[j] > mainElement) {
                j--;
            }
            if (i <= j) {
                arrayElement = array[i];
                array[i] = array[j];
                array[j] = arrayElement;
                i++;
                j--;
            }
        }
        if (start < j) {
            quickSort(array, start, j);
        }
        if (end > i) {
            quickSort(array, i, end);
        }
    }

    public static void binarySearch(int[] array, int number) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middleElement = (start + end) / 2;
            if (number > array[middleElement]) {
                start = middleElement + 1;
            } else if (number < array[middleElement]) {
                end = middleElement - 1;
            } else {
                System.out.println("Index of " + array[middleElement] + " element is " + middleElement);
                return;
            }
        }
        System.out.println("Array does not include number " + number);
    }

    public static void robot(int startLine, int startColumn, String string) {
        char[] robotChar = string.toCharArray();
        int finalLineRobotPosition = 0;
        int finalColumnRobotPosition = 0;
        for (int i = 0; i < robotChar.length; i++) {
            if (robotChar[i] == 'U') {
                finalLineRobotPosition++;
            }
            if (robotChar[i] == 'D') {
                finalLineRobotPosition--;
            }
            if (robotChar[i] == 'L') {
                finalColumnRobotPosition--;
            }
            if (robotChar[i] == 'R') {
                finalColumnRobotPosition++;
            }
        }
        if (startLine == finalLineRobotPosition && startColumn == finalColumnRobotPosition) {
            System.out.println("Robot has returned in it`s first position");
        } else {
            System.out.println("Robot has not returned in it`s first position");
        }
    }
}
