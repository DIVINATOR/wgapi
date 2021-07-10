package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

import java.util.Map;

/**
 * Класс описывает сущность "Информацию о Танкопедии" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class EncyclopediaInfo {

    @SerializedName("game_version")
    private String gameVersion;

    @SerializedName("languages")
    private Map<String, String> languages;

    @SerializedName("tanks_updated_at")
    private int tanksUpdatedAt;

    @SerializedName("vehicle_crew_roles")
    private Map<String, String> vehicleCrewRoles;

    @SerializedName("vehicle_nations")
    private Map<String, String> vehicleNations;

    @SerializedName("vehicle_types")
    private Map<String, String> vehicleTypes;

    @SerializedName("achievement_sections")
    private Map<String, AchievementSection> achievementSections;

    /**
     * Метод возвращает версию игрового клиента.
     *
     * @return Версия игрового клиента.
     */
    public String getGameVersion() {
        return gameVersion;
    }

    /**
     * Метод возвращает список поддерживаемых языков.
     *
     * @return Список поддерживаемых языков.
     */
    public Map<String, String> getLanguages() {
        return languages;
    }

    /**
     * Метод возвращает время обновления информации о технике в энциклопедии.
     *
     * @return Время обновления информации о технике в энциклопедии.
     */
    public int getTanksUpdatedAt() {
        return tanksUpdatedAt;
    }

    /**
     * Метод возвращает возможные специальности экипажа.
     *
     * @return Возможные специальности экипажа.
     */
    public Map<String, String> getVehicleCrewRoles() {
        return vehicleCrewRoles;
    }

    /**
     * Метод возвращает доступные нации.
     *
     * @return Доступные нации.
     */
    public Map<String, String> getVehicleNations() {
        return vehicleNations;
    }

    /**
     * Метод возвращает возможные типы техники.
     *
     * @return Возможные типы техники.
     */
    public Map<String, String> getVehicleTypes() {
        return vehicleTypes;
    }

    /**
     * Метод возвращает разделы наград.
     *
     * @return Разделы наград.
     */
    public Map<String, AchievementSection> getAchievementSections() {
        return achievementSections;
    }

    /**
     * Сущность описывает раздел наград.
     */
    public static class AchievementSection {

        @SerializedName("name")
        private String name;

        @SerializedName("order")
        private int order;

        /**
         * Метод возвращает название раздела наград.
         *
         * @return Название раздела наград.
         */
        public String getName() {
            return name;
        }

        /**
         * Метод возвращает порядок раздела наград.
         *
         * @return Порядок раздела наград.
         */
        public int getOrder() {
            return order;
        }
    }
}
