package hw1;

import hw1.obstacles.*;
import hw1.сreatures.*;
import hw1.сreatures.interfaces.*;

/*
    1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
        Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
    2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны
        выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль
        (успешно пробежал, не смог пробежать и т.д.).
    3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
    4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
        Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */
public class Main {
    public static void main(String[] args) {
        // Можно создать массив не Object, а Overcomable,
        // но тогда потеряется доступ к части функционала, который может появиться в перспективе.
        Object[] creatures = new Object[3];
        creatures[0] = new Cat("Гусь", 100, 1);
        creatures[1] = new Human("Джон", 10000, 1.5);
        creatures[2] = new Robot("T-1000", 999999, 10);

        Obstacle[] obstacles = new Obstacle[5];
        obstacles[0] = new Wall("бордюр", 0.2);
        obstacles[1] = new Treadmill("тропинка", 10);
        obstacles[2] = new Wall("забор", 0.5);
        obstacles[3] = new Treadmill("осушенный водоканал", 200);
        obstacles[4] = new Wall("высокий забор", 5);

        // В условиях запрета объединения Cat, Human и Robot в одну иерархию
        // Я добавил интерфейс Overcomable чтобы избежать следующего
        /*
        if (creature instanceof Cat) {
            (((Cat) creature).overcomeObstacle(obstacle)
        if (creature instanceof Human)
            ((Human) creature).overcomeObstacle(obstacle)
        if (creature instanceof Robot)
            ((Robot) creature).overcomeObstacle(obstacle)
         */
        //
        for (Obstacle obstacle : obstacles) {
            for (Object creature : creatures) {
                if (((Overcomable) creature).overcomeObstacle(obstacle) == false) {
                    // "дальше по списку он препятствий не идет" можно понимать по-разному, например
                    //creature = null;
                    // Даже если не затирать ссылку в массиве, все будет работать за счет внутренних проверок классов Cat, Human, Robot
                }
            }
            System.out.println();
        }
    }
}
