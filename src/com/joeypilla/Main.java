package com.joeypilla;

/*
You have a 2-dimensional rectangular crate of size X by Y, and a bunch of boxes, each of size x by y.
The dimensions are all positive integers.

Given X, Y, x, and y, determine how many boxes can fit into a single crate if they have to be placed so that the x-axis
of the boxes is aligned with the x-axis of the crate, and the y-axis of the boxes is aligned with the y-axis of the
crate. That is, you can't rotate the boxes. The best you can do is to build a rectangle of boxes as large as possible
in each dimension.

For instance, if the crate is size X = 25 by Y = 18, and the boxes are size x = 6 by y = 5, then the answer is 12.
You can fit 4 boxes along the x-axis (because 6*4 <= 25), and 3 boxes along the y-axis (because 5*3 <= 18), so in total
you can fit 4*3 = 12 boxes in a rectangle.
 */
public class Main {

    public static int fitBoxes(Box box, int x, int y) {
        int boxCount = (y/box.getHeight())*(x/box.getWidth());
        int boxCountRotated = (x/box.getHeight())*(y/box.getWidth());
        return (boxCount > boxCountRotated ? boxCount : boxCountRotated);
    }

    public static int fitCubes(Cube cube, int x, int y, int z) {
        int[][] posibilities = {{x,y,z}, {x,z,y}, {y,x,z}, {y,z,x}, {z,x,y}, {z,y,x}};
        int max = 0;
        int next = 0;
        for( int[] posibility : posibilities) {
            if ( next > max) {
                max = next;
            }
            next = getCubeCount(cube.getHeight(), cube.getWidth(), cube.getLength(), posibility);
        }
        return (max);
    }

    public static int getCubeCount(int height, int width, int length, int[] arr) {
        return ((arr[0]/height)*(arr[1]/width)*(arr[2]/length));
    }

    public static int getLeapYears(int year1, int year2) {
        if(year1 > year2) {
            return 0;
        }
        int leapYearCount = year2/4 - year1/4;
        leapYearCount -= year2/100 - year1/100;
        leapYearCount += getDoubleException(year2) - getDoubleException(year1);
        return(leapYearCount);
    }

    public static int getDoubleException(int year) {
        int doubleException = 0;
        doubleException += (year-200)/900;
        doubleException += (year-600)/900;
        if(year >= 200) {
            doubleException++;
        }
        if(year >= 600) {
            doubleException++;
        }

        return doubleException;
    }

    public static void main(String[] args) {
//        Box box = new Box();
//        box.setHeight(6);
//        box.setWidth(5);
//        Cube cube = new Cube();
//        cube.setLength(6);
//        cube.setHeight(5);
//        cube.setWidth(6);
//        System.out.println(fitCubes(cube, 25,18,12));
//        System.out.println(fitBoxes(box, 25,18));

        // new leap year problem find leap years between them
        int year1 = 123456;
        int year2 = 7891011;
        System.out.println(getLeapYears(year1, year2));
    }
}
