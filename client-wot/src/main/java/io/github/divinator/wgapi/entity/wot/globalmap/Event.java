package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

import java.util.List;

/**
 * Класс описывает сущность "Событие на Глобальной карте" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class Event {

    @SerializedName("end")
    private String end;

    @SerializedName("event_id")
    private String eventId;

    @SerializedName("event_name")
    private String eventName;

    @SerializedName("start")
    private String start;

    @SerializedName("status")
    private String status;

    @SerializedName("fronts")
    private List<Front> fronts;

    /**
     * Метод возвращает время окончания события.
     *
     * @return Время окончания события.
     */
    public String getEnd() {
        return end;
    }

    /**
     * Метод возвращает идентификатор события.
     *
     * @return Идентификатор события.
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * Метод возвращает название события.
     *
     * @return Название события.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Метод возвращает время начала события.
     *
     * @return Время начала события.
     */
    public String getStart() {
        return start;
    }

    /**
     * Метод возвращает статус события.
     *
     * @return Статус события.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Метод возвращает фронты события.
     *
     * @return Фронты события.
     */
    public List<Front> getFronts() {
        return fronts;
    }

    /**
     * Сущность описывает фронт события.
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
         * Метод возвращает ссылка на фронт.
         *
         * @return Ссылка на фронт.
         */
        public String getUrl() {
            return url;
        }
    }
}
