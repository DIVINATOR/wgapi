package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

/**
 * Класс описывает сущность "Доступное оборудование и снаряжение" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class Provision {

    @SerializedName("description")
    private String description;

    @SerializedName("image")
    private String image;

    @SerializedName("name")
    private String name;

    @SerializedName("price_credit")
    private int priceCredit;

    @SerializedName("price_gold")
    private int priceGold;

    @SerializedName("provision_id")
    private int provisionId;

    @SerializedName("tag")
    private String tag;

    @SerializedName("type")
    private String type;

    @SerializedName("weight")
    private Object weight;

    /**
     * Метод возвращает описание достижения.
     *
     * @return Описание достижения.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод возвращает ссылку на изображение.
     *
     * @return Ссылка на изображение.
     */
    public String getImage() {
        return image;
    }

    /**
     * Метод возвращает название техники.
     *
     * @return Название техники.
     */
    public String getName() {
        return name;
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
     * Метод возвращает стоимость в золоте.
     *
     * @return Стоимость в золоте.
     */
    public int getPriceGold() {
        return priceGold;
    }

    /**
     * Метод возвращает идентификатор оборудования или снаряжения.
     *
     * @return Идентификатор оборудования или снаряжения.
     */
    public int getProvisionId() {
        return provisionId;
    }

    /**
     * Метод возвращает техническое название.
     *
     * @return Техническое название.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Метод возвращает тип оборудования.
     * <p>
     * Снаряжение или оборудование
     *
     * @return Тип оборудования.
     */
    public String getType() {
        return type;
    }

    /**
     * Метод возвращает массу в килограммах.
     * <p>
     * Только для оборудования.
     *
     * @return Масса в килограммах.
     */
    public int getWeight() {
        return (int) weight;
    }
}
