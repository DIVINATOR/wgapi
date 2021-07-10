package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

/**
 * Класс описывает сущность "Характеристики комплектации техники" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class VehicleProfile {

    @SerializedName("is_default")
    private boolean isDefault;

    @SerializedName("price_credit")
    private int priceCredit;

    @SerializedName("profile_id")
    private String profileId;

    @SerializedName("tank_id")
    private int tankId;

    /**
     * Метод показывает базовая комплектация или нет.
     * @return Показывает базовая комплектация или нет.
     */
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * Метод возвращает стоимость в кредитах.
     * @return Стоимость в кредитах.
     */
    public int getPriceCredit() {
        return priceCredit;
    }

    /**
     * Метод возвращает идентификатор комплектации техники.
     * @return Идентификатор комплектации техники.
     */
    public String getProfileId() {
        return profileId;
    }

    /**
     * Метод возвращает идентификатор техники.
     * @return Идентификатор техники.
     */
    public int getTankId() {
        return tankId;
    }
}
