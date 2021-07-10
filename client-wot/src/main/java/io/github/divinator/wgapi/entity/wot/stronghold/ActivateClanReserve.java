package io.github.divinator.wgapi.entity.wot.stronghold;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.StrongholdMethod;

/**
 * Класс описывает сущность "Активация доступного кланового резерва в «Укрепрайоне»" для метод-блока {@link StrongholdMethod}
 *
 * @author Sergey Divin
 */
public final class ActivateClanReserve {

    @SerializedName("activated_at")
    private int activatedAt;

    /**
     * Метод возвращает время активации кланового резерва.
     *
     * @return Время активации кланового резерва.
     */
    public int getActivatedAt() {
        return activatedAt;
    }
}
