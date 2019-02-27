
/*
     * Author Simon Remington
     * Date 24/02/2019
     *
     * The tester is first part testing the Rate constructor
     * The method calculate is in lower part
     * Final part of this file contains the Rate Class that
     * I have tested against
     */
    import org.hamcrest.CoreMatchers;
    import org.junit.Test;
    import static org.hamcrest.CoreMatchers.is;
    import static org.junit.Assert.assertThat;

    import java.math.BigDecimal;
    import java.util.ArrayList;

    public class RateTest {
        private CarParkKind carParkKind;
        private BigDecimal hourlyNormalRate;
        private BigDecimal hourlyReducedRate;
        private ArrayList<Period> reducedPeriodsTime = new ArrayList<>();
        private ArrayList<Period> normalPeriodsTime = new ArrayList<>();

        private Period stayTest;

        /**********************************************
         *
         *Testing the constructor
         *
         *
         */

        @Test(expected = IllegalArgumentException.class)
        public void rate0() throws IllegalArgumentException {
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(9, 17));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(-1);
            hourlyReducedRate = BigDecimal.valueOf(-1);
            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate1() throws IllegalArgumentException {
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(9, 17));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(-1);
            hourlyReducedRate = BigDecimal.valueOf(0);
            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate2() throws IllegalArgumentException {
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(9, 17));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(-1);
            hourlyReducedRate = BigDecimal.valueOf(1);
            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate3() throws IllegalArgumentException {
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(9, 17));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(0);
            hourlyReducedRate = BigDecimal.valueOf(-1);
            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate4() throws IllegalArgumentException {
            System.out.println("test r4 period 23, 1");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(9, 17));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = BigDecimal.valueOf(-1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate5() throws IllegalArgumentException {
            System.out.println("test r5 rate 0,1");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(9, 17));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(0);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate6() throws IllegalArgumentException {
            System.out.println("r6 period overlap 12, 13");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(9, 17));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = BigDecimal.valueOf(2);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate7() throws IllegalArgumentException {
            System.out.println("r7 period 9,8");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(9, 8));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate8() throws IllegalArgumentException {
            System.out.println("r8 period overlap 17, 16");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(8, 9));
            normalPeriodsTime.add(new Period(17, 16));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate9() throws IllegalArgumentException {
            System.out.println("r9 period overlap 17,17");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(9, 18));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate10() throws IllegalArgumentException {
            System.out.println("r9 period overlap ");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(9, 16));
            reducedPeriodsTime.add(new Period(15, 17));
            normalPeriodsTime.add(new Period(17, 18));
            normalPeriodsTime.add(new Period(18, 19));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }

        @Test(expected = IllegalArgumentException.class)
        public void rate11() throws IllegalArgumentException {
            System.out.println("r9 period overlap 10, 8 ");
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(9, 16));
            reducedPeriodsTime.add(new Period(16, 17));
            normalPeriodsTime.add(new Period(17, 18));
            normalPeriodsTime.add(new Period(17, 19));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate12() throws IllegalArgumentException {
            System.out.println("r9 period overlap 10, 8 ");
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(9, 16));
            reducedPeriodsTime.add(new Period(16, 17));
            normalPeriodsTime.add(new Period(16, 18));
            normalPeriodsTime.add(new Period(18, 19));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate13() throws IllegalArgumentException {
            System.out.println("r9 period ");
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(9, 16));
            reducedPeriodsTime.add(new Period(16, 17));
            normalPeriodsTime.add(new Period(17, 18));
            normalPeriodsTime.add(new Period(18, 25));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        //@Test
        public void rate14() throws IllegalArgumentException {
            System.out.println("r9 period  ");
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(-1, 16));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate15() throws IllegalArgumentException {
            System.out.println("r9 period  ");
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(1, -1));
            normalPeriodsTime.add(new Period(17, 18));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate16() throws IllegalArgumentException {
            System.out.println("r9 period  ");
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(1, 2));
            normalPeriodsTime.add(new Period(-1, 18));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate17() throws IllegalArgumentException {
            System.out.println("r9 period ");
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(1, 2));
            normalPeriodsTime.add(new Period(18, -1));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate18() throws IllegalArgumentException {
            System.out.println("r9 period ");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(0, 0));
            normalPeriodsTime.add(new Period(0, 0));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate19() throws IllegalArgumentException {
            System.out.println("r9 period ");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(0, 0));
            normalPeriodsTime.add(new Period(1, 2));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate20() throws IllegalArgumentException {
            System.out.println("r9 period ");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1, 2));
            normalPeriodsTime.add(new Period(0, 0));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate21() throws IllegalArgumentException {
            System.out.println("r9 period ");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime = null;
            normalPeriodsTime.add(new Period(1,2));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate22() throws IllegalArgumentException {
            System.out.println("r9 period ");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime = null;
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate23() throws IllegalArgumentException {
            System.out.println("r9 period ");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = null;
            hourlyReducedRate = BigDecimal.valueOf(1);

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }
        @Test(expected = IllegalArgumentException.class)
        public void rate24() throws IllegalArgumentException {
            System.out.println("r9 period ");
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = null;

            new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
        }


        /***************************************************************
         *
         *
         * Testing the calculate method from here down
         *
         */
        @Test(expected = IllegalArgumentException.class)
        public void calculate1() throws IllegalArgumentException {
            stayTest = new Period(-1, -1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 1  " + stayTest.duration());
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate2() throws IllegalArgumentException {
            stayTest = new Period(-1, 0);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 2  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate3() throws IllegalArgumentException {
            stayTest = new Period(-1, 1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate3  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate4() throws IllegalArgumentException {
            stayTest = new Period(1, 1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 4  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate5() throws IllegalArgumentException {
            stayTest = new Period(1, 0);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 5  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate6() throws IllegalArgumentException {
            stayTest = new Period(1, -1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 6  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate7() throws IllegalArgumentException {
            stayTest = new Period(24, 24);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 7  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate8() throws IllegalArgumentException {
            stayTest = new Period(24, 25);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 8  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate9() throws IllegalArgumentException {
            stayTest = new Period(24, 0);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 9  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate10() throws IllegalArgumentException {
            stayTest = new Period(24, 1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 10  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate11() throws IllegalArgumentException {
            stayTest = new Period(24, 23);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 11  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate12() throws IllegalArgumentException {
            stayTest = new Period(12, 12);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 12  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate13() throws IllegalArgumentException {
            stayTest = new Period(12, 11);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 13  ");
        }

        @Test//(expected = IllegalArgumentException.class)
        public void calculate14() {
            stayTest = new Period(8, 18);
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(10, 11));
            normalPeriodsTime.add(new Period(8, 9));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(BigDecimal.valueOf(3), is(rt.calculate(stayTest)));
            System.out.println("calculate 14  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate15() throws IllegalArgumentException {
            stayTest = new Period('A', 1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 15  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate16() throws IllegalArgumentException {
            stayTest = new Period('Z', 1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 16  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate17() throws IllegalArgumentException {
            stayTest = new Period('a', 1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 17  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate18() throws IllegalArgumentException {
            stayTest = new Period('z', 1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 18  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate19() throws IllegalArgumentException {
            stayTest = new Period(1, 'A');
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 19  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate20() throws IllegalArgumentException {
            stayTest = new Period(1, 'a');
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 20  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate21() throws IllegalArgumentException {
            stayTest = new Period(1, 'Z');
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 21  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate22() throws IllegalArgumentException {
            stayTest = new Period(1, 'z');
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 22  ");
        }
        @Test
        public void calculate23() {
            stayTest = new Period(1, 9);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(17, 18));
            normalPeriodsTime.add(new Period(9, 16));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
        }

     //   @Test
      //  public void calculate() {   //test passed as correct input  TODO
      //      stayTest = new Period(0, 1);
      //      System.out.println("in calculate test");
     //   }
        @Test
        public void calculate24() {
            stayTest = new Period(19, 24);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(17, 19));
            normalPeriodsTime.add(new Period(9, 11));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
        }
        @Test
        public void calculate25() {
            stayTest = new Period(11, 17);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(17, 19));
            normalPeriodsTime.add(new Period(9, 11));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
        }
        @Test
        public void calculate26() {
            stayTest = new Period(2, 23);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(23, 24));
            normalPeriodsTime.add(new Period(1, 2));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
        }
        @Test
        public void calculate27() {
            stayTest = new Period(3, 24);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(2, 3));
            normalPeriodsTime.add(new Period(1, 2));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
        }
        @Test
        public void calculate28() {
            stayTest = new Period(1, 22);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(23, 24));
            normalPeriodsTime.add(new Period(22, 23));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
        }
        @Test
        public void calculate29() {
            stayTest = new Period(1, 23);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(23, 24));
            normalPeriodsTime.add(new Period(1, 23));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(7.00)));
        }
        @Test
        public void calculate30() {
            stayTest = new Period(1, 24);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(23, 24));
            normalPeriodsTime.add(new Period(1, 23));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(7.00)));
        }
        @Test
        public void calculate31() {
            stayTest = new Period(1, 24);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(23, 24));
            normalPeriodsTime.add(new Period(1, 23));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(18.50)));
        }
        @Test
        public void calculate32() {
            stayTest = new Period(1, 24);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(20, 24));
            normalPeriodsTime.add(new Period(9, 17));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(6.00)));
        }
        @Test
        public void calculate33() {
            stayTest = new Period(9, 10);
            carParkKind = CarParkKind.MANAGMENT;

            reducedPeriodsTime.add(new Period(17, 24));
            normalPeriodsTime.add(new Period(9, 17));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(3.00)));
        }
        @Test
        public void calculate34() {
            stayTest = new Period(9, 17);
            carParkKind = CarParkKind.MANAGMENT;

            reducedPeriodsTime.add(new Period(17, 24));
            normalPeriodsTime.add(new Period(9, 17));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(8.00)));
        }
        @Test
        public void calculate35() {
            stayTest = new Period(9, 17);
            carParkKind = CarParkKind.STUDENT;

            reducedPeriodsTime.add(new Period(17, 24));
            normalPeriodsTime.add(new Period(9, 17));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.625)));
        }
        @Test
        public void calculate36() {
            stayTest = new Period(9, 17);
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(17, 24));
            normalPeriodsTime.add(new Period(9, 17));
            hourlyNormalRate = BigDecimal.valueOf(4);
            hourlyReducedRate = BigDecimal.valueOf(2);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(16.00)));
        }
    }

