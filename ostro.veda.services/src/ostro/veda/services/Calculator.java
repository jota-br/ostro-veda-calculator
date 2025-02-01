package ostro.veda.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static String getResult(String input) {
        String result = getParentheses(input);
        result = getPrecedence(result);
        return result;
    }

    private static String getParentheses(String input) {
        String parenthesesRegex = "\\((.+?)\\)";

        StringBuilder resultInput = new StringBuilder(input);

        Pattern parentheses = Pattern.compile(parenthesesRegex);
        Matcher matcher = parentheses.matcher(input);

        while (matcher.find()) {

            String expression = matcher.group(1);
            String result = getPrecedence(expression);

            int start = resultInput.indexOf(expression);
            int end = expression.length() + start;
            resultInput.replace(start, end, result);
        }

        if (resultInput.toString().contains("(")) {
            resultInput = new StringBuilder(resultInput.toString().replaceAll("\\(", ""));
        }

        if (resultInput.toString().contains(")")) {
            resultInput = new StringBuilder(resultInput.toString().replaceAll("\\)", ""));
        }
        return resultInput.toString();
    }

    private static String getPrecedence(String input) {
        List<String> precedenceList = new ArrayList<>(List.of(
                "(\\d+(\\.\\d+)?\\s*[*]\\s*\\d+(\\.\\d+)?)", // multiplication
                "(\\d+(\\.\\d+)?\\s*/\\s*\\d+(\\.\\d+)?)", // division
                "(\\d+(\\.\\d+)?\\s*[+]\\s*\\d+(\\.\\d+)?)", // sum
                "(\\d+(\\.\\d+)?\\s*[-]\\s*\\d+(\\.\\d+)?)" // subtraction
        ));

        List<String> operatorList = new ArrayList<>(List.of(
                "\\*", "/", "\\+", "\\-"
        ));

        String cleanInput = input;

        while (cleanInput.contains("*") || cleanInput.contains("/")) {
            String regexToUse = null;
            String operatorToUse = null;
            boolean hasElementMultiplication = cleanInput.contains("*");
            boolean hasElementDivision = cleanInput.contains("/");
            boolean multiplicationIndexIsLower = cleanInput.indexOf("*") < cleanInput.indexOf("/") && hasElementMultiplication;
            if (multiplicationIndexIsLower || (!hasElementDivision && hasElementMultiplication)) {
                regexToUse = precedenceList.getFirst();
                operatorToUse = operatorList.getFirst();
            } else {
                if (cleanInput.contains("/")) {
                    regexToUse = precedenceList.get(1);
                    operatorToUse = operatorList.get(1);
                }
            }

            if (regexToUse != null) {
                Pattern pattern = Pattern.compile(regexToUse);
                Matcher matcher = pattern.matcher(cleanInput);

                while (matcher.find()) {
                    String expression = matcher.group(1);
                    double result = getCalculation(expression, operatorToUse);
                    cleanInput = cleanInput.replaceFirst(regexToUse, "" + result);
                    matcher = pattern.matcher(cleanInput);
                }
            }
        }

        int operator = 2;
        for (String regex : precedenceList.subList(2, 4)) {

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cleanInput);

            while (matcher.find()) {
                String expression = matcher.group(1);
                double result = getCalculation(expression, operatorList.get(operator));
                cleanInput = cleanInput.replaceFirst(regex, "" + result);
                matcher = pattern.matcher(cleanInput);
            }
            operator++;
        }
        return cleanInput;
    }

    private static double getCalculation(String input, String precedence) {

        input = input.replaceAll(" ", "");
        List<Double> numbers = Arrays.stream(input.split(precedence))
                .filter(s -> !s.isEmpty())
                .filter(s -> !s.contains(precedence))
                .map(String::trim)
                .map(Double::parseDouble).toList();

        if (input.contains("*")) {
            return numbers.get(0) * numbers.get(1);
        } else if (input.contains("/")) {
            return numbers.get(0) / numbers.get(1);
        } else if (input.contains("-")) {
            return numbers.get(0) - numbers.get(1);
        } else if (input.contains("+")) {
            return numbers.get(0) + numbers.get(1);
        }

        return 0.0;
    }
}
