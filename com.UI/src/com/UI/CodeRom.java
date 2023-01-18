package com.UI;

import java.util.Random;

public class CodeRom {


    public static String getCode() {
        String code = "";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int type = r.nextInt(3);
            switch (type) {
                case 0:
                    char ch1 = (char) (r.nextInt(26) + 65);
                    code += ch1;
                    break;
                case 1:
                    char ch2 = (char) (r.nextInt(26) + 97);
                    code += ch2;
                    break;
                case 2:
                    int ch3 = r.nextInt(10);
                    code += ch3;
                    break;
            }
        }
        return code;
    }
}
