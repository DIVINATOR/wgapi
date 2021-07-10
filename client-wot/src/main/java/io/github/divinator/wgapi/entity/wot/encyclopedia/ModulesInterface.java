package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Sergey Divin
 */
public interface ModulesInterface {

    /**
     * Сущность описывает харатеристику снаряда орудия.
     */
    class Ammo {

        @SerializedName("damage")
        private List<Integer> damage;

        @SerializedName("penetration")
        private List<Integer> penetration;

        @SerializedName("type")
        private String type;

        @SerializedName("stun")
        private Stun stun;

        /**
         * Метод возвращает Урон (hp).
         * <p>
         * В виде списка значений: min, avg, max
         *
         * @return Урон (hp).
         */
        public List<Integer> getDamage() {
            return damage;
        }

        /**
         * Метод возвращает Пробитие (мм).
         * <p>
         * В виде списка значений: min, avg, max
         *
         * @return Пробитие (мм).
         */
        public List<Integer> getPenetration() {
            return penetration;
        }

        /**
         * Метод возвращает тип снаряда.
         *
         * @return Тип снаряда.
         */
        public String getType() {
            return type;
        }

        /**
         * Метод возвращает характеристики оглушения.
         *
         * @return Характеристики оглушения.
         */
        public Stun getStun() {
            return stun;
        }
    }

    /**
     * Сущность описывает характеристики двигателя.
     */
    class Engine {

        @SerializedName("fire_chance")
        private float fireChance;

        @SerializedName("power")
        private int power;

        /**
         * Метод возвращает вероятность возгорания.
         *
         * @return Вероятность возгорания.
         */
        public float getFireChance() {
            return fireChance;
        }

        /**
         * Метод возвращает мощность двигателя (л.с.).
         *
         * @return Мощность двигателя (л.с.).
         */
        public int getPower() {
            return power;
        }
    }

    /**
     * Сущность описывает характеристики орудия.
     */
    class Gun {

        @SerializedName("aim_time")
        private float aimTime;

        @SerializedName("dispersion")
        private float dispersion;

        @SerializedName("fire_rate")
        private float fireRate;

        @SerializedName("max_ammo")
        private int max_ammo;

        @SerializedName("move_down_arc")
        private int moveDownArc;

        @SerializedName("move_up_arc")
        private int moveUpArc;

        @SerializedName("reload_time")
        private float reloadTime;

        @SerializedName("traverse_speed")
        private int traverseSpeed;

        /**
         * Метод возвращает время сведения (с).
         *
         * @return Время сведения (с).
         */
        public float getAimTime() {
            return aimTime;
        }

        /**
         * Метод возвращает разброс на 100 м (м).
         *
         * @return Разброс на 100 м (м).
         */
        public float getDispersion() {
            return dispersion;
        }

        /**
         * Метод возвращает скорострельность (выстр/мин).
         *
         * @return Скорострельность (выстр/мин).
         */
        public float getFireRate() {
            return fireRate;
        }

        /**
         * Метод возвращает угол ВН вниз (град).
         *
         * @return Угол ВН вниз (град).
         */
        public int getMoveDownArc() {
            return moveDownArc;
        }

        /**
         * Метод возвращает угол ВН вверх (град).
         *
         * @return Угол ВН вверх (град).
         */
        public int getMoveUpArc() {
            return moveUpArc;
        }


        /**
         * Метод возвращает время перезарядки (с).
         *
         * @return Время перезарядки (с).
         */
        public float getReloadTime() {
            return reloadTime;
        }


        /**
         * Метод возвращает скорость поворота (град/с).
         *
         * @return Скорость поворота (град/с).
         */
        public int getTraverseSpeed() {
            return traverseSpeed;
        }
    }

    /**
     * Сущность описывает характеристики радиостанции.
     */
    class Radio {

        @SerializedName("signal_range")
        private int signalRange;

        /**
         * Метод возвращает дальность связи.
         *
         * @return Дальность связи.
         */
        public int getSignalRange() {
            return signalRange;
        }
    }

    /**
     * Сущность описывает характеристики оглушения.
     */
    class Stun {

        @SerializedName("duration")
        private List<Float> duration;

        /**
         * Метод возвращает Характеристики оглушения
         * <p>
         * Время оглушения (с), причиняемого данным типом снарядов, в виде списка значений: min, max
         *
         * @return Характеристики оглушения
         */
        public List<Float> getDuration() {
            return duration;
        }
    }

    /**
     * Сущность описывает характеристики машин в осадном режиме.
     */
    class Suspension {

        @SerializedName("load_limit")
        private int loadLimit;

        @SerializedName("traverse_speed")
        private int traverseSpeed;

        /**
         * Метод возвращает максимальная нагрузка (кг).
         *
         * @return Максимальная нагрузка (кг).
         */
        public int getLoadLimit() {
            return loadLimit;
        }

        /**
         * Метод возвращает скорость поворота (град/с).
         *
         * @return Скорость поворота (град/с).
         */
        public int getTraverseSpeed() {
            return traverseSpeed;
        }
    }

    /**
     * Сущность описывает характеристики башни.
     */
    class Turret {

        @SerializedName("hp")
        private int hp;

        @SerializedName("armor_front")
        private int armorFront;

        @SerializedName("armor_rear")
        private int armorRear;

        @SerializedName("armor_sides")
        private int armorSides;

        @SerializedName("traverse_speed")
        private Object traverseSpeed;

        @SerializedName("view_range")
        private int viewRange;

        /**
         * Метод возвращает прочность.
         *
         * @return Прочность.
         */
        public int getHp() {
            return hp;
        }


        /**
         * Метод возвращает скорость поворота (град/с).
         *
         * @return Скорость поворота (град/с).
         */
        public int getTraverseSpeed() {
            return (int) traverseSpeed;
        }

        /**
         * Метод возвращает Обзор (м).
         *
         * @return Обзор (м).
         */
        public int getViewRange() {
            return viewRange;
        }

        /**
         * Метод возвращает лобовую броню (мм).
         *
         * @return Лобовая броня (мм).
         */
        public int getArmorFront() {
            return armorFront;
        }

        /**
         * Метод возвращает кормовую броню (мм).
         *
         * @return Кормовая броня (мм).
         */
        public int getArmorRear() {
            return armorRear;
        }

        /**
         * Метод возвращает броню борта (мм).
         *
         * @return Броня борта (мм).
         */
        public int getArmorSides() {
            return armorSides;
        }
    }
}
