import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;
        List<String> list = new ArrayList();
        boolean flag = true;
        String[] menu = {
                "add",
                "show",
                "delete",
                "search",
                "end"
        };

        while (flag) {

            System.out.println();
            System.out.println("""
                    1. add\s
                    2. show\s
                    3. delete\s
                    4. search\s
                    5. end\s
                    Select an operation: """);
            line = scanner.nextLine();
            if (isNumeric(line)) {
                int n = Integer.parseInt(line);
                line = menu[n - 1];
            }

            switch (line) {
                case "add" -> {
                    System.out.println("What purchase do you want to add?");
                    line = scanner.nextLine();
                    list.add(line);
                    System.out.println("Total in the shopping list: " + list.size());
                }
                case "show" -> {
                    System.out.println("Shopping list:");
                    showList(list);
                }
                case "delete" -> {
                    System.out.println("Which one do you want to delete? Enter the number or name");
                    line = scanner.nextLine();
                    if (isNumeric(line)) {
                        int n = Integer.parseInt(line);
                        String string = list.get(n - 1);
                        list.remove(string);
                        System.out.println("Purchase " + '"' + string + '"' + " deleted, shopping list:");
                    } else {
                        list.remove(line);
                        System.out.println("Purchase " + '"' + line + '"' + " deleted, shopping list:");
                    }
                    showList(list);
                }
                case "search" -> {
                    System.out.println("Enter the search text:");
                    String string;
                    line = scanner.nextLine();
                    for (int i = 0; i< list.size(); i++) {
                        string = list.get(i);
                        string = string.toLowerCase();
                        if (string.contains(line.toLowerCase())){
                            System.out.println((i + 1) + ". " + list.get(i));
                        }
                    }
                }
                case "end" -> flag = false;
                default -> {}
            }
        }
    }

    public static void showList(List<String> lis) {
        for (int i = 0; i < lis.size(); i++) {
            System.out.println(i + 1 + ". " + lis.get(i));
        }
    }

    public static boolean isNumeric(String string) {
        int intValue;

        if (string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            //System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
}

