package cm;
/*
     * Author Simon Remington
     * Date 24/02/2019
     *
     * The tester is first part testing the Rate constructor
     * The method calculate is in lower part
     */
    import org.junit.Test;
    import static org.junit.Assert.assertTrue;

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
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 1  " + stayTest.duration());
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate2() throws IllegalArgumentException {
            stayTest = new Period(-1, 0);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 2  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate3() throws IllegalArgumentException {
            stayTest = new Period(-1, 1);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate3  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate4() throws IllegalArgumentException {
            stayTest = new Period(1, 1);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 4  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate5() throws IllegalArgumentException {
            stayTest = new Period(1, 0);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 5  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate6() throws IllegalArgumentException {
            stayTest = new Period(1, -1);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 6  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate7() throws IllegalArgumentException {
            stayTest = new Period(24, 24);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 7  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate8() throws IllegalArgumentException {
            stayTest = new Period(24, 25);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 8  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate9() throws IllegalArgumentException {
            stayTest = new Period(24, 0);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 9  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate10() throws IllegalArgumentException {
            stayTest = new Period(24, 1);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 10  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate11() throws IllegalArgumentException {
            stayTest = new Period(24, 23);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 11  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate12() throws IllegalArgumentException {
            stayTest = new Period(12, 12);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);

            System.out.println("calculate 12  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate13() throws IllegalArgumentException {
            stayTest = new Period(12, 11);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
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
            //assertThat(rt.calculate(stayTest).doubleValue(), is(3.00));//TODO remember to do something
            assertTrue(BigDecimal.valueOf(3).compareTo(rt.calculate(stayTest)) == 0);
            System.out.println("calculate 14  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate15() throws IllegalArgumentException {
            stayTest = new Period('A', 1);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 15  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate16() throws IllegalArgumentException {
            stayTest = new Period('Z', 1);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 16  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate17() throws IllegalArgumentException {
            stayTest = new Period('a', 1);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 17  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate18() throws IllegalArgumentException {
            stayTest = new Period('z', 1);
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 18  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate19() throws IllegalArgumentException {
            stayTest = new Period(1, 'A');
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 19  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate20() throws IllegalArgumentException {
            stayTest = new Period(1, 'a');
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 20  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate21() throws IllegalArgumentException {
            stayTest = new Period(1, 'Z');
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
            Rate rc = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            rc.calculate(stayTest);
            System.out.println("calculate 21  ");
        }

        @Test(expected = IllegalArgumentException.class)
        public void calculate22() throws IllegalArgumentException {
            stayTest = new Period(1, 'z');
            carParkKind = CarParkKind.STAFF;
            reducedPeriodsTime.add(new Period(1,2));
            normalPeriodsTime.add(new Period(3,4));
            hourlyNormalRate = BigDecimal.valueOf(2);
            hourlyReducedRate = BigDecimal.valueOf(1);
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
            //assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
            assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(stayTest)) == 0);
        }
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
            //assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
            assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(stayTest)) == 0);
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
            //assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
            assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(stayTest)) == 0);
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
            //assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
            assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(stayTest)) == 0);
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
            //assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
            assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(stayTest)) == 0);
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
            //assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.00)));
            assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(stayTest)) == 0);
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
            //assertThat(rt.calculate(stayTest).doubleValue(), is(7.00));
            assertTrue(BigDecimal.valueOf(7).compareTo(rt.calculate(stayTest)) == 0);
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
            //assertThat(rt.calculate(stayTest).doubleValue(), is(7.00));
            assertTrue(BigDecimal.valueOf(7).compareTo(rt.calculate(stayTest)) == 0);
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
            //assertThat(rt.calculate(stayTest).doubleValue(), is(18.50));
            assertTrue(BigDecimal.valueOf(18.50).compareTo(rt.calculate(stayTest)) == 0);
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
            //assertThat(rt.calculate(stayTest).doubleValue(), is(6.00));
            assertTrue(BigDecimal.valueOf(6).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate33() {
            stayTest = new Period(9, 10);
            carParkKind = CarParkKind.MANAGEMENT;

            reducedPeriodsTime.add(new Period(17, 24));
            normalPeriodsTime.add(new Period(9, 17));
            hourlyNormalRate = BigDecimal.valueOf(1);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            //assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(3.00)));
            assertTrue(BigDecimal.valueOf(3).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate34() {
            stayTest = new Period(9, 17);
            carParkKind = CarParkKind.MANAGEMENT;

            reducedPeriodsTime.add(new Period(17, 24));
            normalPeriodsTime.add(new Period(9, 17));
            hourlyNormalRate = BigDecimal.valueOf(1.00);
            hourlyReducedRate = BigDecimal.valueOf(0.00);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            //assertThat(rt.calculate(stayTest).doubleValue(), is(8.00));
            assertTrue(BigDecimal.valueOf(8).compareTo(rt.calculate(stayTest)) == 0);
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
            //assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(0.625)));
            assertTrue(BigDecimal.valueOf(0.625).compareTo(rt.calculate(stayTest)) == 0);
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
            //assertThat(rt.calculate(stayTest), is(BigDecimal.valueOf(16.00)));
            assertTrue(BigDecimal.valueOf(16).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate37() {
            stayTest = new Period(1, 24);
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(23, 24));
            normalPeriodsTime.add(new Period(1, 23));
            hourlyNormalRate = BigDecimal.valueOf(4);
            hourlyReducedRate = BigDecimal.valueOf(2);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
           // assertThat(rt.calculate(stayTest), is(16.00));
            assertTrue(BigDecimal.valueOf(16).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate38() {
            stayTest = new Period(0, 24);
            carParkKind = CarParkKind.STUDENT;

            reducedPeriodsTime.add(new Period(23, 24));
            normalPeriodsTime.add(new Period(0, 23));
            hourlyNormalRate = BigDecimal.valueOf(4);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(21.875).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate39() {
            stayTest = new Period(0, 24);
            carParkKind = CarParkKind.MANAGEMENT;

            reducedPeriodsTime.add(new Period(23, 24));
            normalPeriodsTime.add(new Period(0, 23));
            hourlyNormalRate = BigDecimal.valueOf(4);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(93.00).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate40() {
            stayTest = new Period(0, 24);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(23, 24));
            normalPeriodsTime.add(new Period(0, 23));
            hourlyNormalRate = BigDecimal.valueOf(4);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(42.5).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate41() {
            stayTest = new Period(0, 24);
            carParkKind = CarParkKind.VISITOR;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(8, 10));
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(4);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(5.5).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate42() {
            stayTest = new Period(0, 24);
            carParkKind = CarParkKind.MANAGEMENT;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(8, 10));
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(4);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(19).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate43() {
            stayTest = new Period(0, 24);
            carParkKind = CarParkKind.STUDENT;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(8, 10));
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(4);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(3.375).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate44() {
            stayTest = new Period(0, 24);
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(8, 10));
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(4);
            hourlyReducedRate = BigDecimal.valueOf(1);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                                            reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(16).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate45() {
            stayTest = new Period(8, 9);
            carParkKind = CarParkKind.MANAGEMENT;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(8, 10));
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(2.99);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(3).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate46() {
            stayTest = new Period(8, 9);
            carParkKind = CarParkKind.MANAGEMENT;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(8, 10));
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(3.00);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(3).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate47() {
            stayTest = new Period(8, 9);
            carParkKind = CarParkKind.MANAGEMENT;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(8, 10));
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(3.01);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(3.01).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate48() {
            stayTest = new Period(8, 9);
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(8, 10));
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(15.99);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(15.99).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate49() {
            stayTest = new Period(8, 9);
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(8, 10));
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(16.00);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(16).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test
        public void calculate50() {
            stayTest = new Period(8, 9);
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(8, 10));
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(16.01);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(16).compareTo(rt.calculate(stayTest)) == 0);
        }
        @Test(expected = IllegalArgumentException.class)
        public void calculate51() {
            stayTest = new Period(8, 9);
            carParkKind = CarParkKind.STAFF;

            reducedPeriodsTime.add(new Period(11, 12));
            reducedPeriodsTime.add(new Period(18, 20));
            normalPeriodsTime.add(new Period(25, 10)); //start > 25
            normalPeriodsTime.add(new Period(14, 16));
            hourlyNormalRate = BigDecimal.valueOf(16.01);
            hourlyReducedRate = BigDecimal.valueOf(0);

            Rate rt = new Rate(carParkKind, hourlyNormalRate, hourlyReducedRate,
                    reducedPeriodsTime, normalPeriodsTime);
            assertTrue(BigDecimal.valueOf(16).compareTo(rt.calculate(stayTest)) == 0);
        }
    }

