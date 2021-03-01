package T1;

//TheUser：用户，充当环境类
class TheUser {
    private TheUserState state;
    private double number = 0;
    public TheUser() {
        this.number = number;
        this.state = new NState(this);
        System.out.println("---------------");
    }
    public double getNumber() {
        return this.number;
    }
    public void setNumber(double number) {
        this.number = number;
    }
    public void setState(TheUserState state) {
        this.state = state;
    }
    public void codeName(double num) {
        state.codeName(num);
        System.out.println("QQ用户状态：");
    }
    public void userState() {
        state.userState();
    }
}
//TheUserState：用户状态，充当抽象状态类
abstract class TheUserState {
    protected TheUser qq;
    public abstract void codeName(double num);
    public abstract void userState();
    public abstract void qCheck();
}

//NState：在线状态类，充当具体状态类
class NState extends TheUserState {
    public NState(TheUser qq) {
        this.qq = qq;
    }
    public NState(TheUserState state) {
        this.qq = state.qq;
    }
    public void codeName(double num) {
        qq.setNumber(qq.getNumber()+num);
        qCheck();
    }
    @Override
    public void userState() {
        System.out.println("在线");
        System.out.println("---------------");
    }
    public void qCheck() {
        if (qq.getNumber() == 1) {
            qq.setState(new NState(this));
        } else if (qq.getNumber() == 2) {
            qq.setState(new OState(this));
        } else if (qq.getNumber() == 3) {
            qq.setState(new BState(this));
        } else if (qq.getNumber() == 4) {
            qq.setState(new SState(this));
        }
    }
}

//OState：离线状态类，充当具体状态类
class OState extends TheUserState {
    public OState(TheUserState state) {
        this.qq = state.qq;
    }

    public void codeName(double num) {
        qq.setNumber(qq.getNumber()+num);
        qCheck();
    }

    @Override
    public void userState() {
        System.out.println("离线");
        System.out.println("---------------");
    }

    public void qCheck() {
        if (qq.getNumber() == 1) {
            qq.setState(new NState(this));
        } else if (qq.getNumber() == 2) {
            qq.setState(new OState(this));
        } else if (qq.getNumber() == 3) {
            qq.setState(new BState(this));
        } else if (qq.getNumber() == 4) {
            qq.setState(new SState(this));
        }
    }
}

//BState：忙碌状态类，充当具体状态类
class BState extends TheUserState {

    public BState(TheUserState state) {
        this.qq = state.qq;
    }

    public void codeName(double num) {
        qq.setNumber(qq.getNumber()+num);
        qCheck();
    }

    @Override
    public void userState() {
        System.out.println("忙碌");
        System.out.println("---------------");
    }

    public void qCheck() {
        if (qq.getNumber() == 1) {
            qq.setState(new NState(this));
        } else if (qq.getNumber() == 2) {
            qq.setState(new OState(this));
        } else if (qq.getNumber() == 3) {
            qq.setState(new BState(this));
        } else if (qq.getNumber() == 4) {
            qq.setState(new SState(this));
        }
    }
}

//SState：隐身状态类，充当具体状态类
class SState extends TheUserState {
    public SState(TheUserState state) {
        this.qq = state.qq;
    }

    public void codeName(double num) {
        qq.setNumber(qq.getNumber()+num);
        qCheck();
    }

    @Override
    public void userState() {
        System.out.println("隐身");
        System.out.println("---------------");
    }

    public void qCheck() {
        if (qq.getNumber() == 1) {
            qq.setState(new NState(this));
        } else if (qq.getNumber() == 2) {
            qq.setState(new OState(this));
        } else if (qq.getNumber() == 3) {
            qq.setState(new BState(this));
        } else if (qq.getNumber() == 4) {
            qq.setState(new SState(this));
        }
    }
}

//测试类
public class test5 {
    public static void main(String[] args) {
        TheUser qq = new TheUser();
        qq.codeName(2);
        qq.userState();

    }
}
