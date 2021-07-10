package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

/**
 * Класс описывает сущность "Информацию о личном резерве" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class Booster {

    @SerializedName("booster_id")
    private int boosterId;

    @SerializedName("description")
    private String description;

    @SerializedName("expires_at")
    private Object expiresAt;

    @SerializedName("is_auto")
    private boolean isAuto;

    @SerializedName("lifetime")
    private int lifetime;

    @SerializedName("name")
    private String name;

    @SerializedName("price_credit")
    private int priceCredit;

    @SerializedName("price_gold")
    private int priceGold;

    @SerializedName("resource")
    private String resource;

    @SerializedName("images")
    private Images images;

    /**
     * Метод возвращает идентификатор личного резерва.
     *
     * @return Идентификатор личного резерва.
     */
    public int getBoosterId() {
        return boosterId;
    }

    /**
     * Метод возвращает описание личного резерва.
     *
     * @return Описание личного резерва.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод возвращает Время окончания действия личного резерва в формате UTC.
     *
     * @return Время окончания действия личного резерва в формате UTC.
     */
    public int getExpiresAt() {
        return (int) expiresAt;
    }

    /**
     * Метод возвращает флаг автоматической активации личного резерва.
     *
     * @return Флаг автоматической активации личного резерва.
     */
    public boolean isAuto() {
        return isAuto;
    }

    /**
     * Метод возвращает Время действия личного резерва.
     *
     * @return Время действия личного резерва.
     */
    public int getLifetime() {
        return lifetime;
    }

    /**
     * Метод возвращает название личного резерва.
     *
     * @return Название личного резерва.
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
     * Метод возвращает ресурс, на который влияет личный резерв.
     * <p>
     * Допустимые значения: credits, experience, crew_experience, free_experience.
     *
     * @return Ресурс, на который влияет личный резерв.
     */
    public String getResource() {
        return resource;
    }

    /**
     * Метод возвращает изображения личного резерва.
     *
     * @return Изображения личного резерва.
     */
    public Images getImages() {
        return images;
    }

    /**
     * Сущность описывает Изображения личного резерва.
     */
    public static class Images {

        @SerializedName("large")
        private String large;

        @SerializedName("small")
        private String small;

        /**
         * Метод возвращает URL к большому изображению.
         *
         * @return URL к большому изображению.
         */
        public String getLarge() {
            return large;
        }

        /**
         * Метод возвращает URL к малому изображению.
         *
         * @return URL к малому изображению.
         */
        public String getSmall() {
            return small;
        }
    }
}
