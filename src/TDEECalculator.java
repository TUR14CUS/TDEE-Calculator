import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Whats your name? \n");
        String name = scanner.nextLine();

        System.out.printf("Hello %s, what's your age? \n", name);
        int age = scanner.nextInt();

        clearTerminal();

        System.out.println("What's your height? \n");
        int height = scanner.nextInt();

        clearTerminal();

        System.out.println("What's your weight? \n");
        double weight = scanner.nextDouble();

        clearTerminal();

        scanner.nextLine();

        String sex;
        do {
            System.out.println("What's your sex? (male/female) \n");
            sex = scanner.nextLine();
            if (!sex.equals("male") && !sex.equals("female")) {
                System.out.println("Invalid input. Please enter 'male' or 'female'.");
            }
        } while (!sex.equals("male") && !sex.equals("female"));


        double tmb;
        if (sex.equals("male")) {
            tmb = calculateTMBForMale(weight, height, age);
        } else {
            tmb = calculateTMBForFemale(weight, height, age);
        }

        System.out.println("What is your activity level per week? (sedentary, lightly active, moderately active, very active, super active) \n");
        String activityLevel = scanner.nextLine();

        double calories = calculateCalories(tmb, activityLevel);

        System.out.printf("Your total daily caloric intake should be %.2f calories", calories);

        scanner.close();
    }

    public static double calculateTMBForMale(double weight, int height, int age) {
        return 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
    }

    public static double calculateTMBForFemale(double weight, int height, int age) {
        return 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
    }

    public static double calculateCalories(double tmb, String activityLevel) {
        double activityFactor;
        switch (activityLevel) {
            case "sedentary":
                activityFactor = 1.2;
                break;
            case "lightly active":
                activityFactor = 1.375;
                break;
            case "moderately active":
                activityFactor = 1.55;
                break;
            case "very active":
                activityFactor = 1.725;
                break;
            case "super active":
                activityFactor = 1.9;
                break;
            default:
                activityFactor = 1.2;
                break;
        }
        return tmb * activityFactor;
    }

    public static void clearTerminal() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String dietType(){
        System.out.println("What's your main objective? (Lose Weight, Gain Weight, Maintein Weight) \n");
        String objective = scanner.nextLine();


    }
}