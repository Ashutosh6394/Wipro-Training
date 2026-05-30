package Wipro_assingment;


class Hospital {

    void hospitalName() {
        System.out.println("City Hospital");
    }
}

class Doctor extends Hospital {

    void doctorName() {
        System.out.println("Dr. Sharma");
    }
}

public class Oops {

    public static void main(String[] args) {

        Doctor obj = new Doctor();

        obj.hospitalName();
        obj.doctorName();
    }
}