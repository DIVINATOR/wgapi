package io.github.divinator.wgapi.entity.wot.encyclopedia;


import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает сущность "Доступная техника в энциклопедии" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class Vehicle {

    @SerializedName("description")
    private String description;

    @SerializedName("engines")
    private List<Integer> engines;

    @SerializedName("guns")
    private List<Integer> guns;

    @SerializedName("is_gift")
    private boolean isGift;

    @SerializedName("is_premium")
    private boolean isPremium;

    @SerializedName("is_wheeled")
    private boolean isWheeled;

    @SerializedName("name")
    private String name;

    @SerializedName("nation")
    private String nation;

    @SerializedName("next_tanks")
    private Map<Integer, Integer> nextTanks;

    @SerializedName("price_credit")
    private Object priceCredit;

    @SerializedName("price_gold")
    private Object priceGold;

    @SerializedName("prices_xp")
    private Map<Integer, Integer> pricesXp;

    @SerializedName("provisions")
    private List<Integer> provisions;

    @SerializedName("radios")
    private List<Integer> radios;

    @SerializedName("short_name")
    private String shortName;

    @SerializedName("suspensions")
    private List<Integer> suspensions;

    @SerializedName("tag")
    private String tag;

    @SerializedName("tank_id")
    private int tankId;

    @SerializedName("tier")
    private int tier;

    @SerializedName("turrets")
    private List<Integer> turrets;

    @SerializedName("type")
    private String type;

    @SerializedName("crew")
    private List<Crew> crew;

    @SerializedName("default_profile")
    private DefaultProfile defaultProfile;

    @SerializedName("images")
    private Images images;

    @SerializedName("modules_tree")
    private Map<String, Module> modulesTree;

    /**
     * Метод возвращает описание техники.
     *
     * @return Описание техники.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод возвращает список идентификаторов совместимых двигателей.
     *
     * @return Список идентификаторов совместимых двигателей.
     */
    public List<Integer> getEngines() {
        return engines;
    }

    /**
     * Метод возвращает список идентификаторов совместимых орудий.
     *
     * @return Список идентификаторов совместимых орудий.
     */
    public List<Integer> getGuns() {
        return guns;
    }

    /**
     * Метод возвращает показывает, является ли техника подарочной.
     *
     * @return Показывает, является ли техника подарочной.
     */
    public boolean isGift() {
        return isGift;
    }

    /**
     * Метод возвращает показывает, является ли техника премиум техникой.
     *
     * @return Показывает, является ли техника премиум техникой.
     */
    public boolean isPremium() {
        return isPremium;
    }

    /**
     * Метод возвращает показывает, является ли техника колёсной.
     *
     * @return Показывает, является ли техника колёсной.
     */
    public boolean isWheeled() {
        return isWheeled;
    }

    /**
     * Метод возвращает название техники
     *
     * @return Название техники
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает нацию техники.
     *
     * @return Нация техники.
     */
    public String getNation() {
        return nation;
    }

    /**
     * Метод возвращает Список доступной для исследования техники
     * <p>
     * В виде пар:
     * - идентификатор исследуемой техники
     * - стоимость исследования в опыте
     *
     * @return Список доступной для исследования техники.
     */
    public Map<Integer, Integer> getNextTanks() {
        return nextTanks;
    }

    /**
     * Метод возвращает стоимость в кредитах.
     *
     * @return Стоимость в кредитах.
     */
    public int getPriceCredit() {
        return (int) priceCredit;
    }

    /**
     * Метод возвращает стоимость в золоте.
     *
     * @return Стоимость в золоте.
     */
    public int getPriceGold() {
        return (int) priceGold;
    }

    /**
     * Метод возвращает список значений стоимости
     * <p>
     * В виде пар:
     * - идентификатор родительской техники
     * - стоимость исследования в опыте
     *
     * @return Список доступной для исследования техники.
     */
    public Map<Integer, Integer> getPricesXp() {
        return pricesXp;
    }

    /**
     * Метод возвращает список идентификаторов совместимого оборудования и снаряжения.
     *
     * @return Список идентификаторов совместимого оборудования и снаряжения.
     */
    public List<Integer> getProvisions() {
        return provisions;
    }

    /**
     * Метод возвращает список идентификаторов устанавливаемых радиостанций.
     *
     * @return Список идентификаторов устанавливаемых радиостанций.
     */
    public List<Integer> getRadios() {
        return radios;
    }

    /**
     * Метод возвращает сокращённое название техники.
     *
     * @return Сокращённое название техники.
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Метод возвращает список идентификаторов совместимых ходовых.
     *
     * @return Список идентификаторов совместимых ходовых.
     */
    public List<Integer> getSuspensions() {
        return suspensions;
    }

    /**
     * Метод возвращает тег техники.
     *
     * @return Тег техники.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Метод возвращает идентификатор техники.
     *
     * @return Идентификатор техники.
     */
    public int getTankId() {
        return tankId;
    }

    /**
     * Метод возвращает уровень техники.
     *
     * @return Уровень техники.
     */
    public int getTier() {
        return tier;
    }

    /**
     * Метод возвращает cписок идентификаторов совместимых башен.
     *
     * @return Список идентификаторов совместимых башен.
     */
    public List<Integer> getTurrets() {
        return turrets;
    }

    /**
     * Метод возвращает тип техники.
     *
     * @return Тип техники.
     */
    public String getType() {
        return type;
    }

    /**
     * Метод возвращает экипаж.
     *
     * @return Экипаж.
     */
    public List<Crew> getCrew() {
        return crew;
    }

    /**
     * Метод возвращает характеристики базовой комплектации.
     *
     * @return Характеристики базовой комплектации.
     */
    public DefaultProfile getDefaultProfile() {
        return defaultProfile;
    }

    /**
     * Метод возвращает изображения техники.
     *
     * @return Изображения техники.
     */
    public Images getImages() {
        return images;
    }

    /**
     * Метод возвращает информацию об исследовании модулей.
     *
     * @return Информация об исследовании модулей.
     */
    public Map<String, Module> getModulesTree() {
        return modulesTree;
    }

    /**
     * Сущность описывает члена экипажа
     */
    public static class Crew {

        @SerializedName("member_id")
        private String memberId;

        @SerializedName("roles")
        private Map<String, String> roles;

        /**
         * Метод возвращает идентификатор члена экипажа.
         *
         * @return Идентификатор члена экипажа.
         */
        public String getMemberId() {
            return memberId;
        }

        /**
         * Метод возвращает список должностей члена экипажа.
         *
         * @return Список должностей члена экипажа.
         */
        public Map<String, String> getRoles() {
            return roles;
        }
    }

    /**
     * Сущность описывает характеристики базовой комплектации техники
     */
    public static class DefaultProfile {

        @SerializedName("hp")
        private int hp;

        @SerializedName("hull_hp")
        private int hullHp;

        @SerializedName("hull_weight")
        private int hullWeight;

        @SerializedName("max_ammo")
        private int maxAmmo;

        @SerializedName("max_weight")
        private int maxWeight;

        @SerializedName("speed_backward")
        private int speedBackward;

        @SerializedName("speed_forward")
        private int speedForward;

        @SerializedName("weight")
        private int weight;

        @SerializedName("ammo")
        private List<ModulesInterface.Ammo> ammo;

        @SerializedName("armor")
        private Armor armor;

        @SerializedName("engine")
        private Engine engine;

        @SerializedName("gun")
        private Gun gun;

        @SerializedName("radio")
        private Radio radio;

        @SerializedName("rapid")
        private Rapid rapid;

        @SerializedName("siege")
        private Siege siege;

        @SerializedName("suspension")
        private Suspension suspension;

        @SerializedName("turret")
        private Turret turret;

        @SerializedName("modules")
        private Modules modules;

        /**
         * Метод возвращает прочность.
         *
         * @return Прочность.
         */
        public int getHp() {
            return hp;
        }

        /**
         * Метод возвращает прочность корпуса.
         *
         * @return Прочность корпуса.
         */
        public int getHullHp() {
            return hullHp;
        }

        /**
         * Метод возвращает массу корпуса (кг).
         *
         * @return Масса корпуса (кг).
         */
        public int getHullWeight() {
            return hullWeight;
        }

        /**
         * Метод возвращает боекомплект.
         *
         * @return Боекомплект.
         */
        public int getMaxAmmo() {
            return maxAmmo;
        }

        /**
         * Метод возвращает предельную массу (кг).
         *
         * @return Предельная масса (кг).
         */
        public int getMaxWeight() {
            return maxWeight;
        }

        /**
         * Метод возвращает макс. скорость заднего хода (км/ч).
         *
         * @return Макс. скорость заднего хода (км/ч).
         */
        public int getSpeedBackward() {
            return speedBackward;
        }

        /**
         * Метод возвращает максимальную скорость.
         *
         * @return Максимальная скорость.
         */
        public int getSpeedForward() {
            return speedForward;
        }

        /**
         * Метод возвращает массу (кг).
         *
         * @return Массу (кг).
         */
        public int getWeight() {
            return weight;
        }

        /**
         * Метод возвращает харатеристики снарядов орудия.
         *
         * @return Харатеристики снарядов орудия.
         */
        public List<ModulesInterface.Ammo> getAmmo() {
            return ammo;
        }

        /**
         * Метод возвращает бронирование.
         *
         * @return Бронирование.
         */
        public Armor getArmor() {
            return armor;
        }

        /**
         * Метод возвращает характеристики двигателя.
         *
         * @return Характеристики двигателя.
         */
        public Engine getEngine() {
            return engine;
        }

        /**
         * Метод возвращает характеристики орудия.
         *
         * @return Характеристики орудия.
         */
        public Gun getGun() {
            return gun;
        }

        /**
         * Метод возвращает характеристики радиостанции.
         *
         * @return Характеристики радиостанции.
         */
        public Radio getRadio() {
            return radio;
        }

        /**
         * Метод возвращает характеристики машин в скоростном режиме (для колёсной техники).
         *
         * @return Характеристики машин в скоростном режиме (для колёсной техники).
         */
        public Rapid getRapid() {
            return rapid;
        }

        /**
         * Метод возвращает характеристики машин в осадном режиме.
         *
         * @return Характеристики машин в осадном режиме.
         */
        public Siege getSiege() {
            return siege;
        }

        /**
         * Метод возвращает характеристики ходовой.
         *
         * @return Характеристики ходовой.
         */
        public Suspension getSuspension() {
            return suspension;
        }

        /**
         * Метод возвращает характеристики башни.
         *
         * @return Характеристики башни.
         */
        public Turret getTurret() {
            return turret;
        }

        /**
         * Метод возвращает установленные модули.
         *
         * @return Установленные модули.
         */
        public Modules getModules() {
            return modules;
        }

        /**
         * Сущность описывает бронирование.
         */
        public static class Armor {

            @SerializedName("hull")
            private Value hull;

            @SerializedName("turret")
            private Value turret;

            /**
             * Метод возвращает бронирование корпуса.
             *
             * @return Бронирование корпуса.
             */
            public Value getHull() {
                return hull;
            }

            /**
             * Метод возвращает бронирование башни.
             *
             * @return Бронирование башни.
             */
            public Value getTurret() {
                return turret;
            }

            /**
             * Класс описывает сущность значений бронирования.
             */
            public static class Value {

                @SerializedName("front")
                private int front;

                @SerializedName("rear")
                private int rear;

                @SerializedName("sides")
                private int sides;

                /**
                 * Метод возвращает лобовое бронирование (мм).
                 *
                 * @return лобовое бронирование (мм).
                 */
                public int getFront() {
                    return front;
                }

                /**
                 * Метод возвращает бронирование кормы (мм).
                 *
                 * @return Бронирование кормы (мм).
                 */
                public int getRear() {
                    return rear;
                }

                /**
                 * Метод возвращает бронирование борта (мм).
                 *
                 * @return Бронирование борта (мм).
                 */
                public int getSides() {
                    return sides;
                }
            }
        }

        /**
         * Сущность описывает характеристики двигателя.
         */
        public static class Engine extends ModulesInterface.Engine{

            @SerializedName("name")
            private String name;

            @SerializedName("tag")
            private String tag;

            @SerializedName("tier")
            private int tier;

            @SerializedName("weight")
            private int weight;

            /**
             * Метод возвращает название модуля.
             *
             * @return Название модуля.
             */
            public String getName() {
                return name;
            }

            /**
             * Метод возвращает тег модуля.
             *
             * @return Тег модуля.
             */
            public String getTag() {
                return tag;
            }

            /**
             * Метод возвращает уровень.
             *
             * @return Уровень.
             */
            public int getTier() {
                return tier;
            }

            /**
             * Метод возвращает массу (кг).
             *
             * @return Масса (кг).
             */
            public int getWeight() {
                return weight;
            }
        }

        /**
         * Сущность описывает характеристики орудия.
         */
        public static class Gun extends ModulesInterface.Gun{

            @SerializedName("caliber")
            private int caliber;

            @SerializedName("name")
            private String name;

            @SerializedName("tag")
            private String tag;

            @SerializedName("tier")
            private int tier;

            @SerializedName("weight")
            private int weight;

            /**
             * Метод возвращает калибр (мм).
             *
             * @return Калибр (мм).
             */
            public int getCaliber() {
                return caliber;
            }

            /**
             * Метод возвращает название модуля.
             *
             * @return Название модуля.
             */
            public String getName() {
                return name;
            }

            /**
             * Метод возвращает Тег модуля.
             *
             * @return Тег модуля.
             */
            public String getTag() {
                return tag;
            }

            /**
             * Метод возвращает уровень.
             *
             * @return Уровень.
             */
            public int getTier() {
                return tier;
            }

            /**
             * Метод возвращает масса (кг).
             *
             * @return Масса (кг).
             */
            public int getWeight() {
                return weight;
            }
        }

        /**
         * Сущность описывает характеристики радиостанции.
         */
        public static class Radio extends ModulesInterface.Radio{

            @SerializedName("name")
            private String name;

            @SerializedName("tag")
            private String tag;

            @SerializedName("tier")
            private int tier;

            @SerializedName("weight")
            private int weight;

            /**
             * Метод возвращает название модуля.
             *
             * @return Название модуля.
             */
            public String getName() {
                return name;
            }

            /**
             * Метод возвращает тег модуля.
             *
             * @return Тег модуля.
             */
            public String getTag() {
                return tag;
            }

            /**
             * Метод возвращает уровень.
             *
             * @return Уровень.
             */
            public int getTier() {
                return tier;
            }

            /**
             * Метод возвращает массу (кг).
             *
             * @return Масса (кг).
             */
            public int getWeight() {
                return weight;
            }
        }

        /**
         * Сущность описывает характеристики машин в скоростном режиме (для колёсной техники).
         */
        public static class Rapid {

            @SerializedName("speed_backward")
            private int speedBackward;

            @SerializedName("speed_forward")
            private int speedForward;

            @SerializedName("suspension_steering_lock_angle")
            private int suspensionSteeringLockAngle;

            @SerializedName("switch_off_time")
            private float switchOffTime;

            @SerializedName("switch_on_time")
            private float switchOnTime;

            /**
             * Метод возвращает макс. скорость заднего хода (км/ч).
             *
             * @return Макс. скорость заднего хода (км/ч).
             */
            public int getSpeedBackward() {
                return speedBackward;
            }

            /**
             * Метод возвращает максимальную скорость.
             *
             * @return Максимальная скорость.
             */
            public int getSpeedForward() {
                return speedForward;
            }

            /**
             * Метод возвращает максимальный угол поворота колёс.
             *
             * @return Максимальный угол поворота колёс.
             */
            public int getSuspensionSteeringLockAngle() {
                return suspensionSteeringLockAngle;
            }

            /**
             * Метод возвращает время перехода в манёвренный режим.
             *
             * @return Время перехода в манёвренный режим.
             */
            public float getSwitchOffTime() {
                return switchOffTime;
            }

            /**
             * Метод возвращает время перехода в скоростной режим.
             *
             * @return Время перехода в скоростной режим.
             */
            public float getSwitchOnTime() {
                return switchOnTime;
            }
        }

        /**
         * Сущность описывает характеристики машин в осадном режиме.
         */
        public static class Siege {

            @SerializedName("aim_time")
            private float aimTime;

            @SerializedName("dispersion")
            private float dispersion;

            @SerializedName("move_down_arc")
            private int moveDownArc;

            @SerializedName("move_up_arc")
            private int moveUpArc;

            @SerializedName("reload_time")
            private float reloadTime;

            @SerializedName("speed_backward")
            private int speedBackward;

            @SerializedName("suspension_traverse_speed")
            private int suspensionTraverseSpeed;

            @SerializedName("switch_off_time")
            private float switchOffTime;

            @SerializedName("switch_on_time")
            private float switchOnTime;

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
             * Метод возвращает макс. скорость заднего хода (км/ч).
             *
             * @return Макс. скорость заднего хода (км/ч).
             */
            public int getSpeedBackward() {
                return speedBackward;
            }

            /**
             * Метод возвращает скорость поворота базового шасси.
             *
             * @return Скорость поворота базового шасси.
             */
            public int getSuspensionTraverseSpeed() {
                return suspensionTraverseSpeed;
            }

            /**
             * Метод возвращает время выхода из осадного режима.
             *
             * @return Время выхода из осадного режима.
             */
            public float getSwitchOffTime() {
                return switchOffTime;
            }

            /**
             * Метод возвращает время перехода в осадный режим.
             *
             * @return Время перехода в осадный режим.
             */
            public float getSwitchOnTime() {
                return switchOnTime;
            }
        }

        /**
         * Сущность описывает характеристики машин в осадном режиме.
         */
        public static class Suspension extends ModulesInterface.Suspension{

            @SerializedName("name")
            private String name;

            @SerializedName("steering_lock_angle")
            private int steeringLockAngle;

            @SerializedName("tag")
            private String tag;

            @SerializedName("tier")
            private int tier;

            @SerializedName("weight")
            private int weight;

            /**
             * Метод возвращает название модуля.
             *
             * @return Название модуля.
             */
            public String getName() {
                return name;
            }

            /**
             * Метод возвращает максимальный угол поворота колёс (для колёсной техники).
             *
             * @return Максимальный угол поворота колёс (для колёсной техники).
             */
            public int getSteeringLockAngle() {
                return steeringLockAngle;
            }

            /**
             * Метод возвращает тег модуля.
             *
             * @return Тег модуля.
             */
            public String getTag() {
                return tag;
            }

            /**
             * Метод возвращает уровень.
             *
             * @return Уровень.
             */
            public int getTier() {
                return tier;
            }

            /**
             * Метод возвращает массу (кг).
             *
             * @return Масса (кг).
             */
            public int getWeight() {
                return weight;
            }
        }

        /**
         * Сущность описывает характеристики башни.
         */
        public static class Turret extends ModulesInterface.Turret{

            @SerializedName("name")
            private String name;

            @SerializedName("tag")
            private String tag;

            @SerializedName("tier")
            private int tier;

            @SerializedName("traverse_left_arc")
            private int traverseLeftArc;

            @SerializedName("traverse_right_arc")
            private int traverseRightArc;

            @SerializedName("weight")
            private int weight;

            /**
             * Метод возвращает название модуля.
             *
             * @return Название модуля.
             */
            public String getName() {
                return name;
            }

            /**
             * Метод возвращает тег модуля.
             *
             * @return Тег модуля.
             */
            public String getTag() {
                return tag;
            }

            /**
             * Метод возвращает уровень.
             *
             * @return Уровень.
             */
            public int getTier() {
                return tier;
            }

            /**
             * Метод возвращает угол вращения влево (град).
             *
             * @return Угол вращения влево (град).
             */
            public int getTraverseLeftArc() {
                return traverseLeftArc;
            }

            /**
             * Метод возвращает угол вращения вправо (град).
             *
             * @return Угол вращения вправо (град).
             */
            public int getTraverseRightArc() {
                return traverseRightArc;
            }

            /**
             * Метод возвращает массу (кг).
             *
             * @return Масса (кг).
             */
            public int getWeight() {
                return weight;
            }
        }

        /**
         * Сущность описывает установленные модули.
         */
        public static class Modules {

            @SerializedName("engine_id")
            private int engineId;

            @SerializedName("gun_id")
            private int gunId;

            @SerializedName("radio_id")
            private int radioId;

            @SerializedName("suspension_id")
            private int suspensionId;

            @SerializedName("turret_id")
            private Object turretId;

            /**
             * Метод возвращает идентификатор двигателя.
             *
             * @return Идентификатор двигателя.
             */
            public int getEngineId() {
                return engineId;
            }

            /**
             * Метод возвращает идентификатор орудия.
             *
             * @return Идентификатор орудия.
             */
            public int getGunId() {
                return gunId;
            }

            /**
             * Метод возвращает идентификатор радиостанции.
             *
             * @return Идентификатор радиостанции.
             */
            public int getRadioId() {
                return radioId;
            }

            /**
             * Метод возвращает идентификатор ходовой.
             *
             * @return Идентификатор ходовой.
             */
            public int getSuspensionId() {
                return suspensionId;
            }

            /**
             * Метод возвращает идентификатор башни.
             *
             * @return Идентификатор башни.
             */
            public int getTurretId() {
                return (int) turretId;
            }
        }
    }

    /**
     * Сущность описывает Изображения техники
     */
    public static class Images {

        @SerializedName("big_icon")
        private String bigIcon;

        @SerializedName("contour_icon")
        private String contourIcon;

        @SerializedName("small_icon")
        private String smallIcon;

        /**
         * Метод возвращает URL к изображению техники в размере 160 x 100 пкс.
         *
         * @return URL к изображению техники в размере 160 x 100 пкс.
         */
        public String getIconBig() {
            return bigIcon;
        }

        /**
         * Метод возвращает URL к изображению-контуру техники.
         *
         * @return URL к изображению-контуру техники.
         */
        public String getIconContour() {
            return contourIcon;
        }

        /**
         * Метод возвращает URL к изображению техники в размере 124 x 31 пкс.
         *
         * @return URL к изображению техники в размере 124 x 31 пкс.
         */
        public String getIconSmall() {
            return smallIcon;
        }
    }

    /**
     * Сущность описывает информация об исследовании модуля
     */
    public static class Module {

        @SerializedName("is_default")
        private boolean isDefault;

        @SerializedName("module_id")
        private int moduleId;

        @SerializedName("name")
        private String name;

        @SerializedName("next_modules")
        private List<Integer> nextModules;

        @SerializedName("next_tanks")
        private List<Integer> nextTanks;

        @SerializedName("price_credit")
        private int priceCredit;

        @SerializedName("price_xp")
        private int priceXp;

        @SerializedName("type")
        private String type;

        /**
         * Метод показывает, является ли модуль базовым.
         *
         * @return Показывает, является ли модуль базовым.
         */
        public boolean isDefault() {
            return isDefault;
        }

        /**
         * Метод возвращает идентификатор модуля.
         *
         * @return Идентификатор модуля.
         */
        public int getModuleId() {
            return moduleId;
        }

        /**
         * Метод возвращает название модуля.
         *
         * @return Название модуля.
         */
        public String getName() {
            return name;
        }

        /**
         * Метод возвращает список идентификаторов модулей, доступных после исследования модуля.
         *
         * @return Список идентификаторов модулей, доступных после исследования модуля.
         */
        public List<Integer> getNextModules() {
            return nextModules;
        }

        /**
         * Метод возвращает список идентификаторов техники доступной после исследования модуля.
         *
         * @return Список идентификаторов техники доступной после исследования модуля.
         */
        public List<Integer> getNextTanks() {
            return nextTanks;
        }

        /**
         * Метод возвращает стоимость в кредитах.
         *
         * @return Стоимость в кредитах.
         */
        public int getPriceCredit() {
            return priceCredit;
        }

        /**
         * Метод возвращает стоимость исследования.
         *
         * @return Стоимость исследования.
         */
        public int getPriceXp() {
            return priceXp;
        }

        /**
         * Метод возвращает тип модуля.
         *
         * @return Тип модуля.
         */
        public String getType() {
            return type;
        }
    }
}
