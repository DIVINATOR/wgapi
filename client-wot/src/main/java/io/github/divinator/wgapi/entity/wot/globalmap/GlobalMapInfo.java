package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

/**
 * Сущность описывает "Общая информацию о Глобальной карте." для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class GlobalMapInfo {

    @SerializedName("last_turn")
    private int lastTurn;

    @SerializedName("last_turn_calculated_at")
    private int lastTurnCalculatedAt;

    @SerializedName("last_turn_created_at")
    private int lastTurnCreatedAt;

    @SerializedName("state")
    private String state;

    /**
     * Метод возвращает номер последнего рассчитанного хода.
     *
     * @return Номер последнего рассчитанного хода.
     */
    public int getLastTurn() {
        return lastTurn;
    }

    /**
     * Метод возвращает время расчёта последнего хода в UTC.
     *
     * @return Время расчёта последнего хода в UTC.
     */
    public int getLastTurnCalculatedAt() {
        return lastTurnCalculatedAt;
    }

    /**
     * Метод возвращает время создания последнего рассчитанного хода в UTC.
     *
     * @return Время создания последнего рассчитанного хода в UTC.
     */
    public int getLastTurnCreatedAt() {
        return lastTurnCreatedAt;
    }

    /**
     * Метод возвращает Состояние карты
     * <p>
     * Типы состояний: active- активна, frozen- заморожена, turn_calculation_in_progress- происходит расчёт хода
     *
     * @return Состояние карты
     */
    public String getState() {
        return state;
    }
}
