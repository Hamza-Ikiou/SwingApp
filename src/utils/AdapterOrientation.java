package utils;

public class AdapterOrientation {

    public static int stringToIntOrientation(String orientation) {
        switch (orientation) {
            case "N" : return 0;
            case "E" : return 90;
            case "S" : return 180;
            case "O" : return 270;
        }
        return 0;
    }

    public static String intToStringOrientation(int orientation) {
        switch (orientation) {
            case 0 : return "N";
            case 90 : return "E";
            case 180 : return "S";
            case 270 : return "O";
        }
        return "N";
    }
}
