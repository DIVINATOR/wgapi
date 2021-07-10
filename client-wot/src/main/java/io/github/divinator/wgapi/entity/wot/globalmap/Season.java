package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

import java.util.List;

/**
 * Класс описывает сущность "Информацию о сезоне на Глобальной карте" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class Season {

    @SerializedName("end")
    private String end;

    @SerializedName("season_id")
    private String seasonId;

    @SerializedName("season_name")
    private String seasonName;

    @SerializedName("start")
    private String start;

    @SerializedName("status")
    private String status;

    private List<Front> fronts;

    /**
     * Метод возвращает время окончания сезона.
     *
     * @return Время окончания сезона.
     */
    public String getEnd() {
        return end;
    }

    /**
     * Метод возвращает идентификатор сезона.
     *
     * @return Идентификатор сезона.
     */
    public String getSeasonId() {
        return seasonId;
    }

    /**
     * Метод возвращает название сезона.
     *
     * @return Название сезона.
     */
    public String getSeasonName() {
        return seasonName;
    }

    /**
     * Метод возвращает время начала.
     *
     * @return Время начала.
     */
    public String getStart() {
        return start;
    }

    /**
     * Метод возвращает статус сезона.
     * <p>Допустимые значения:
     * "PLANNED" — Предстоящий сезон
     * "ACTIVE" — Текущий сезон
     * "FINISHED" — Сезон завершён
     *
     * @return Статус сезона.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Метод возвращает Фронты сезона.
     * <p>
     * В ответе представлены только фронты сезона.
     *
     * @return Фронты сезона.
     */
    public List<Front> getFronts() {
        return fronts;
    }

    /**
     * Сущность описывает Фронт сезона.
     */
    public static class Front {

        @SerializedName("front_id")
        private String frontId;

        @SerializedName("front_name")
        private String frontName;

        @SerializedName("url")
        private String url;

        /**
         * Метод возвращает идентификатор фронта.
         *
         * @return Идентификатор фронта.
         */
        public String getFrontId() {
            return frontId;
        }

        /**
         * Метод возвращает название фронта.
         *
         * @return Название фронта.
         */
        public String getFrontName() {
            return frontName;
        }

        /**
         * Метод возвращает ссылку на фронт.
         *
         * @return Ссылка на фронт.
         */
        public String getUrl() {
            return url;
        }
    }
}
