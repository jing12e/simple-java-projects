import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentSystem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> list = new ArrayList<>();
        while (true) {
            System.out.println("Welcome to this Student Management System!");
            System.out.println("1: Sign in");
            System.out.println("2: Sign up");
            System.out.println("3: Forget password");
            System.out.println("Please enter your choice:");
            String choice = scanner.next();

            switch (choice) {
                case "1" -> signIn(list);
                case "2" -> signUp(list);
                case "3" -> forgetPassword(list);
                default -> System.out.println("There is no such option, please try again.");
            }
        }


    }


    public static void signUp(ArrayList<User> list) {
        System.out.println("Sign up");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username = scanner.next();
        username(list,username);

        System.out.println("Please enter your password: ");
        String password = scanner.next();

        while (true) {
            System.out.println("Please enter your password again:");
            String password2 = scanner.next();
            if(password.equals(password2)) {
                System.out.println("You can continue to sign up.");
                break;
            } else {
                System.out.println("The password you entered must be the same as the former one, please try again.");
            }
        }

        String personid = null;
        while (true) {
            System.out.println("Please enter your person ID:");
            personid = scanner.next();
            if (personId(personid)) {
                System.out.println("Person ID verified successfully.");
                break;
            } else {
                System.out.println("Person ID does not meet the requirements, please try again.");
            }
        }
        String phoneNumber = null;
        while (true) {
            System.out.println("Please enter you phone number:");
            phoneNumber = scanner.next();
            if (phoneNumber(phoneNumber)) {
                System.out.println("Phone number verified successfully.");
                break;
            } else {
                System.out.println("Phone number does not meet the requirements, please try again.");
            }
        }

        User u = new User(username, password, personid, phoneNumber);
        list.add(u);

        System.out.println("Congratulations, your registration is successful!");


    }

    public static void signIn(ArrayList<User> list) {
        System.out.println("Sign in");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username = scanner.next();
        if (!containsUsername(list, username)) {
            System.out.println("User not registered.");
            return;
        }

        String rightVeriCode = verificationCode();
        System.out.println(rightVeriCode);

        while (true) {
            System.out.println("Please enter verification code:");
            String veriCode = scanner.next();

            if (veriCode.equals(rightVeriCode)) {
                System.out.println("The verification code is correct.");
                break;
            } else {
                System.out.println("Incorrect verification code, please try again.");
            }
        }

        int count = 0;


        while (count < 3) {
            System.out.println("Please enter your password:");
            String password = scanner.next();
            boolean b = verifyUsernameAndPassword(list, username, password);
            if (b) {
                System.out.println("Log in successfully!");

                break;
            } else {
                System.out.println("False password, you have " + (2 - count) + " chances.");
                count++;
            }
        }


    }

    public static void forgetPassword(ArrayList<User> list) {
        System.out.println("Forget Password");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username = scanner.next();
        if (!containsUsername(list, username)) {
            System.out.println("User not registered.");
            return;
        }
        System.out.println("Please enter you person id:");
        String personid = scanner.next();
        System.out.println("Please enter your phone number:");
        String phoneNumber = scanner.next();

        boolean b = verifyPersonidAndPhoneNumber(list, username, personid, phoneNumber);
        if (b) {
            System.out.println();
        } else {
            System.out.println("False person id or phone number.");
            return;
        }

        System.out.println("Enter your new password:");
        String newPassword = scanner.next();
        User user = list.get(getContainsIndex(list, username));
        user.setPassword(newPassword);
        System.out.println("Password updated successfully!");


    }

    public static int getContainsIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(username)) {
                return i;
            }

        }
        return -1;

    }
    public static boolean containsUsername(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(username)) {
                return true;
            }

        }
        return false;

    }
    public static boolean verifyUsernameAndPassword(ArrayList<User> list, String username, String password) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;

            }

        }
        return false;

    }

    public static boolean verifyPersonidAndPhoneNumber(ArrayList<User> list, String username, String personid, String phoneNumber) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(username) && user.getPhoneNumber().equals(phoneNumber) && user.getPersonId().equals(personid)) {
                return true;
            }
        }
        return false;

    }
    public static boolean usernameCount(String username) {
        int numberCount = 0;
        int charCount = 0;

        for (int i = 0; i < username.length(); i++) {
            char character = username.charAt(i);
            if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')) {
                charCount++;
            }
            if ((character >= '0' && character <= '9')) {
                numberCount++;
            }

        }
        if (charCount > 0) {
            return true;

        } else {
            return false;
        }



    }

    public static boolean usernameFormat(String username) {

        for (int i = 0; i < username.length(); i++) {
            char character = username.charAt(i);
            if (!((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z') || (character >= '0' && character <= '9'))) {
                return false;
            }
        }
        return true;

    }

    public static void username(ArrayList<User> list, String username) {
        boolean b = containsUsername(list, username);
        boolean b1 = usernameCount(username);
        boolean b2 = usernameFormat(username);
        int i = username.length();
        if (b) {
            System.out.println("Username already exists, please try again.");
        }

        if (!(i <= 15 && i >= 3)) {
            System.out.println("Username length must be between 3 - 15.");

        }
        if (!b2) {
            System.out.println("Username can only contain numbers and English letters, please do not contain special characters.");
        }
        if (!b1) {
            System.out.println("Username cannot be all numbers.");
        }

        if ((i <= 15 && i >= 3) && b1 && b2) {
            System.out.println("Username meets requirements!");
        }

    }

    public static boolean personId(String personid) {
        int length = personid.length();
        char firstChar = personid.charAt(0);
        int numberCount = 0;
        for (int i = 0; i < personid.length() - 1; i++) {
            char c = personid.charAt(i);
            if (c >= '0' && c <= '9') {
                numberCount++;
            }
        }

        if (length == 18) {
            char lastChar = personid.charAt(17);
            if((!(firstChar == '0')) && numberCount == 17 && (lastChar == 'X' || lastChar == 'x' || (lastChar <= '9' && lastChar >= '0'))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }

    public static boolean phoneNumber(String phoneNumber) {
        int length = phoneNumber.length();
        int numberCount = 0;

        for (int i = 0; i < phoneNumber.length(); i++) {
            char character = phoneNumber.charAt(i);
            if (character >= '0' && character <= '9') {
                numberCount++;
            }
        }

        if (length == 11) {
            if (numberCount == 11 && (!(phoneNumber.charAt(0) == '0'))) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public static String verificationCode() {
        //1.大写字母和小写字母都放到数组当中
        char[] chs = new char[52];
        for (int i = 0; i < chs.length; i++) {
            //ASCII码表
            if(i <= 25){
                //添加小写字母
                chs[i] = (char)(97 + i);
            }else{//27
                //添加大写字母
                // A --- 65
                chs[i] = (char)(65 + i - 26);
            }
        }

        //定义一个字符串类型的变量，用来记录最终的结果
        String code = "";

        //2.随机抽取4次
        //随机抽取数组中的索引
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(chs.length);
            //利用随机索引，获取对应的元素
            //System.out.println(chs[randomIndex]);
            code = code + chs[randomIndex];
        }
        //System.out.println(result);
        //3.随机抽取一个数字0~9
        int number = r.nextInt(10);
        //生成最终的结果
        code = code + number;


        //4.变成字符数组打乱数据
        char[] arr = code.toCharArray();
        //将数组里面的内容打乱
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);
            char temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        //将字符数组再变回字符串
        String result = new String(arr);

        //输出打印
        return result;

    }


}


