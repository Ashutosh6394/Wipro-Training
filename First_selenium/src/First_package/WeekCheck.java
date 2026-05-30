package First_package;

class WeekCheck {

    public static void main(String[] args) {

        String day = "monday";

        if (day == "monday" || day == "tuesday" || day == "wednesday"
                || day == "thursday" || day == "friday") {

            System.out.println("Weekday");

        } else if (day == "saturday" || day == "sunday") {

            System.out.println("Weekend");

        } else {

            System.out.println("Invalid day");
        }
    }
}
