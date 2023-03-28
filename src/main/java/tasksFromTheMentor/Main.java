package tasksFromTheMentor;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("FIRST TASK");
        System.out.println("SOLUTION:");

        String strDate1 = "14.01.2007";
        System.out.println(firstTask(strDate1) + " - дней прошло с момента моего рождения");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("SECOND TASK");
        System.out.println("SOLUTION:");

        String strDate2 = "14.01.2007";
        System.out.println(secondTask(strDate2));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("THIRD TASK");
        System.out.println("SOLUTION:");

        ZonedDateTime zdtCurrent = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Kiev"));
        System.out.println("Текущая Дата и Временная зона - " + zdtCurrent);
        System.out.println("Новая временная Зона - " + thirdTask(zdtCurrent, ZoneId.of("America/Phoenix")));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("FOURTH TASK");
        System.out.println("SOLUTION:");

        System.out.println("Время , прошедшее с начала запуска программы - " + fourthTask()); //работает
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("FIFTH TASK");
        System.out.println("SOLUTION:");
        List<String> strings = new ArrayList<>();
        strings.add("2009-02-14 19:13");
        strings.add("2005-09-17 12:15");
        strings.add("2009-01-02 20:12");
        System.out.println("Самая большая дата - " + fifthTask(strings));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("FIFTH TASK");
        System.out.println("SOLUTION:");
        //6. Просто в методе мейн повызывать методы класса LocalData и использовать этот функционал просто для наглядности
        // выводя результаты работы отдельных методов в консоль. Чем больше методов вы разберете - тем лучше.
        /////
        System.out.println("\"Method now() :\"");
        System.out.println("позволяет создать Дату текущего времени ");
        LocalDate ld1 = LocalDate.now();

        LocalDate ld2 = LocalDate.now();
        System.out.println(ld1);
        /////
        System.out.println("\"Method getYear() :\"");
        System.out.println("Возвращает год даты");
        System.out.println(ld1.getYear());
        /////
        System.out.println("\"Method plusYears() :\"");
        System.out.println("Добавляет колличество лет , которые внесешь в качестве аргумента : ");
        System.out.println(ld1.plusYears(3));
        /////
        System.out.println("\"Method minusDays() :\"");
        System.out.println("Отимает колличество лет , которые внесешь в качестве аргумента : ");
        System.out.println(ld1.getYear());
        /////
        System.out.println("\"Methods isBefore() :\"");
        System.out.println("Была ли this дата создана до даты что в качестве аргумента : ");
        System.out.println(ld1.isBefore(ld2));
        /////
        System.out.println("\"Methods isAfter() :\"");
        System.out.println("Была ли this дата создана после даты что в качестве аргумента : ");
        System.out.println(ld1.isAfter(ld2));
        ////
        System.out.println("\"Methods isEquals() :\"");
        System.out.println("Равны ли даты даты : ");
        System.out.println(ld1.isAfter(ld2));
    }

    //1. Написать метод, который будет принимать дату рождения в строке и возвращать количество дней в формате инт, которые прошли с этого дня.
    public static int firstTask(String dateOfBirthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate ld1 = LocalDate.parse(dateOfBirthday, formatter);
        LocalDate ld2 = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(ld1, ld2);
    }

    //2. Написать метод, который будет принимать дату в строке с неизвестным форматом и возвращать объект LocalDate, который нужно получить спарсив эту строку.
    //Т.е. нужно написать как можно больше разных форматов даты в которые можно будет спарсить строку. Если всё таки ниодин формат не подошёл - возвращать null.
    public static LocalDate secondTask(String date) {
        List<DateTimeFormatter> formatters = List.of(
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("dd MMMM yyyy"),
                DateTimeFormatter.ofPattern("MMMM dd, yyyy"),
                DateTimeFormatter.ofPattern("MMM dd, yyyy"),
                DateTimeFormatter.ofPattern("yyyy/MM/dd")
        );
        for (DateTimeFormatter f : formatters) {
            try {
                return LocalDate.parse(date, f);
            } catch (DateTimeParseException e) {
                //....
            }
        }
        return null;
    }

    // 3.Написать метод, который будет конвертировать время из одной временной зоны в другую, используя стандартную библиотеку Java.
    public static ZonedDateTime thirdTask(ZonedDateTime zdt1, ZoneId z) {
        ZonedDateTime zdtNew = zdt1.withZoneSameLocal(z);
        return zdtNew;
    }

    //4. Разработать функционал, который определяет время, прошедшее с момента запуска приложения до момента его завершения.
    public static long fourthTask() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            System.out.println(i * 10);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    //5. Создать метод, который принимает на вход лист строк (которые должны содержать даты) и с помощью StreamAPI вернуть самую большую дату из этого списка в формате LocalDateTime
    public static LocalDateTime fifthTask(List<String> strings) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        List<LocalDateTime> parseList = strings.stream().map(el -> LocalDateTime.parse(el, formatter)).toList();
        System.out.println("даты которые находяться в списке - " + strings);
        return parseList.stream().max(new Comparator<LocalDateTime>() {
            @Override
            public int compare(LocalDateTime o1, LocalDateTime o2) {
                if (o1.isAfter(o2)) {
                    return 1;
                } else if (o1.isBefore(o2)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }).get();
    }

}
