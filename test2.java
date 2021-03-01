package T1;
//适配器模式
//QQTarget:充当目标类
  class QQTarget{
    public void day() {

    }

    public void night() {

    }
}
//DayAdatee:白天类，充当适配者
class DayAdatee{
    public void QQtheDay(){
        System.out.print("白天：");
        System.out.println("白色主题");
    }
}
//TheNightAdatee:夜间类，充当适配者
class TheNightAdatee{
    public void QQnight(){
        System.out.print("夜晚：");
        System.out.println("黑色主题");
    }
}
//DayAdapter:白天主题类，充当适配者
class DayAdapter extends QQTarget {
      private DayAdatee theDay;
      public DayAdapter(){
          theDay=new DayAdatee();
      }
      public void day(){
          theDay.QQtheDay();
      }
}
//TheNightAdapter:夜间主题类，充当适配者
class TheNightAdapter extends QQTarget {

    private TheNightAdatee night;

    public TheNightAdapter() {

        night = new TheNightAdatee();
    }

    public void night() {
        night.QQnight();
    }
}
//测试类
public class test2 {
    public static void main(String[] args) {
        DayAdapter dayAdapter=new DayAdapter()  ;
       dayAdapter.day();
       System.out.println("-------------");
        TheNightAdapter theNightAdapter=new TheNightAdapter();
        theNightAdapter.night();
    }
}