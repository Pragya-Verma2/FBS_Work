class Distance {
    int km;
    int m;

    void setKm(int k) {
        this.km = k;
    }

    void setM(int m) {
        this.m = m;
    }
} // Distance class ends here


class TestDistance {
    public static void main(String[] args) {
        Distance d1;
        d1 = new Distance();
        d1.setKm(5);
        d1.setM(350);

        System.out.println("Distance in kilometers: " + d1.km);
        System.out.println("Distance in meters: " + d1.m);
    } // main ends
}
