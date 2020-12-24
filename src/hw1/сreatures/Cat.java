package hw1.сreatures;

import hw1.сreatures.interfaces.*;
import hw1.obstacles.*;

public class Cat implements Overcomable {
    private String name = this.toString();
    private double runLimit = 50;
    private double jumpLimit = 1;
    private boolean isTired = false;

    public Cat() {
    }

    public Cat(String name, double runLimit, double jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public Cat(double runLimit, double jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public boolean overcomeObstacle(Obstacle obstacle) {
        if (isTired) {
            //System.out.println(ClassName.I.up() + " " + name + " больше не участвует в состязании.");
            return false;
        }
        if (obstacle instanceof Treadmill) {
            System.out.println("Перед " + ClassName.T.low() + " " + name +
                    " препядствие - " + obstacle.getName() + "(дорога). Его длина " + ((Treadmill) obstacle).getLength() + "м.");
            return run(((Treadmill) obstacle).getLength());
        } else if (obstacle instanceof Wall) {
            System.out.println("Перед " + ClassName.T.low() + " " + name +
                    " препядствие - " + obstacle.getName() + "(стена). Его высота " + ((Wall) obstacle).getHeight() + "м.");
            return jump(((Wall) obstacle).getHeight());
        }
        return false;
    }

    @Override
    public boolean run(double length) {
        if (!isTired && length <= runLimit) {
            System.out.println(ClassName.I.up() + " " + name + " успешно пробежал " + length + "м.");
            return true;
        } else {
            System.out.println(ClassName.I.up() + " " + name + " не смог пробежать " + length + "м. Он выбывает из гонки.");
            isTired = true;
        }
        return false;
    }

    @Override
    public boolean jump(double height) {
        if (!isTired && height <= jumpLimit) {
            System.out.println(ClassName.I.up() + " " + name + " успешно перепрыгнул " + height + "м.");
            return true;
        } else {
            System.out.println(ClassName.I.up() + " " + name + " не смог  перепрыгнуть. Он выбывает из гонки.");
            isTired = true;
        }
        return false;
    }

    public boolean isTired() {
        return isTired;
    }

    public enum ClassName {
        I("кот"), R("кота"), D("коту"),
        V("кота"), T("котом"), P("коте");
        private String word;

        ClassName(String word) {
            this.word = word;
        }

        // Маленькими буквами
        public String low() {
            return word;
        }

        // С большой буквы
        public String up() {
            StringBuilder sb = new StringBuilder(word);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            return sb.toString();
        }
    }
}