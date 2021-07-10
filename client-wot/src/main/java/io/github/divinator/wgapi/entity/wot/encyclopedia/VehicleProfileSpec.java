package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

/**
 * Класс описывает сущность "Характеристики конфигурации техники" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class VehicleProfileSpec extends Vehicle.DefaultProfile {

    @SerializedName("is_default")
    private boolean isDefault;

    @SerializedName("profile_id")
    private String profileId;

    @SerializedName("tank_id")
    private int tankId;

    /**
     * Метод показывает, что базовая комплектация.
     *
     * @return Показывает, что базовая комплектация.
     */
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * Метод возвращает идентификатор комплектации техники.
     *
     * @return Идентификатор комплектации техники.
     */
    public String getProfileId() {
        return profileId;
    }

    /**
     * Метод возвращает идентификатор техники.
     *
     * @return Идентификатор техники.
     */
    public int getTankId() {
        return tankId;
    }
}
