package Wipro_assingment;

abstract class Hospital1 {

    void patient() {
        System.out.println("Handling patient details");
    }

    void document() {
        System.out.println("Managing hospital documents");
    }

    abstract void ot();
    abstract void payments();
}

class Doctor extends Hospital1{

    void ot() {
        System.out.println("Doctor performs surgery");
    }

    void payments() {
        System.out.println("Doctor verifies payments");
    }
}

class Nurse extends Hospital1 {

    void ot() {
        System.out.println("Nurse assists in OT");
    }

    void payments() {
        System.out.println("Nurse helps in payment process");
    }
}

public class Hospital {

    public static void main(String[] args) {

        Doctor d = new Doctor();
        Nurse n = new Nurse();

        d.patient();
        d.document();

        System.out.println();

        n.patient();
        n.document();

        System.out.println();

        d.ot();
        d.payments();

        System.out.println();

        n.ot();
        n.payments();
    }
}