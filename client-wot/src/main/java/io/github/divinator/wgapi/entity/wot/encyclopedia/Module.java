package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

import java.util.List;

/**
 * Класс описывает сущность "Доступный модуль" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class Module {

    @SerializedName("image")
    private String image;

    @SerializedName("module_id")
    private int moduleId;

    @SerializedName("name")
    private String name;

    @SerializedName("nation")
    private String nation;

    @SerializedName("price_credit")
    private int priceCredit;

    @SerializedName("tanks")
    private List<Integer> tanks;

    @SerializedName("tier")
    private int tier;

    @SerializedName("type")
    private String type;

    @SerializedName("weight")
    private int weight;

    @SerializedName("default_profile")
    private DefaultProfile defaultProfile;

    /**
     * Метод возвращает ссылку на изображение.
     *
     * @return Ссылка на изображение.
     */
    public String getImage() {
        return image;
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
     * Метод возвращает нацию.
     *
     * @return Нация.
     */
    public String getNation() {
        return nation;
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
     * Метод возвращает совместимую с модулем технику.
     *
     * @return Совместимая с модулем техника.
     */
    public List<Integer> getTanks() {
        return tanks;
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
     * Метод возвращает тип модуля.
     *
     * @return Тип модуля.
     */
    public String getType() {
        return type;
    }

    /**
     * Метод возвращает Массу (кг).
     *
     * @return Масса (кг).
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Метод возвращает базовые технические характеристики модуля.
     * <p>
     * Дополнительное поле.
     *
     * @return Базовые технические характеристики модуля
     */
    public DefaultProfile getDefaultProfile() {
        return defaultProfile;
    }

    /**
     * Сущность описывает базовые технические характеристики модулей
     */
    public static class DefaultProfile {

        @SerializedName("engine")
        private ModulesInterface.Engine engine;

        @SerializedName("gun")
        private ModulesInterface.Gun gun;

        @SerializedName("ammo")
        private ModulesInterface.Ammo ammo;

        @SerializedName("radio")
        private ModulesInterface.Radio radio;

        @SerializedName("suspension")
        private ModulesInterface.Suspension suspension;

        @SerializedName("turret")
        private ModulesInterface.Turret turret;

        /**
         * Метод возвращает характеристики двигателя.
         *
         * @return Характеристики двигателя.
         */
        public ModulesInterface.Engine getEngine() {
            return engine;
        }

        /**
         * Метод возвращает характеристики орудия.
         *
         * @return Характеристики орудия.
         */
        public ModulesInterface.Gun getGun() {
            return gun;
        }

        /**
         * Метод возвращает харатеристики снарядов орудия.
         *
         * @return Харатеристики снарядов орудия.
         */
        public ModulesInterface.Ammo getAmmo() {
            return ammo;
        }

        /**
         * Метод возвращает характеристики радиостанции.
         *
         * @return Характеристики радиостанции.
         */
        public ModulesInterface.Radio getRadio() {
            return radio;
        }

        /**
         * Метод возвращает характеристики ходовой.
         *
         * @return Характеристики ходовой.
         */
        public ModulesInterface.Suspension getSuspension() {
            return suspension;
        }

        /**
         * Метод возвращает характеристики башни.
         *
         * @return Характеристики башни.
         */
        public ModulesInterface.Turret getTurret() {
            return turret;
        }
    }
}
