package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Convertor {
    private static final String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String numberInSomeBase;
    private int sourceBase;
    private int targetBase;

    public void convertFromDecimals() {
        final List<Character> list = new ArrayList<>();
        String[] partsOfNumber = numberInSomeBase.split("\\.");
        BigInteger integerValueOfNumber = new BigInteger(partsOfNumber[0]);
        int result;
        int sizeOfList;

        while (integerValueOfNumber.compareTo(BigInteger.ZERO) > 0) {
            result = integerValueOfNumber.remainder(BigInteger.valueOf(targetBase)).intValue();
            list.add(DIGITS.charAt(result));
            integerValueOfNumber = integerValueOfNumber.divide(BigInteger.valueOf(targetBase));
        }
        sizeOfList = list.size();
        if (sizeOfList == 0) {
            list.add('0');
        }
        if (partsOfNumber.length == 1) {
            for (int i = sizeOfList - 1; i >= 0; i--) {
                System.out.print(list.get(i));
            }
            System.out.println();
        } else {
            list.add('.');
            BigDecimal fractionalValueOfNumber = new BigDecimal(String.valueOf(new BigDecimal(numberInSomeBase)
                    .subtract(new BigDecimal(partsOfNumber[0]))));
            int counter = 0;
            while (counter != 5) {
                fractionalValueOfNumber = fractionalValueOfNumber.multiply(BigDecimal.valueOf(targetBase));
                result = fractionalValueOfNumber.setScale(0, RoundingMode.DOWN).intValue();
                if (fractionalValueOfNumber.compareTo(BigDecimal.ONE) > 0) {
                    fractionalValueOfNumber = fractionalValueOfNumber.subtract(BigDecimal.valueOf(result));
                }
                list.add(DIGITS.charAt(result));
                counter++;
            }
            for (int i = sizeOfList - 1; i >= 0; i--) {
                System.out.print(list.get(i));
            }
            int newSizeOfList = list.size();
            for (int i = sizeOfList; i < newSizeOfList; i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }

    public String convertToDecimals() {
        int placeOfDot = numberInSomeBase.indexOf(".");
        char[] array;
        int degree;
        if (placeOfDot == -1) {
            array = numberInSomeBase.toCharArray();
            degree = array.length;
        } else {
            StringBuilder numberWithoutDot = new StringBuilder(numberInSomeBase);
            numberInSomeBase = numberWithoutDot.deleteCharAt(placeOfDot).toString();
            array = numberInSomeBase.toCharArray();
            degree = placeOfDot;
        }
        BigDecimal sum = BigDecimal.ZERO;
        for (char c : array) {
            sum = sum.add(BigDecimal.valueOf(DIGITS.indexOf(c)).multiply(BigDecimal.valueOf(Math.pow(sourceBase, degree - 1))));
            degree--;
        }
        if (degree == 0)
            sum = sum.setScale(0, RoundingMode.DOWN);
        return String.valueOf(sum);
    }

    public void chooseConversionMethod() {
        if (sourceBase == targetBase) {
            System.out.println(numberInSomeBase);
        } else if (sourceBase != 10 && targetBase != 10) {
            numberInSomeBase = convertToDecimals();
            convertFromDecimals();
        } else if (sourceBase == 10) {
            convertFromDecimals();
        } else {
            System.out.println(convertToDecimals());
        }
    }
    public void chooseBase() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter two numbers in range (2-36) format: {source base} {target base} (To quit type /exit) > ");
            String enteredSourceBase = scanner.next();
            if (enteredSourceBase.equals("/exit")) {
                break;
            }
            String enteredTargetBase = scanner.next();
            scanner.nextLine();
            try {
                sourceBase = Integer.parseInt(enteredSourceBase);
                targetBase = Integer.parseInt(enteredTargetBase);
                if ((sourceBase < 2 || sourceBase > 36) || (targetBase < 2 || targetBase > 36))
                    throw new NumberFormatException();
                while (true) {
                    System.out.printf("Enter number in base %d to convert to base %d (To go back type /back) > ", sourceBase, targetBase);
                    numberInSomeBase = scanner.next();
                    if (numberInSomeBase.equals("/back"))
                        break;
                    System.out.print("Conversion to decimal result: ");
                    chooseConversionMethod();
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter 2 numbers in range (2-36)!");
            }
        }
    }
}
