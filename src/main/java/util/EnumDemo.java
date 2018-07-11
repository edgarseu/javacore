package util;

/**
 * Created by caozy on 2017/12/22.
 */
enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumDemo {

    public static void main(String[] args) {

        //创建枚举数组
        util.Day[] days = new util.Day[]{util.Day.MONDAY, util.Day.TUESDAY, util.Day.WEDNESDAY,
                util.Day.THURSDAY, util.Day.FRIDAY, util.Day.SATURDAY, util.Day.SUNDAY};

        for (int i = 0; i < days.length; i++) {
            System.out.println("day[" + i + "].ordinal():" + days[i].ordinal());
        }

        System.out.println("-------------------------------------");
        //通过compareTo方法比较,实际上其内部是通过ordinal()值比较的
        System.out.println("days[0].compareTo(days[1]):" + days[0].compareTo(days[1]));
        System.out.println("days[0].compareTo(days[1]):" + days[0].compareTo(days[2]));

        //获取该枚举对象的Class对象引用,当然也可以通过getClass方法
        Class<?> clazz = days[0].getDeclaringClass();
        System.out.println("clazz:" + clazz);

        System.out.println("-------------------------------------");

        //name()
        System.out.println("days[0].name():" + days[0].name());
        System.out.println("days[1].name():" + days[1].name());
        System.out.println("days[2].name():" + days[2].name());
        System.out.println("days[3].name():" + days[3].name());

        System.out.println("-------------------------------------");

        System.out.println("days[0].toString():" + days[0].toString());
        System.out.println("days[1].toString():" + days[1].toString());
        System.out.println("days[2].toString():" + days[2].toString());
        System.out.println("days[3].toString():" + days[3].toString());

        System.out.println("-------------------------------------");

        util.Day d = Enum.valueOf(util.Day.class, days[0].name());
        util.Day d2 = util.Day.valueOf(util.Day.class, days[0].name());
        System.out.println("d:" + d);
        System.out.println("d2:" + d2);


    }
}
