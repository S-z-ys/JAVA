package T1;
//模板方法类：Charge.java 模板方法模式的模板类一般采用抽象类，
abstract class Charge{
    //final修饰，充值行为流程不可更改
    final void Charges(){
        theCardNumber();
        theName();

        if(conformThe()){
            passWord();
        }
        topUp();
        exit();

    }
    //1.需要先打开微信我的零钱选择新卡充值输入卡号
    abstract void theCardNumber();
    //2.输入持卡人名字
    abstract void theName();
    //3.输入银行卡密码
    abstract void passWord();
    //4.充值
    public void topUp(){
        System.out.println("4.充值");
    }
    //5.退去
    public void exit(){
        System.out.println("5.退去");
    }//看是否是要输入密码
    public boolean conformThe(){
        return true;
    }

}
//工商银行卡充值实现类：ICBCCharge.java
class ICBCCharge extends Charge{

    @Override
    void theCardNumber() {
        System.out.println("1.输入中国工商银行卡号");
    }
    void theName(){
        System.out.println("2.输入持卡人名字");
    }
    void passWord(){
        System.out.println("3.输入工商银行卡密码");
    }
    public boolean conformThe(){
        return false;
    }
}
//建设银行卡充值实现类：CCBCharge.java
class CCBCharge extends Charge{

    @Override
    void theCardNumber() {
        System.out.println("1.输入中国建行银行卡号");
    }

    void theName(){
        System.out.println("2.输入持卡人名字");
    }
    void passWord(){
        System.out.println("3.输入建行银行卡密码");
    }
}

//测试类：ChargeDemo.java
public class test1 {
    public static void main(String[] args) {
        Charge icbc = new ICBCCharge();
        Charge ccb = new CCBCharge();
        System.out.println("---------------用到工商银行卡充值------------------");
        icbc.Charges();
        System.out.println("---------------用建设银行卡充值------------------");
        ccb.Charges();
    }
}
