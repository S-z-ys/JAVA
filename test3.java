package T1;

//建造者模式
//Members:个性装扮类，充当复杂产品对象
class Members {
    private String airBubbles;//气泡
    private String theTheme;//主题
    private String theFont;//字体
    private String amusing;//好玩
    private String pendant;//挂件

    public String getAirBubbles() { return airBubbles;
    }

    public void setAirBubbles(String airBubbles) {
        this.airBubbles = airBubbles;
    }

    public String getTheTheme() {
        return theTheme;
    }

    public void setTheTheme(String theTheme) {
        this.theTheme = theTheme;
    }

    public String getTheFont() {
        return theFont;
    }

    public void setTheFont(String theFont) {
        this.theFont = theFont;
    }

    public String getAmusing() {
        return amusing;
    }

    public void setAmusing(String amusing) {
        this.amusing = amusing;
    }

    public String getPendant() {
        return pendant;
    }

    public void setPendant(String pendant) {
        this.pendant = pendant;
    }
}
//MembersBuilder: 个性装扮种类，充单抽象建造者
abstract class MembersBuilder{
    protected Members members=new Members();
    public abstract void buildAirBubbles();
    public abstract void buildTheTheme();
    public abstract void buildTheFont();
    public abstract void buildAmusing();
    public abstract void buildPendant();
    public Members createMembers(){
        return members;
    }
}
//UserBuilder:使用者个性装扮的组成，充当具体建造者
 class UserBuilder extends MembersBuilder{
     public void buildAirBubbles(){
        members.setAirBubbles("DIY气泡");
    }
    public void buildTheTheme(){
        members.setTheTheme("DIY专区");
    }
    public  void buildTheFont(){
        members.setTheFont("超大特效字体");
    }
    public  void buildAmusing(){
        members.setAmusing("恋人专题");
    }
    public  void buildPendant(){
        members.setPendant("闪亮星星");
    }
}

class UserBBuilder extends MembersBuilder{
    public void buildAirBubbles(){
        members.setAirBubbles("自定义气泡");
    }
    public void buildTheTheme(){
        members.setTheTheme("精美主题");
    }
    public  void buildTheFont(){
        members.setTheFont("大小字特效");
    }
    public  void buildAmusing(){
        members.setAmusing("最热推荐");
    }
    public  void buildPendant(){
        members.setPendant("自定义");
    }
}
//UserController:使用者角色控制器，充当具体指挥者

class UserController{
    public Members construct(MembersBuilder mb){
        Members members;
        mb.buildAirBubbles();
        mb.buildTheTheme();
        mb.buildTheFont();
        mb.buildAmusing();
        mb.buildPendant();
        members = mb.createMembers();
        return members;
    }
}
  //测试类
public class test3{
    public static void main(String[] args) {
        MembersBuilder mb=new UserBuilder();
        UserController uc= new UserController();
        Members members;
        members = uc.construct(mb);
        String airBubbles=members.getAirBubbles();
        System.out.println("QQ用户A个性装扮自选组成");
        System.out.println("气泡："+airBubbles);
        System.out.println("主题："+members.getTheTheme());
        System.out.println("字体："+members.getTheFont());
        System.out.println("好玩："+members.getAmusing());
        System.out.println("挂件："+members.getPendant());
        System.out.println("-------------------");
        MembersBuilder mb1=new UserBBuilder();
        UserController uc1= new UserController();
        Members membersB;
        membersB = uc1.construct(mb1);
        String airBubblesB=membersB.getAirBubbles();
        System.out.println("QQ用户B个性装扮自选组成");
        System.out.println("气泡："+airBubbles);
        System.out.println("主题："+members.getTheTheme());
        System.out.println("字体："+members.getTheFont());
        System.out.println("好玩："+members.getAmusing());
        System.out.println("挂件："+members.getPendant());
    }
  }