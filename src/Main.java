import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args) throws IOException
    {
        System.out.print("Программа калькулятор. \nВведите выражение используя либо арабские либо римские цифры и знаки (+ - * /): ");
        Scanner stroka = new Scanner(System.in);
        String vvod = stroka.nextLine();
       System.out.println("Ответ: "+calc(vvod));

    }
public static String calc(String args) throws IOException
{
    int a; // Первое число
    int b; // Второе число
    String astr = ""; // Первое число
    String bstr = ""; //Второе число
    String znak = ""; //Знак
    int rInt; //Результат
    String rezults=""; //Результат
    String vvod=args; //Ввод
    vvod=vvod.toUpperCase(); //Перевод в верхний регистр
    vvod=vvod.replaceAll(" ",""); //Убираем пробелы
    int i = 0; //счетчик
    int ind = 1; //счетчик
    short valAR = 0; //римские или арабские
    if (vvod.length() > 2)
    {
        char[] stringArray = vvod.toCharArray();
        for (char element : stringArray)
        {
            if (ind <= 4)
            {
                switch (ind)
                {
                    case 1:
                        if (vvod.charAt(i)=='+'||vvod.charAt(i)=='-'||
                                vvod.charAt(i)=='/'||vvod.charAt(i)=='*')
                        {znak = znak + vvod.charAt(i);
                         ind=3;
                        break;}
                        astr = astr + vvod.charAt(i);
                        break;
                    case 3:

                        bstr = bstr + vvod.charAt(i);
                        break;
                    case 4:
                        throw new IOException();
                }
            }
            else { ind++;
            }



            i++;
        }
    }
    else { throw new IOException();}
    if (ind<3) { throw new IOException();}




    if (RomeNum.findByName(astr)!= null && RomeNum.findByName(bstr)!=null)
    {
        a = RomeNum.valueOf(astr).ordinal()+1;
        b = RomeNum.valueOf(bstr).ordinal()+1;
        valAR = 1;
    }
    else
    {
        a = Integer.parseInt(astr);
        b = Integer.parseInt(bstr);
        if ((a < 1 || a > 10) || (b < 1 || b > 10))
        {
            throw new IOException();
        }
    }
    if (valAR==0) {
        switch (znak) {
            case "+":
                rInt=a+b;
                rezults=Integer.toString(rInt);
                break;
            case "-":
                rInt=a-b;
                rezults=Integer.toString(rInt);
                break;
            case "*":
                rInt=a*b;
                rezults=Integer.toString(rInt);
                break;
            case "/":
                rInt=a/b;
                rezults=Integer.toString(rInt);
                break;


        }

    }
    else
    { switch (znak) {
        case "+":
            rInt=a+b;
            RomeNumOut n1 = RomeNumOut.values()[rInt-1];
            rezults=n1.toString();
            break;
        case "-":
            rInt=a-b;
            if (rInt<1){throw new IOException();}
            RomeNumOut n2 = RomeNumOut.values()[rInt-1];
            rezults=n2.toString();
            break;
        case "*":
            rInt=a*b;
            RomeNumOut n3 = RomeNumOut.values()[rInt-1];
            rezults=n3.toString();
            break;
        case "/":
            rInt=a/b;
            RomeNumOut n4 = RomeNumOut.values()[rInt-1];
            rezults=n4.toString();
            break;


    }

     }

    return rezults;
}
}

