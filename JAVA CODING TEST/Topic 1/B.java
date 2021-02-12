public class B implements A {

    @Override
    public Number add(int num1, int num2) {
        return num1 + num2;
    }

    public Number subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public Number subtract(int num1, int num2) {
        return num1 - num2;
    }
}
